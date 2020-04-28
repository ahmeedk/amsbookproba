package bookexos.continuous;

import bookexos.discreteproba.Exercises;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MutipleGraphRender extends Application {

    private Scene scene;

    private Exercises exercises = new Exercises();

    private ContinuousProbaExercises continuousProbaExercises = new ContinuousProbaExercises();
    private Examples examples = new Examples();
    private double[][] data_1;
    private double[][] data_2;

    private CategoryAxis xAxis = new CategoryAxis();
    private NumberAxis yAxis = new NumberAxis();

    @Override
    public void init() {

        int n = 100000;
        data_1 = continuousProbaExercises.exercise_10(n);

        data_2 = new double[25][2];
        for (int j = 0; j < 10; j++) {
            data_2[j][0] = j * 0.1 + 0.05;
            data_2[j][1] = 2 - 2 * data_2[j][0];
        }

//        data_1 = continuousProbaExercises.exercise_9(n);
//
//        data_2 = new double[25][2];
//        for (int j = 0; j < 25; j++) {
//            data_2[j][0] = j * 5 + 2.5;
//            data_2[j][1] = ((double) 1 / 30) * Math.exp(((double) -1 / 30) * data_2[j][0]);
//        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        StackPane root = new StackPane();

        BarChart barChart = getBarChart(data_1);
        root.getChildren().add(barChart);

        LineChart lineChart = getLineChart(data_2);
        root.getChildren().add(lineChart);

        this.scene = new Scene(root, 1500, 700);

        primaryStage.setTitle(" distribution graph");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private BarChart getBarChart(double[][] data) {

        BarChart barChart = new BarChart(xAxis, yAxis);
        barChart.setLegendVisible(false);
        barChart.setAnimated(false);

        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < data.length; i++) {
            series.getData().add(new XYChart.Data(String.valueOf(data[i][0]), data[i][1]));
        }
        //Setting the data to barChart
        barChart.getData().add(series);

        return barChart;
    }

    private LineChart getLineChart(double[][] data) {

        LineChart lineChart = new LineChart(xAxis, yAxis);
        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < data.length; i++) {
            series.getData().add(new XYChart.Data(String.valueOf(data[i][0]), data[i][1]));
        }

        //Setting the data to Line chart
        lineChart.getData().add(series);

        lineChart.setLegendVisible(false);
        lineChart.setAnimated(false);
        lineChart.setCreateSymbols(true);
        lineChart.setAlternativeRowFillVisible(false);
        lineChart.setAlternativeColumnFillVisible(false);
        lineChart.setHorizontalGridLinesVisible(false);
        lineChart.setVerticalGridLinesVisible(false);
        lineChart.getXAxis().setVisible(false);
        lineChart.getYAxis().setVisible(false);
        java.net.URL rsc = getClass().getResource("/bookexos/continuous/chart.css");
        String externalFrom = rsc.toExternalForm();
        lineChart.getStylesheets().add(externalFrom);

        return lineChart;
    }
}
