package de.arvato.employeemodule.controller;

import de.arvato.employeemodule.model.Employee;
import de.arvato.employeemodule.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path="/employee", produces = "application/json")
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping(consumes = "application/json")
    public Employee postEmployee(@RequestBody Employee employee) {
        log.info("Save employee {}", employee);

        Employee savedEmployee = employeeRepository.save(employee);

        return savedEmployee;
    }
}
