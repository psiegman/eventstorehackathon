package nl.gerimedica.axoniqhack.gmhack.commands;

import lombok.Builder;
import lombok.Data;
import nl.gerimedica.axoniqhack.gmhack.domain.GeoLocation;
import nl.gerimedica.axoniqhack.gmhack.events.domain.Severity;

import java.time.LocalDateTime;

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
