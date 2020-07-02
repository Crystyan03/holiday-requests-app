package de.arvato.vacationrequestmodule.exceptions;


import org.springframework.context.ApplicationContextException;

public class VacationRequestStatusBadRequest extends ApplicationContextException {

    public VacationRequestStatusBadRequest(String msg) {
        super(msg);
    }
}
