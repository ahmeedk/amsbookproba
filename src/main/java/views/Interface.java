package views;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Interface {

    private Group root;

    public Interface(Group root) {
        this.root = root;
    }

    public void run() {

        Label title = new Label("Probability Laboratory");
        title.setTranslateX(450);
        title.setTranslateY(10);
        title.setFont(Font.font("System Italic", 24));
        this.root.getChildren().add(title);

        Label select = new Label("Select a tab ");
        select.setTranslateX(50);
        select.setTranslateY(150);
        select.setFont(Font.font("System Italic", 18));
        this.root.getChildren().add(select);

        double x = 200;
        double y = 200;

        double width = 100;
        double height = 100;

        double xShift = 150;
        double yShift = 150;

        Button CoinButton = getButton("Toss coin", x, y, width, height);
        this.root.getChildren().add(CoinButton);
        CoinButton.setOnAction(e -> {
            removeAllButtons();
            // launch toss coin view
            new CoinScene(root).run();
        });


        x = x + xShift;
        Button diceButton = getButton("Roll dice", x, y, width, height);
        this.root.getChildren().add(diceButton);
        diceButton.setOnAction(e -> {
            removeAllButtons();
            // launch roll dice view
        });

        x = x + xShift;
        Button RNButton = getButton("Generate random numbers", x, y, width, height);
        this.root.getChildren().add(RNButton);
        RNButton.setOnAction(e -> {
            removeAllButtons();
            //
        });

        x = x - 2 * xShift;
        y = y + yShift;
        Button densitiesButton = getButton("Distributions and densities", x, y, width, height);
        this.root.getChildren().add(densitiesButton);
        densitiesButton.setOnAction(e -> {
            removeAllButtons();
            //
        });

    }

    private Button getButton(String title, double x, double y, double w, double h) {
        Button button = new Button(title);
        button.setPrefWidth(w);
        button.setPrefHeight(h);
        button.setTranslateX(x);
        button.setTranslateY(y);
        return button;
    }

    private void removeAllButtons() {
        root.getChildren().remove(1, root.getChildren().size());
    }
}
