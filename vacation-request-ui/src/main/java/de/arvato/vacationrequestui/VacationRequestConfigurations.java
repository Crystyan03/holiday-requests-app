package de.arvato.vacationrequestui;


import lombok.Data;
import lombok.Singular;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Configuration
public class VacationRequestConfigurations {

    @Value("${de.arvato.vacationrequestui.employee.module.uri:http://localhost:8081/employee}")
    private String employeeModuleUri;

    @Value("${de.arvato.vacationrequest.ui.vacation.request.module.uri:http://localhost:8082/vacation}")
    private String vacationRequestModuleUri;

}
