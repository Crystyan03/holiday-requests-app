package de.arvato.vacationrequestui.controller;

import de.arvato.vacationrequestui.domain.VacationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/vacation")
public class VacationRequestController {

    @GetMapping
    public String vacationRequest(Model model) {
        model.addAttribute("vacation", new VacationRequest());
        return "vacation_request";
    }

    @GetMapping("/success")
    public String success() {
        return "vacation_request_successfull.html";
    }

    @PostMapping
    public String postRequest(VacationRequest vacation) {
        log.info("Submit new vacation request {}", vacation);

        return "redirect:/vacation/success";
    }
}
