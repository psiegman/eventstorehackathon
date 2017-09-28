package nl.gerimedica.axoniqhack.gmhack.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ambulance {

	public enum State {
		DISPATCHED,
		AVAILABLE,
		OUT_FOR_LUNCH
	}

	@Id
	@GeneratedValue
	Long id;

	String name;

	@Enumerated(EnumType.STRING)
	State state;

	@Embedded
	GeoLocation geoLocation;
}
