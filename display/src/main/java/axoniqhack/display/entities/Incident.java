package axoniqhack.display.entities;

import nl.gerimedica.axoniqhack.gmhack.events.domain.GeoLocation;
import nl.gerimedica.axoniqhack.gmhack.events.domain.Severity;

import java.time.LocalDateTime;

public class Incident {
    public final String id;
    public final Severity severity;
    public final LocalDateTime localDateTime;
    public final Location geoLocation;
    public final String comment;

    public Incident(String id, Severity severity, LocalDateTime localDateTime, Location geoLocation, String comment) {
        this.id = id;
        this.severity = severity;
        this.localDateTime = localDateTime;
        this.geoLocation = geoLocation;
        this.comment = comment;
    }
}
