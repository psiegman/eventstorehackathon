package nl.gerimedica.axoniqhack.gmhack.init;

import nl.gerimedica.axoniqhack.gmhack.GeoLocationService;
import nl.gerimedica.axoniqhack.gmhack.domain.Ambulance;
import nl.gerimedica.axoniqhack.gmhack.repository.AmbulanceRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.LongStream;

@Component
public class InitialDataLoader implements InitializingBean {

	@Autowired
	private AmbulanceRepository ambulanceRepository;

	@Autowired
	private GeoLocationService geoLocationService;

	@Override
	public void afterPropertiesSet() throws Exception {

		Random random = new Random();
		LongStream.range(1, 21).forEach(id ->
				ambulanceRepository.save(
						new Ambulance(id, "ambulance-" + id, Ambulance.State.values()[random.nextInt(3)], geoLocationService.createRandomGeoLocation())
			));
	}
}
