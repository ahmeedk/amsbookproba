import chap1_discreteprobabilitydistributions.Chapter1;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class AppFront {

    private String[] chaptersNames = new String[]{"Discrete Probability Distribution", "Continuous Probability Densities", "Combinatorics"};

    private List<Button> chapters = new ArrayList<>();

    private Group root;


    public AppFront(Group root) {
        this.root = root;
    }

    public void addChapter() {

        int y = 200;
        Button chap1 = new Button("Discrete Probability Distribution");
        chap1.setTranslateX(150);
        chap1.setTranslateY(y);
        chap1.setPrefWidth(300);
        this.root.getChildren().add(chap1);
        chap1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                removeAllButtons();
                new Chapter1(root).run();
            }
        });

        y = y + 32;
        Button chap2 = new Button("Continuous Probability Densities");
        chap2.setTranslateX(150);
        chap2.setTranslateY(y);
        chap2.setPrefWidth(300);
        this.root.getChildren().add(chap2);

        y = y + 32;
        Button chap3 = new Button("Combinatorics");
        chap3.setTranslateX(150);
        chap3.setTranslateY(y);
        chap3.setPrefWidth(300);
        this.root.getChildren().add(chap3);

        y = y + 32;
        Button chap4 = new Button("Conditional Probability");
        chap4.setTranslateX(150);
        chap4.setTranslateY(y);
        chap4.setPrefWidth(300);
        this.root.getChildren().add(chap4);

    }

    public void removeAllButtons() {
        root.getChildren().remove(1, root.getChildren().size());
    }

}
