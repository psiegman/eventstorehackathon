package nl.gerimedica.axoniqhack.gmhack.repository;
import java.time.LocalDate;
import java.util.List;

import nl.gerimedica.axoniqhack.gmhack.domain.Incident;
import nl.gerimedica.axoniqhack.gmhack.events.domain.GeoLocation;
import org.springframework.data.repository.CrudRepository;

public interface IncidentRepository extends CrudRepository<Incident, Long> {

    List<Incident> findBygeoLocationAndLocalDate(GeoLocation geoLocation, LocalDate localDate);
}
