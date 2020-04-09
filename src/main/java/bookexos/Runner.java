package bookexos;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Runner extends Application {


    private Examples examples = new Examples();

//    public static void main(String[] arg) {
//
//        // System.out.println("Second Demere bet succes for 10000 rolls : " + examples.demere2(100000));
//
////        int[] results = examples.hTSimulation(40);
////        System.out.println("peter winning penny = " + results[0] + " number of time a head = " + results[1]);
//        launch();
//
//    }

    private Group root;

    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //NumberAxis xAxis = new NumberAxis(-20, 20, 5);
        CategoryAxis xAxis =new CategoryAxis();

        NumberAxis yAxis = new NumberAxis(0, 0.3, 0.1);

        //Creating the line chart
        // LineChart linechart = new LineChart(xAxis, yAxis);
        BarChart barChart = new BarChart(xAxis,yAxis);

        //Prepare XYChart.Series objects by setting data
        XYChart.Series series = new XYChart.Series();

        // set data to chart

        int[] results = examples.spikeGraph(40);

        Map<Integer, Double> pennyDistributions = getDistribution(results);

        for (int i = -20; i < 20; i++) {
            series.getData().add(new XYChart.Data(String.valueOf(i), pennyDistributions.get(i)));
        }
        //Setting the data to Line chart
        barChart.getData().add(series);

        barChart.setTranslateY(50);
        barChart.setTranslateX(50);
        barChart.setPrefWidth(700);
        barChart.setPrefHeight(600);

        this.root = new Group(barChart);
        this.scene = new Scene(root, 800, 700);

        primaryStage.setTitle(" distribution graph");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Map<Integer, Double> getDistribution(int[] results) {

        Map<Integer, Double> distribution = new HashMap<>();
        for (int i = -20; i < 20; i++) {
            double occ = 0;
            for (int j = 0; j < results.length; j++) {
                if (results[j] == i) {
                    occ++;
                }
            }
            occ = occ / results.length;
            distribution.put(i, occ);
        }
        return distribution;
    }
}
