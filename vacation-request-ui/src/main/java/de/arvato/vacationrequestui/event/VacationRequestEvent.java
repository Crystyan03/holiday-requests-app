package de.arvato.vacationrequestui.event;

import de.arvato.vacationrequestui.domain.Employee;
import de.arvato.vacationrequestui.domain.VacationRequest;
import org.springframework.context.ApplicationEvent;

public class VacationRequestEvent extends ApplicationEvent {

    private VacationRequestEventType type;

    private VacationRequest vacationRequest;

    private Employee employee;

    private Employee supervisor;

    public VacationRequestEvent(Object source, VacationRequest vacationRequest) {
        super(source);
        this.vacationRequest = vacationRequest;
    }
}
