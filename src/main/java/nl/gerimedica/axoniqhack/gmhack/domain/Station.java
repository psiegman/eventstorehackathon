package nl.gerimedica.axoniqhack.gmhack.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "station")
@Data
public class Station {

	@Id
	@GeneratedValue
	Long id;

	String name;

	@Embedded
	GeoLocation geoLocation;
}
