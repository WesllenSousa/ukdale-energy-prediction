/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.weka;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import weka.classifiers.evaluation.NumericPrediction;
import weka.classifiers.functions.GaussianProcesses;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.SMOreg;
import weka.classifiers.timeseries.WekaForecaster;
import weka.classifiers.timeseries.core.TSLagMaker;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Wesllen Sousa
 */
public class EnergyPrediction {

    public EnergyPrediction() {
        String dir = "E:\\Dropbox\\Doctor\\Disciplines\\Machile Learning and Data Mining\\Homework\\Experiments\\houses_full\\house2\\per day\\";

        double somaGeral = 0.0;
        int n = 0;
        for (String dataset : listarArquivos(dir)) {

            System.out.println("Dataset: " + dataset);

            try {
                DataSource source = new DataSource(dir + dataset);
                Instances data = source.getDataSet();

                //Define o tamanho do teste
                String t = (Math.ceil(data.size() * 0.3) - 1) + "";
                String[] r = t.replace(".", ",").split(",");
                Integer tamTeste = Integer.parseInt(r[0]);

                // cria dados que serao usados para prime incremental
                ArrayList<Attribute> atts = new ArrayList<>();
                atts.add(new Attribute("timestamp"));
                atts.add(new Attribute("power"));
                Instances newData = new Instances("Empty", atts, 0);
                newData.setClassIndex(newData.numAttributes() - 1); //Define o atributo que sera previsto (atributo alvo)

                // separa treino e teste
                Instances train = new Instances("Train", atts, 0);
                train.setClassIndex(train.numAttributes() - 1);
                for (int i = 0; i < data.numInstances() - tamTeste; i++) {
                    train.add(data.instance(i));
                }
                Instances test = new Instances("Test", atts, 0);
                test.setClassIndex(test.numAttributes() - 1);
                for (int i = data.numInstances() - tamTeste; i < data.numInstances(); i++) {
                    test.add(data.instance(i));
                }

                //================WekaForecaster====================================
                WekaForecaster forecaster = new WekaForecaster();
                forecaster.setFieldsToForecast("power");
                forecaster.setBaseForecaster(new LinearRegression());

                forecaster.getTSLagMaker().setTimeStampField("timestamp");
                forecaster.getTSLagMaker().setMinLag(1);
                forecaster.getTSLagMaker().setMaxLag(12); // monthly data
                forecaster.getTSLagMaker().setAddMonthOfYear(true);
                forecaster.getTSLagMaker().setAddQuarterOfYear(true);

                //Building model
                forecaster.buildForecaster(train);
                forecaster.primeForecaster(train);

                System.out.println(forecaster.getBaseForecaster().toString());
                //==================================================================
                // forecast for 1 units (months) beyond the end of the
                // training data
                List<List<NumericPrediction>> forecast;
                DateTime currentDt = getCurrentDateTime(forecaster.getTSLagMaker());
                //System.out.println("Data\t\tPrevisto\t\tReal");
                double soma = 0;
                for (int i = 0; i < test.numInstances(); i++) {

                    // preve 1 unidade de tempo (mes) alem dos dados de treino
                    forecast = forecaster.forecast(1, System.out);

                    double real = test.instance(i).value(data.numAttributes() - 1);
                    double pred = (forecast.get(0)).get(0).predicted();
                    soma = soma + Math.pow(real - pred, 2);

                    //System.out.println(currentDt.toString("dd/MM/yyyy") + "\t" + pred + "\t" + real);
                    // teste incremental
                    forecaster.primeForecaster(newData);
                    forecaster.primeForecasterIncremental(test.instance(i));
                    // obtenha proxima data
                    currentDt = advanceTime(forecaster.getTSLagMaker(), currentDt);
                }

                n += test.numInstances();
                somaGeral += soma;

                System.out.println("Soma: " + soma + ", instances: " + test.numInstances());

            } catch (Exception ex) {
                Logger.getLogger(EnergyPrediction.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        double rmse = Math.sqrt(somaGeral / n);

        System.out.println("RMSE: " + rmse);
        System.out.println("=========================================");

    }

    private static DateTime getCurrentDateTime(TSLagMaker lm) {
        try {
            return new DateTime((long) lm.getCurrentTimeStampValue());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    // avança para a próxima data de acordo com periodicidade
    private static DateTime advanceTime(TSLagMaker lm, DateTime dt) {
        return new DateTime((long) lm.advanceSuppliedTimeValue(dt.getMillis()));
    }

    public HashSet<String> listarArquivos(String diretorio) {
        File ff = new File(diretorio);
        HashSet<String> hashSet = new HashSet<>();
        File[] arquivos = ff.listFiles();
        if (arquivos != null) {
            int length = arquivos.length;
            for (int i = 0; i < length; ++i) {
                File f = arquivos[i];
                if (f.isFile()) {
                    hashSet.add(f.getName());
                }
            }
        }
        return hashSet;
    }

    public static void main(String[] args) {
        EnergyPrediction l = new EnergyPrediction();
    }

}
