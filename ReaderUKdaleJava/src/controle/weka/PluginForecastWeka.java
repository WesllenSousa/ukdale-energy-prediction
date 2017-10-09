/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.weka;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import weka.classifiers.evaluation.NumericPrediction;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.timeseries.WekaForecaster;
import weka.classifiers.timeseries.core.TSLagMaker;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Wesllen Sousa
 */
public class PluginForecastWeka {

    public PluginForecastWeka() {
        String dir = "E:\\Dropbox\\Doctor\\Disciplines\\Machile Learning and Data Mining\\Homework\\Experiments\\houses_full\\house2_day.arff";

        try {
            DataSource source = new DataSource(dir);
            Instances data = source.getDataSet();

            //Define o tamanho do teste
            String t = (Math.ceil(data.size() * 0.3) - 1) + "";
            String[] r = t.replace(".", ",").split(",");
            Integer tamTeste = Integer.parseInt(r[0]);
            System.out.println(tamTeste);

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
            System.out.println(data.numInstances() - tamTeste);
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

            //==================================================================
            // forecast for 1 units (months) beyond the end of the
            // training data
            List<List<NumericPrediction>> forecast;
            DateTime currentDt = getCurrentDateTime(forecaster.getTSLagMaker());
            System.out.println("Data\tPrevisto\t\tReal");
            for (int i = 0; i < test.numInstances(); i++) {

                // preve 1 unidade de tempo (mes) alem dos dados de treino
                forecast = forecaster.forecast(1, System.out);

                double real = test.instance(i).value(data.numAttributes() - 1);
                NumericPrediction pred = (forecast.get(0)).get(0);

                System.out.println(currentDt.toString("dd/MM/yyyy") + "\t" + pred.predicted() + "\t" + real);

                // teste incremental
                forecaster.primeForecaster(newData);
                forecaster.primeForecasterIncremental(test.instance(i));
                // obtenha proxima data
                currentDt = advanceTime(forecaster.getTSLagMaker(), currentDt);
            }

//            TSEvaluation evaluation = new TSEvaluation(data, 0.3);
//
//            //Error,MAE,MSE,RMSE,MAPE,DAC,RAE,RRSE
////            List<TSEvalModule> modsList = TSEvalModule.getModuleList();
////            String modListS = "";
////            for (TSEvalModule mod : modsList) {
////                modListS += mod.getEvalName() + ",";
////            }
////            modListS = modListS.substring(0, modListS.lastIndexOf(','));
////            System.out.println(modListS);
//            evaluation.setEvaluationModules("MAE,MSE,RMSE,MAPE,DAC,RAE,RRSE");
//
//            evaluation.setEvaluateOnTrainingData(false);
//            evaluation.setEvaluateOnTestData(true);
//            evaluation.setRebuildModelAfterEachTestForecastStep(true);
//            evaluation.setHorizon(1);
//            evaluation.evaluateForecaster(forecaster, false);
//
//            System.out.println(evaluation.toSummaryString());
        } catch (Exception ex) {
            Logger.getLogger(PluginForecastWeka.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public static void main(String[] args) {
        PluginForecastWeka l = new PluginForecastWeka();
    }

}
