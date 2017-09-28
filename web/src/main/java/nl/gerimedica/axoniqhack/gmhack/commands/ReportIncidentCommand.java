package nl.gerimedica.axoniqhack.gmhack.commands;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import nl.gerimedica.axoniqhack.gmhack.events.domain.GeoLocation;
import nl.gerimedica.axoniqhack.gmhack.events.domain.Severity;

@Data
@Builder
public class ReportIncidentCommand {

    private String uuid;
    private String phoneNumber;
    private GeoLocation geoLocation;
    private LocalDateTime localDateTime;
    private String comment;
    private Severity severity;

}
