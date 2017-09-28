package nl.gerimedica.axoniqhack.gmhack.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoLocation {

	@Column
	double latitude;

	@Column
	double longitude;
}
