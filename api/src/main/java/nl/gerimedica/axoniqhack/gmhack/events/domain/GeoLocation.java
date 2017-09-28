package nl.gerimedica.axoniqhack.gmhack.events.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoLocation {

	double latitude;

	double longitude;
}
