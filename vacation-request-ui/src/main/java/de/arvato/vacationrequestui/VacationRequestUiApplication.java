package de.arvato.vacationrequestui;

import de.arvato.vacationrequestui.security.model.User;
import de.arvato.vacationrequestui.security.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootApplication
public class VacationRequestUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacationRequestUiApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(UserRepository userRepository) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        log.info("Setup demo user un:gopo pw:password");
        CommandLineRunner runner = (args) -> {
            if(userRepository.findByUsername("gopo")==null) {
                User user = new User();
                user.setEnabled(true);
                user.setName("Demo User");
                user.setUsername("gopo");
                user.setPassword(encoder.encode("password"));
                userRepository.save(user);
            }
        };
        return runner;
    }


}
