package axoniqhack.display.drawable;

import axoniqhack.display.entities.Incident;
import axoniqhack.display.entities.Location;
import javafx.scene.canvas.GraphicsContext;
import nl.gerimedica.axoniqhack.gmhack.events.IncidentReportedEvent;
import nl.gerimedica.axoniqhack.gmhack.events.domain.GeoLocation;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Listens to events and updates the display
 */
@Component
@ProcessingGroup("MyHandlers")
public class Incidents implements Drawable {

    private final Map<String, Incident> incidents = new ConcurrentHashMap<>();

    @EventHandler
    public void on(IncidentReportedEvent event) {
        Incident incident = new Incident(event.getId(), event.getSeverity(), event.getLocalDateTime(), toLocation(event.getGeoLocation()), event.getComment());
        incidents.put(event.getId(), incident);
    }

    private Location toLocation(GeoLocation geoLocation) {
        //geoLocation.getLongitude(), geoLocation.getLatitude()
        return new Location(10,10);
    }

    private void drawIncident(GraphicsContext graphicsContext, Incident incident) {
        graphicsContext.fillText(incident.comment, incident.geoLocation.x, incident.geoLocation.y);
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        incidents.forEach( (key, value) -> drawIncident(graphicsContext, value));
    }
}
