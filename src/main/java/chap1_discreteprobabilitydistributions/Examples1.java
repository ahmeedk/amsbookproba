package chap1_discreteprobabilitydistributions;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;

public class Examples1 {

    private Group root;
    private Random rand = new Random();

    public Examples1(Group root) {
        this.root = root;
    }

    public void run() {

        Button example1_1 = new Button("Example1.1");
        example1_1.setTranslateX(150);
        example1_1.setTranslateY(250);
        example1_1.setPrefWidth(300);
        root.getChildren().add(example1_1);
        example1_1.setOnAction(e -> {
            removeAllButtons();
            example1_1();
        });

    }

    private void example1_1() {
        Text example = new Text(100, 200, "Example 1.1");
        example.setFont(new Font(25));

        Text msg = new Text(50, 240, "choose a number");
        example.setFont(new Font(25));

        root.getChildren().add(example);
        root.getChildren().add(msg);

        TextArea textArea = new TextArea();
        textArea.setTranslateX(150);
        textArea.setTranslateY(280);
        textArea.setMaxWidth(30);
        textArea.setMaxHeight(5);

        root.getChildren().add(textArea);

//        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
//            // this will run whenever text is changed
//
//
//            int nbLine = Integer.valueOf(newValue) / 6;
//
//            for (int i = 0; i < nbLine; i++) {
//                for (int j = 0; j < 6; j++) {
//                    Text t = new Text(String.valueOf(rand.nextDouble()));
//                    t.setX(i * 200 + 50);
//                    t.setY(j * 30 + 280);
//
//                    root.getChildren().add(t);
//                }
//            }
//            int i = 0;
//            while (i < Integer.valueOf(newValue) % 6) {
//
//                Text t = new Text(String.valueOf(rand.nextDouble()));
//                t.setX(root.getChildren().get(root.getChildren().size()-1).getLayoutX() + 50);
//                t.setX(root.getChildren().get(root.getChildren().size()-1).getLayoutY() + 300);
//
//                root.getChildren().add(t);
//            }
//
//        });

    }

    public void removeAllButtons() {
        root.getChildren().remove(1, root.getChildren().size());
    }
}
