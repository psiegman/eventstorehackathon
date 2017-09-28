package nl.gerimedica.axoniqhack.gmhack.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ambulance")
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
