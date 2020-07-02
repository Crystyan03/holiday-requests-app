package de.arvato.vacationrequestui.controller;

import de.arvato.vacationrequestui.domain.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping()
	public String current(Model model){
		model.addAttribute("login", new Login());
		return "login";
	}

	@GetMapping("/")
	public String home() {
		return "login";
	}

	@GetMapping("/vacation/overview")
	public String success() {
		return "vacation_overview.html";
	}

	@PostMapping
	public String postRequest(Login login) {
		log.info("New loginRequest was done {}", login);

		return "redirect:/login/vacation/overview";
	}
}
