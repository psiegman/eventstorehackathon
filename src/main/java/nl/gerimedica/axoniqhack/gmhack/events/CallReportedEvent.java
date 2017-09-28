package nl.gerimedica.axoniqhack.gmhack.events;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import nl.gerimedica.axoniqhack.gmhack.domain.GeoLocation;
import nl.gerimedica.axoniqhack.gmhack.domain.Severity;

@Data
@AllArgsConstructor
@Builder
public class CallReportedEvent {

    private String id;
    private String phoneNumber;
    private GeoLocation geoLocation;
    private LocalDateTime localDateTime;
    private String comment;
    private Severity severity;
}
