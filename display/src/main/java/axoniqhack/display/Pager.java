package axoniqhack.display;

import axoniqhack.display.entities.Incident;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import nl.gerimedica.axoniqhack.gmhack.events.IncidentReportedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class Pager extends Label {

    public Pager() {
        setPrefWidth(Double.MAX_VALUE);
        setAlignment(Pos.CENTER);
        Platform.runLater(() -> setText("No incidents reported"));
    }

    @EventHandler
    public void on(IncidentReportedEvent event) {
        Platform.runLater(() -> setText(event.getSeverity() + " " +event.getComment()));
    }
}
