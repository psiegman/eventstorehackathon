package nl.gerimedica.axoniqhack.gmhack.commands;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import nl.gerimedica.axoniqhack.gmhack.domain.GeoLocation;
import nl.gerimedica.axoniqhack.gmhack.domain.Severity;

@Data
@Builder
public class CallCommand {

    private String uuid;
    private String phoneNumber;
    private GeoLocation geoLocation;
    private LocalDateTime localDateTime;
    private String comment;
    private Severity severity;
}
