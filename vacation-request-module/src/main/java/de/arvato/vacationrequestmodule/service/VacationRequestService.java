package de.arvato.vacationrequestmodule.service;


import de.arvato.vacationrequestmodule.data.VacationRequest;
import de.arvato.vacationrequestmodule.repositories.VacationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static de.arvato.vacationrequestmodule.validator.VacationRequestValidator.validateVacationRequest;

@Service
public class VacationRequestService {

    @Autowired
    private VacationRequestRepository vacationRequestRepository;


    public VacationRequest createVacationRequest(VacationRequest vacationRequest) {
        validateVacationRequest(vacationRequest);
        return vacationRequestRepository.saveAndFlush(vacationRequest);
    }
}
