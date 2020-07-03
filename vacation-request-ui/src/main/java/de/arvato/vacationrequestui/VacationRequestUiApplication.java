package de.arvato.vacationrequestui;

import de.arvato.vacationrequestui.domain.Employee;
import de.arvato.vacationrequestui.security.model.User;
import de.arvato.vacationrequestui.security.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
public class VacationRequestUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacationRequestUiApplication.class, args);
    }

    @Autowired
    VacationRequestConfigurations configurations;

    @Bean
    public CommandLineRunner dataLoader(UserRepository userRepository) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        log.info("Setup demo user un:gopo pw:password");
        CommandLineRunner runner = (args) -> {
            RestTemplate restTemplate = new RestTemplate();

            if(userRepository.findByUsername("gopo")==null) {
                User user = new User();
                user.setEnabled(true);
                user.setName("Demo User");
                user.setUsername("gopo");
                user.setPassword(encoder.encode("password"));
                userRepository.save(user);

                Employee employee = new Employee();
                employee.setEmail("klaus@presidency.ro");
                employee.setName("Gopo");
                employee.setSurname("Cartoon");
                employee.setUsername(user.getUsername());
                Employee employeeResult = restTemplate.postForObject(configurations.getEmployeeModuleUri(), employee, Employee.class);
            }

            if(userRepository.findByUsername("klaus")==null) {
                User user = new User();
                user.setEnabled(true);
                user.setName("klaus");
                user.setUsername("klaus");
                user.setPassword(encoder.encode("klaus"));
                userRepository.save(user);

                Employee employee = new Employee();
                employee.setEmail("klaus@presidency.ro");
                employee.setName("Iohannis");
                employee.setSurname("Klaus");
                employee.setUsername(user.getUsername());
                employee.setSupervisor(true);
                Employee employeeResult = restTemplate.postForObject(configurations.getEmployeeModuleUri(), employee, Employee.class);
            }
        };
        return runner;
    }


}
