package nl.gerimedica.axoniqhack.gmhack.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Data
public class GeoLocation {
	@Column
	double latitude;

	@Column
	double longitude;
}
