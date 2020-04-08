package chap1_discreteprobabilitydistributions;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Chapter1 {

    private Group root;

    public Chapter1(Group root) {
        this.root = root;
    }

    public void run() {

        Text selectExamplesOrExos = new Text(100, 170, " Select chapter");
        selectExamplesOrExos.setFont(new Font(20));
        this.root.getChildren().add(selectExamplesOrExos);

        Button examples = new Button("Examples");
        examples.setTranslateX(150);
        examples.setTranslateY(250);
        examples.setPrefWidth(300);
        root.getChildren().add(examples);
        examples.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                removeAllButtons();
                new Examples1(root).run();
            }
        });

        Button exos = new Button("Exercises");
        exos.setTranslateX(150);
        exos.setTranslateY(300);
        exos.setPrefWidth(300);
        root.getChildren().add(exos);
    }

    public void removeAllButtons() {
        root.getChildren().remove(2, root.getChildren().size());
    }

}
