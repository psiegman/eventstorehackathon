package nl.gerimedica.axoniqhack.gmhack.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import nl.gerimedica.axoniqhack.gmhack.events.domain.GeoLocation;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class CallReportedEvent {

	private String id;
	private String phoneNumber;
	private GeoLocation geoLocation;
	private LocalDateTime localDateTime;
	private String comment;

}
