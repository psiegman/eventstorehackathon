package nl.gerimedica.axoniqhack.gmhack.init;

import nl.gerimedica.axoniqhack.gmhack.GeoLocationService;
import nl.gerimedica.axoniqhack.gmhack.domain.Ambulance;
import nl.gerimedica.axoniqhack.gmhack.repository.AmbulanceRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InitialDataLoader implements InitializingBean {

	@Autowired
	private AmbulanceRepository ambulanceRepository;

	@Autowired
	private GeoLocationService geoLocationService;

	@Override
	public void afterPropertiesSet() throws Exception {
		ambulanceRepository.saveAll( Arrays.asList(
				new Ambulance(1l, "first ambulance", Ambulance.State.AVAILABLE, geoLocationService.createRandomGeoLocation()),
				new Ambulance(3l, "third ambulance", Ambulance.State.OUT_FOR_LUNCH, geoLocationService.createRandomGeoLocation()),
				new Ambulance(2l, "second ambulance", Ambulance.State.DISPATCHED, geoLocationService.createRandomGeoLocation()))
		);
	}
}
