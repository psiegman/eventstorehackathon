package nl.gerimedica.axoniqhack.gmhack.controller;

import nl.gerimedica.axoniqhack.gmhack.domain.Station;
import nl.gerimedica.axoniqhack.gmhack.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/station")
public class StationController {

	@Autowired
	private StationRepository stationRepository;

	@RequestMapping("/")
	public String getAllStations(Model model) {
		List<Station> stations = StreamSupport.stream(stationRepository.findAll().spliterator(), false).collect(Collectors.toList());
		model.addAttribute("station", stations);
		return "station/index";
	}
}

