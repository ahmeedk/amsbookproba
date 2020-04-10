package bookexos;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PeterWinning extends Application {


    private ExamplesImpl examplesImpl = new ExamplesImpl();

    private Group root;

    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        int[] data = examplesImpl.hTSimulationPennies(8000);
        BarChart winningChart = getBarChart(data, 50, 50);
        this.root = new Group(winningChart);
        this.scene = new Scene(root, 1500, 700);

        primaryStage.setTitle(" distribution graph");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private BarChart getBarChart(int[] data, int x, int y) {

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        BarChart barChart = new BarChart(xAxis, yAxis);
        XYChart.Series series = new XYChart.Series();

        for (int i = 0; i < data.length; i++) {
            series.getData().add(new XYChart.Data(String.valueOf(i), data[i]));
        }
        //Setting the data to Line chart
        barChart.getData().add(series);


        barChart.setTranslateX(x);
        barChart.setTranslateY(y);
        barChart.setPrefWidth(1400);
        barChart.setPrefHeight(600);

        return barChart;
    }
}
