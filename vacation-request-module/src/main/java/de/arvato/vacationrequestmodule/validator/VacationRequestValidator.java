package de.arvato.vacationrequestmodule.validator;

import de.arvato.vacationrequestmodule.data.VacationRequest;
import de.arvato.vacationrequestmodule.exceptions.VacationRequestStatusBadRequest;

import java.util.Objects;
import java.util.Optional;

public class VacationRequestValidator {

    public static void validateVacationRequest(VacationRequest vacationRequest) {
        Optional.ofNullable(vacationRequest.getStatus()).filter(Objects::nonNull).orElseThrow(() ->
                new VacationRequestStatusBadRequest("status can not be null and should contain vallues either REQUEST, APPORVED or REJECTED"));

        Optional.ofNullable(vacationRequest.getFrom()).filter(Objects::nonNull).orElseThrow(() ->
                new VacationRequestStatusBadRequest("fromdate can not be null."));

        Optional.ofNullable(vacationRequest.getTo()).filter(Objects::nonNull).orElseThrow(() ->
                new VacationRequestStatusBadRequest("todate can not be null."));
    }
}
