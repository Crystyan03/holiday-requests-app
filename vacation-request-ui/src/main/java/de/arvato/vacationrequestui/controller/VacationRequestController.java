package de.arvato.vacationrequestui.controller;

import de.arvato.vacationrequestui.VacationRequestConfigurations;
import de.arvato.vacationrequestui.domain.Employee;
import de.arvato.vacationrequestui.domain.VacationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Controller
@RequestMapping("/vacation")
public class VacationRequestController {

    @Autowired
    VacationRequestConfigurations configurations;

    @GetMapping
    public String vacationRequest(Model model) {
        model.addAttribute("vacation", new VacationRequest());

        RestTemplate restTemplate = new RestTemplate();

//TODO: get all spuervisors from employee module.
        var s1 = new Employee();
        s1.setSurname("Bernd");
        s1.setName("H");
        var s2 = new Employee();
        s2.setSurname("Ben");
        s2.setName("Dorsch");

        model.addAttribute("supervisors", Arrays.asList(s1,s2));

        return "vacation_request";
    }

    @GetMapping("/success")
    public String success() {
        return "vacation_request_successfull.html";
    }

    @PostMapping
    public String postRequest(VacationRequest vacation) {
        log.info("Submit new vacation request {}", vacation);

        //call vacation request module
        RestTemplate restTemplate = new RestTemplate();
        VacationRequest vacationRequest = restTemplate.postForObject(configurations.getVacationRequestModuleUri(), vacation, VacationRequest.class);

        //send vacation request event


        return "redirect:/vacation/success";
    }
}
