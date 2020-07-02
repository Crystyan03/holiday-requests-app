package de.arvato.vacationrequestui.controller;

import de.arvato.vacationrequestui.security.model.User;
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
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping()
    public String loginUser(User user) throws Exception {
        log.info("Just logged in: {}", user.getUsername());

        return "redirect:/";
    }
}
