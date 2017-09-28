package axoniqhack.display.entities;

import javafx.scene.Node;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Listens to events and updates the display
 */
@Component
public class Incidents {

    private class Incident {
    }

    private final Map<String, Incident> incidents = new ConcurrentHashMap<>();

    @EventHandler
    public void on(IncidentReportedEvent event) {
        incidents.put(event.getId(), new Incident());
    }

}
