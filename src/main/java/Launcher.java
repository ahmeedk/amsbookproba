import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class Launcher extends Application {

    private Scene scene;

    private Group root;

    private List<Button> chapters;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);

        Parent parent = loadFile("onOpeningApp.fxml");
        this.root = new Group(parent);
        this.scene = new Scene(this.root);
        this.scene.setFill(Color.AZURE);

        Button viewChaptersButton = new Button("Go to chapters");
        viewChaptersButton.setPrefWidth(210);
        viewChaptersButton.setPrefHeight(34);
        viewChaptersButton.setLayoutX(235);
        viewChaptersButton.setLayoutY(490);

        viewChaptersButton.setOnAction(event -> {
            root.getChildren().remove(0,root.getChildren().size()-1);
        });
        this.root.getChildren().add(viewChaptersButton);

        // new AppFront(this.root).addChapter();

        primaryStage.setTitle("Learning Probability Application");
        primaryStage.setScene(this.scene);
        primaryStage.show();
    }
    private Parent loadFile(String fileName) {
        Parent p = null;
        try {
            p = FXMLLoader.load(getClass().getResource(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return p;
    }

}
