package bookexos;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class HeadTailSimulations extends Application {

    private Group root;

    private Scene scene;

    private ExamplesImpl examplesImpl = new ExamplesImpl();

    @Override
    public void start(Stage primaryStage) throws Exception {

        int numberOfSimulation = 1000;
        int[][] results = examplesImpl.spikeGraph(numberOfSimulation);
        int[] pennies = new int[results.length];
        int[] leads = new int[results.length];

        for (int i = 0; i < results.length; i++) {
            pennies[i] = results[i][0];
            leads[i] = results[i][1];
        }


        BarChart penniesBarChart = getBarChart(pennies, 50, 50, false);
        BarChart leadsBarChart = getBarChart(leads, 800, 50, true);

        this.root = new Group(penniesBarChart, leadsBarChart);
        this.scene = new Scene(root, 1500, 700);

        primaryStage.setTitle(" distribution graph");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private BarChart getBarChart(int[] data, int x, int y, boolean shift) {

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        BarChart barChart = new BarChart(xAxis, yAxis);
        XYChart.Series series = new XYChart.Series();


        int halfLength = data.length / 2;
        int k = shift ? halfLength : 0;
        // set data to chart
        Map<Integer, Double> distributions = getDistribution(data, k);

        for (int i = -halfLength + k; i < halfLength + k; i++) {
            series.getData().add(new XYChart.Data(String.valueOf(i), distributions.get(i)));
        }
        //Setting the data to Line chart
        barChart.getData().add(series);


        barChart.setTranslateX(x);
        barChart.setTranslateY(y);
        barChart.setPrefWidth(700);
        barChart.setPrefHeight(600);

        return barChart;
    }

    private Map<Integer, Double> getDistribution(int[] results, int k) {

        Map<Integer, Double> distribution = new HashMap<>();
        int length = results.length;
        for (int i = -length / 2 + k; i < length / 2 + k; i++) {
            double occ = 0;
            for (int j = 0; j < length; j++) {
                if (results[j] == i) {
                    occ++;
                }
            }
            occ = occ / length;
            distribution.put(i, occ);
        }
        return distribution;
    }
}
