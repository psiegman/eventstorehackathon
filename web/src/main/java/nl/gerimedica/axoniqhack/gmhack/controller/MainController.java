package nl.gerimedica.axoniqhack.gmhack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping
	public String doHome() {
		return "index";
	}
}
