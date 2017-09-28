package nl.gerimedica.axoniqhack.gmhack.events;
import java.time.LocalDateTime;

import nl.gerimedica.axoniqhack.gmhack.events.domain.Resolution;

public class IncidentResolvedEvent {

    private String id;
    private Resolution resolution;
    private LocalDateTime resolutionTime;
}
