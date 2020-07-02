package de.arvato.vacationrequestmodule.service;


import de.arvato.vacationrequestmodule.data.VacationRequest;
import de.arvato.vacationrequestmodule.repositories.VacationRequestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VacationRequestService {

    @Autowired
    private VacationRequestRepository vacationRequestRepository;

    public VacationRequest createVacationRequest(VacationRequest vacationRequest) {
        log.info("Save vacation requet {}", vacationRequest);
        return vacationRequestRepository.saveAndFlush(vacationRequest);
    }
}
