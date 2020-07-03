package de.arvato.vacationrequestmodule;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class VacationRequestConfigurations {

    @Value("${de.arvato.vacationrequestui.employee.module.uri:http://localhost:8081/employee}")
    private String employeeModuleUri;

}