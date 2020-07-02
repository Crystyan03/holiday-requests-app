package de.arvato.vacationrequestui.controller;

import de.arvato.vacationrequestui.domain.Employee;
import de.arvato.vacationrequestui.security.jwt.service.JwtAuthenticationService;
import de.arvato.vacationrequestui.security.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    JwtAuthenticationService authenticationService;

    @GetMapping()
    public String current(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String loginUser(User user) throws Exception {
        log.info("Just logged in: {}", user.getUsername());

        String token = authenticationService.createAuthenticationToken(user);

        return "redirect:/";
    }
}
