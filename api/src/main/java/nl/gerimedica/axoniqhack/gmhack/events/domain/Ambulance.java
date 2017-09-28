package nl.gerimedica.axoniqhack.gmhack.events.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ambulance {

	public enum State {
		DISPATCHED,
		AVAILABLE,
		OUT_FOR_LUNCH
	}

	private Long id;

	private String name;

	private State state;

	private GeoLocation geoLocation;
}
