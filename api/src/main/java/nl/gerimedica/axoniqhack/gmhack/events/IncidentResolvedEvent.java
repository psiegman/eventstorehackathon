package nl.gerimedica.axoniqhack.gmhack.events;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import nl.gerimedica.axoniqhack.gmhack.events.domain.Resolution;

@Data
@AllArgsConstructor
@Builder
public class IncidentResolvedEvent {

    private Long id;
    private Resolution resolution;
    private LocalDateTime resolutionTime;
}
