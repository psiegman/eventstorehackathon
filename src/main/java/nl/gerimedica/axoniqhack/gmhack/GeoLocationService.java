package nl.gerimedica.axoniqhack.gmhack;

import nl.gerimedica.axoniqhack.gmhack.domain.GeoLocation;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeoLocationService {

	private static final Random random = new Random();
	public static final double MAX_LATITUDE = 53.347849;
	public static final double MIN_LATITUDE = 51.2689837;

	public static final double MAX_LONGITUDE = 6.998938;
	public static final double MIN_LONGITUDE = 3.4063167;

	public GeoLocation createRandomGeoLocation() {

		double latitude = MIN_LATITUDE + (random.nextDouble() * (MAX_LATITUDE - MIN_LATITUDE));
		double longitude = MIN_LONGITUDE + (random.nextDouble() * (MAX_LONGITUDE - MIN_LONGITUDE));
		return new GeoLocation(latitude, longitude);
	}
}
