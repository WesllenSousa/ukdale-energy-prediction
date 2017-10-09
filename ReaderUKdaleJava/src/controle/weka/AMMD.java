/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.weka;

import java.util.List;
import java.util.ArrayList;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.Attribute;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import org.joda.time.DateTime;
import weka.classifiers.evaluation.NumericPrediction;
import weka.classifiers.timeseries.WekaForecaster;
import weka.classifiers.timeseries.core.TSLagMaker;

/**
 *
 * @author Wesllen Sousa
 */
public class AMMD {

    // obtem data atual (do ponto de vista do previsor)
    private static DateTime getCurrentDateTime(TSLagMaker lm) throws Exception {
        return new DateTime((long) lm.getCurrentTimeStampValue());
    }

    // avança para a próxima data de acordo com periodicidade
    private static DateTime advanceTime(TSLagMaker lm, DateTime dt) {
        return new DateTime((long) lm.advanceSuppliedTimeValue(dt.getMillis()));
    }

    public static void main(String[] args)
            throws Exception {
        String dir = "E:\\Dropbox\\Doctor\\Disciplines\\Machile Learning and Data Mining\\Homework\\Experiments\\houses_full\\house2_day.arff";

        int tamTeste = 62;
        Instances data = (new DataSource(dir)).getDataSet();

        // cria dados que serao usados para prime incremental
        ArrayList<Attribute> atts = new ArrayList<Attribute>();
        atts.add(new Attribute("timestamp"));
        atts.add(new Attribute("power"));
        Instances newData = new Instances("Empty", atts, 0);
        newData.setClassIndex(newData.numAttributes() - 1);

        // separa treino e teste
        Instances train = new Instances("Train", atts, 0);
        train.setClassIndex(train.numAttributes() - 1);
        Instances test = new Instances("Test", atts, 0);
        test.setClassIndex(test.numAttributes() - 1);

        for (int i = 0; i < data.numInstances() - tamTeste; i++) {
            train.add(data.instance(i));
        }
        for (int i = data.numInstances() - tamTeste; i < data.numInstances(); i++) {
            test.add(data.instance(i));
        }

        // cria instancia de Forecaster
        WekaForecaster forecaster = new WekaForecaster();
        forecaster.setFieldsToForecast("power");
        forecaster.setBaseForecaster(new LinearRegression());
        forecaster.getTSLagMaker().setTimeStampField("timestamp");
        forecaster.getTSLagMaker().setMinLag(1);
        forecaster.getTSLagMaker().setMaxLag(12);
        forecaster.getTSLagMaker().setAddMonthOfYear(true);
        forecaster.getTSLagMaker().setAddQuarterOfYear(true);
        forecaster.buildForecaster(train, System.out);

        // inicia o previsor com dados historicos que cobrem até o máximo lag.
        forecaster.primeForecaster(train);

        // exibe previsoes
        List<List<NumericPrediction>> forecast;
        DateTime currentDt = getCurrentDateTime(forecaster.getTSLagMaker());
        System.out.println("Data\tPrevisto\t\tReal");
        for (int i = 0; i < test.numInstances(); i++) {
            // preve 1 unidade de tempo (mes) alem dos dados de treino
            forecast = forecaster.forecast(1, System.out);

            // para cada mes
            NumericPrediction pred = (forecast.get(0)).get(0);
            double real = test.instance(i).value(data.numAttributes() - 1);
            System.out.println(currentDt.toString("dd/MM/yyyy") + "\t"
                    + pred.predicted() + "\t" + real);
            // teste incremental
            forecaster.primeForecaster(newData);
            forecaster.primeForecasterIncremental(test.instance(i));
            // obtenha proxima data
            currentDt = advanceTime(forecaster.getTSLagMaker(), currentDt);
        }
    }

}
