package axoniqhack.display;

import axoniqhack.display.nodes.Pager;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by michael on 28-9-17.
 */
public class GUI {

    private Pager pager;

    public void start(Stage primaryStage) {
        BorderPane layout = new BorderPane();
        layout.setTop(pager);
        Scene scene = new Scene(layout, 1100, 500);
        primaryStage.setTitle("Axoniq hackathon display");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    @Autowired
    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
