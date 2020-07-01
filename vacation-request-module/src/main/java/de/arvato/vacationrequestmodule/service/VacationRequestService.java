package de.arvato.vacationrequestmodule.service;


import de.arvato.vacationrequestmodule.data.VacationRequest;
import de.arvato.vacationrequestmodule.repositories.VacationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationRequestService {

    @Autowired
    private VacationRequestRepository vacationRequestRepository;

    public VacationRequest createVacationRequest(VacationRequest vacationRequest) {
        return vacationRequestRepository.saveAndFlush(vacationRequest);
    }
}
