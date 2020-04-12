package bookexos;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Map;

public class GraphRender extends Application {

    private Group root;

    private Scene scene;

    private Exercises exercises = new Exercises();
    private double[][] data;

    @Override
    public void init() throws Exception {

        int n = 100000;
        data= exercises.exercise_14_v2(n,50);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BarChart winningChart = getBarChart(data);
        this.root = new Group(winningChart);
        this.scene = new Scene(root, 1500, 700);

        primaryStage.setTitle(" distribution graph");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private BarChart getBarChart(double[][] data) {

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        BarChart barChart = new BarChart(xAxis, yAxis);
        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < data.length; i++) {
            series.getData().add(new XYChart.Data(String.valueOf(data[i][0]), data[i][1]));
        }
        //Setting the data to Line chart
        barChart.getData().add(series);


        barChart.setTranslateX(50);
        barChart.setTranslateY(50);
        barChart.setPrefWidth(1200);
        barChart.setPrefHeight(600);

        return barChart;
    }

    public void startApp(Map<String, String> args) {
        launch();
    }
}
