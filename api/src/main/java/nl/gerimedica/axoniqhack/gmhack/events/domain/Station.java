package nl.gerimedica.axoniqhack.gmhack.events.domain;

import lombok.Data;


@Data
public class Station {

	private Long id;

	private String name;

	GeoLocation geoLocation;
}
