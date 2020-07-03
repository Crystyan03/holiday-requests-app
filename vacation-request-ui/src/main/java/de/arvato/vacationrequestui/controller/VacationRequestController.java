package de.arvato.vacationrequestui.controller;

import de.arvato.vacationrequestui.VacationRequestConfigurations;
import de.arvato.vacationrequestui.domain.Employee;
import de.arvato.vacationrequestui.domain.VacationRequest;
import de.arvato.vacationrequestui.event.VacationRequestEventType;
import de.arvato.vacationrequestui.security.model.User;
import de.arvato.vacationrequestui.security.model.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        String url = configurations.getEmployeeModuleUri() + "?supervisor=true";
        ArrayList<Employee> supervisors = restTemplate.getForObject(url, ArrayList.class, true);

        model.addAttribute("supervisors", supervisors);

        return "vacation_request";
    }

    @GetMapping("/success")
    public String success() {
        return "vacation_request_successfull.html";
    }

    @PostMapping
    public String postRequest(VacationRequest vacation) {
        log.info("Submit new vacation request {}", vacation);

        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //call vacation request module
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("username", principal.getUsername());
        Employee employee = restTemplate.getForObject(configurations.getEmployeeModuleUri()+"/username?username={username}", Employee.class, principal.getUsername());

        vacation.setStatus(VacationRequestEventType.SUBMITTED.name());
        vacation.setEmpId(employee.getId());

        VacationRequest vacationRequest = restTemplate.postForObject(configurations.getVacationRequestModuleUri(), vacation, VacationRequest.class);

        //send vacation request event

        return "redirect:/vacation/success";
    }
}
