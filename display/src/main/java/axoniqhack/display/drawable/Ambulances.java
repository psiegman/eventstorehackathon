package axoniqhack.display.drawable;

import axoniqhack.display.entities.Ambulance;
import javafx.scene.canvas.GraphicsContext;
import org.axonframework.config.ProcessingGroup;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Listens to events and updates the display
 */
@Component
@ProcessingGroup("MyHandlers")
public class Ambulances implements Drawable {

    private final ConcurrentMap<String, Ambulance> incidents = new ConcurrentHashMap<>();

    @Override
    public void draw(GraphicsContext graphicsContext) {
        drawAmbulances(graphicsContext);
    }

    public void drawAmbulances(GraphicsContext graphicsContext) {
        incidents.forEach( (key, value) -> drawAmbulance(graphicsContext, value));
    }

    private void drawAmbulance(GraphicsContext graphicsContext, Ambulance ambulance) {
        graphicsContext.fillText(ambulance.name, ambulance.location.x, ambulance.location.y);
    }

//    @EventHandler
//    public void on(DispatchEvent event) {
//
//    }

}
