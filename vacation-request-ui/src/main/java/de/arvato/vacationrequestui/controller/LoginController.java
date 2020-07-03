package de.arvato.vacationrequestui.controller;

import de.arvato.vacationrequestui.security.SecurityUtils;
import de.arvato.vacationrequestui.security.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping()
	public String current(Model model, HttpServletRequest request){
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		Cookie jwtCookie = SecurityUtils.getJwtCookie(attr.getRequest());
		if (jwtCookie != null) {
			return "redirect:/";
		}
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping
	public String postRequest(User user) {
		log.info("New loginRequest was done {}", user.getUsername());

		return "redirect:/";
	}
}
