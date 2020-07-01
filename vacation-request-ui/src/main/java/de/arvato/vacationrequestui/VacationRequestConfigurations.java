package de.arvato.vacationrequestui;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VacationRequestConfigurations {

    @Value("de.arvato.vacationrequestui.employee.module.uri:localhost:8082")
    public static String employeeModuleUri;

    @Value("de.arvato.vacationrequest.ui.vacation.request.module.uri:localhost:8083")
    public static String vacationRequestModuleUri;

}
