package de.arvato.employeemodule.controller;

import de.arvato.employeemodule.model.Employee;
import de.arvato.employeemodule.repository.EmployeeRepository;
import javafx.beans.property.ReadOnlyBooleanProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return new ResponseEntity(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Employee>> getEmployees(@RequestParam(required = false) Boolean supervisor) {
        Iterable<Employee> employees;
        if(Objects.nonNull(supervisor)) {
            employees = employeeRepository.findAllBySupervisor(supervisor);
        } else {
            employees = employeeRepository.findAll();
        }

        if(Objects.nonNull(employees)) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
