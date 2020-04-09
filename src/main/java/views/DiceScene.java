package views;

import Business.RandomnessGenerator;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DiceScene {

    private Group root;

    private RandomnessGenerator randomnessGenerator = new RandomnessGenerator();

    public DiceScene(Group root) {
        this.root = root;
    }

    public void run() {
        Label title = new Label("Probability Laboratory");
        title.setTranslateX(450);
        title.setTranslateY(10);
        title.setFont(Font.font("System Italic", 24));
        this.root.getChildren().add(title);

        Label select = new Label("Number of times of Dice rolling");
        select.setTranslateX(50);
        select.setTranslateY(150);
        select.setFont(Font.font("System Italic", 18));
        this.root.getChildren().add(select);

        TextArea input = new TextArea();
        input.setPrefSize(30, 10);
        input.setTranslateX(200);
        input.setTranslateY(200);
        root.getChildren().add(input);

        AtomicInteger givenNumber = new AtomicInteger();
        input.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.isEmpty()) {
                givenNumber.set(Integer.valueOf(newValue));
            }
        });

        Button diceButton = getButton("run", 300, 210, 50, 30);
        this.root.getChildren().add(diceButton);
        diceButton.setOnAction(e -> {
            removeAllLast();
            resultGeneration(givenNumber.get());
        });
    }

    private void resultGeneration(int number) {
        Label msgText = new Label("generated Dice rolling : ");
        msgText.setTranslateX(50);
        msgText.setTranslateY(280);
        msgText.setFont(Font.font("System Italic", 18));
        root.getChildren().add(msgText);

        List<Integer> dices = randomnessGenerator.generatedDiceRolling(number);

        String output;
        if (number < 100) {
            output = dices.toString();
        } else {
            output = " CAN'T DISPLAY RESULT, NUMBER IS GREATER THAN 100";
        }

        Text outputText = new Text(output);
        outputText.setTranslateX(50);
        outputText.setTranslateY(350);
        outputText.setFont(Font.font("System Italic", 24));
        outputText.setWrappingWidth(500);
        root.getChildren().add(outputText);


        Map<Integer, Integer> occurences = new HashMap<>();
        occurences.put(1, 0);
        occurences.put(2, 0);
        occurences.put(3, 0);
        occurences.put(4, 0);
        occurences.put(5, 0);
        occurences.put(6, 0);

        for (Integer integer : dices) {
            occurences.put(integer, occurences.get(integer) + 1);
        }

        Map<Integer, Double> probas = new HashMap<>();
        for (Integer i : occurences.keySet()) {
            probas.put(i, occurences.get(i).doubleValue() / dices.size());
        }

        String resutls = "";

        for (Integer i : probas.keySet()) {
            resutls += "P(" + i + ") = " + probas.get(i) + " \n";
        }

        Text percentResult = new Text(resutls);
        percentResult.setTranslateX(50);
        percentResult.setTranslateY(530);
        percentResult.setFont(Font.font("System Italic", 24));
        percentResult.setWrappingWidth(500);
        root.getChildren().add(percentResult);

    }


    private Button getButton(String title, double x, double y, double w, double h) {
        Button button = new Button(title);
        button.setPrefWidth(w);
        button.setPrefHeight(h);
        button.setTranslateX(x);
        button.setTranslateY(y);
        return button;
    }

    private void removeAllLast() {
        root.getChildren().remove(5, root.getChildren().size());
    }
}
