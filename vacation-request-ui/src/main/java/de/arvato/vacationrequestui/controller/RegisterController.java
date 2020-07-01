package de.arvato.vacationrequestui.controller;

import de.arvato.vacationrequestui.VacationRequestConfigurations;
import de.arvato.vacationrequestui.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Controller
@RequestMapping("/registration")
public class RegisterController {

    @GetMapping()
    public String current(Model model){
        model.addAttribute("employee", new Employee());
        return "registration";
    }

    @GetMapping("/success")
    public String success() {
        return "registration_successfull.html";
    }

    @PostMapping
    public String registerUser(Employee employee) {
        log.info("Regiser new employee {}", employee);

        RestTemplate restTemplate = new RestTemplate();
//        Employee employeeResult = restTemplate.postForObject(VacationRequestConfigurations.employeeModuleUri, employee, Employee.class);//these are probably not right

        return "redirect:/registration/success";
    }
}
