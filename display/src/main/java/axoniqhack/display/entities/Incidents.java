package axoniqhack.display.entities;

import javafx.scene.Node;
import nl.gerimedica.axoniqhack.gmhack.events.IncidentReportedEvent;
import nl.gerimedica.axoniqhack.gmhack.events.domain.GeoLocation;
import nl.gerimedica.axoniqhack.gmhack.events.domain.Severity;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Listens to events and updates the display
 */
@Component
public class Incidents {

    public static class Incident {
        private final String id;
        private final Severity severity;
        private final LocalDateTime localDateTime;
        private final GeoLocation geoLocation;
        private final String comment;

        public Incident(String id, Severity severity, LocalDateTime localDateTime, GeoLocation geoLocation, String comment) {
            this.id = id;
            this.severity = severity;
            this.localDateTime = localDateTime;
            this.geoLocation = geoLocation;
            this.comment = comment;
        }
    }

    private final Map<String, Incident> incidents = new ConcurrentHashMap<>();

    @EventHandler
    public void on(IncidentReportedEvent event) {
        incidents.put(event.getId(), new Incident(event.getId(), event.getSeverity(), event.getLocalDateTime(), event.getGeoLocation(), event.getComment()));
    }

}
