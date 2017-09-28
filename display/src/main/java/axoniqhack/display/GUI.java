package axoniqhack.display;

import axoniqhack.display.drawable.Ambulances;
import axoniqhack.display.drawable.Incidents;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by michael on 28-9-17.
 */
public class GUI {

    private Pager pager;
    private Ambulances ambulances;
    private Incidents incidents;

    public void start(Stage primaryStage) {
        BorderPane layout = new BorderPane();
        layout.setTop(pager);
        layout.setCenter(createCanvas());
        Scene scene = new Scene(layout, 1100, 500);
        primaryStage.setTitle("Axoniq hackathon display");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private Node createCanvas() {
        Canvas canvas = new Canvas( 1000, 1000 );

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                clearCanvas(graphicsContext, currentNanoTime);
                drawDrawables(graphicsContext, currentNanoTime);

            }
        }.start();

        return canvas;
    }

    private void drawDrawables(GraphicsContext graphicsContext, long currentNanoTime) {
        ambulances.draw(graphicsContext);
        incidents.draw(graphicsContext);
    }

    private void clearCanvas(GraphicsContext graphicsContext, long currentNanoTime) {
        graphicsContext.setFill( new Color(0.85f, 0.85f, 1.0f, 1.0) );
        graphicsContext.fillRect(0,0, 1000,1000);
    }

    @Autowired
    public void setPager(Pager pager) {
        this.pager = pager;
    }

    @Autowired
    public void setAmbulances(Ambulances ambulances) {
        this.ambulances = ambulances;
    }

    @Autowired
    public void setIncidents(Incidents incidents) {
        this.incidents = incidents;
    }
}
