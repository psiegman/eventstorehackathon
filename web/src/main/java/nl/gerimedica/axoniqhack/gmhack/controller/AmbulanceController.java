package nl.gerimedica.axoniqhack.gmhack.controller;

import nl.gerimedica.axoniqhack.gmhack.domain.Ambulance;
import nl.gerimedica.axoniqhack.gmhack.repository.AmbulanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/ambulance")
public class AmbulanceController {

	@Autowired
	private AmbulanceRepository ambulanceRepository;

	@RequestMapping(value =  {"", "/"})
	public String getAll(Model model) {
		ambulanceRepository.findAll().forEach(a -> System.out.println(a.getName()));
		List<Ambulance> ambulances = StreamSupport.stream(ambulanceRepository.findAll().spliterator(), false).collect(Collectors.toList());
		model.addAttribute("ambulance", ambulances);
		return "ambulance/index";
	}
}

