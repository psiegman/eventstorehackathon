package nl.gerimedica.axoniqhack.gmhack.events.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoLocation {

	@Column
	double latitude;

	@Column
	double longitude;
}
