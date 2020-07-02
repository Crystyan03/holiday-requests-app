package de.arvato.vacationrequestmodule.service;


import de.arvato.vacationrequestmodule.data.VacationRequest;
import de.arvato.vacationrequestmodule.data.VacationTracking;
import de.arvato.vacationrequestmodule.repositories.VacationRequestRepository;
import de.arvato.vacationrequestmodule.repositories.VacationTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static de.arvato.vacationrequestmodule.validator.VacationRequestValidator.validateVacationRequest;
import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class VacationRequestService {

    @Autowired
    private VacationRequestRepository vacationRequestRepository;

    @Autowired
    private VacationTrackingRepository vacationTrackingRepository;

    public VacationRequest createVacationRequest(VacationRequest vacationRequest) {
        validateVacationRequest(vacationRequest);
        return vacationRequestRepository.saveAndFlush(vacationRequest);
    }

    public int queryVacationBalance(Long empId) {
        VacationTracking vacationTracking = vacationTrackingRepository.getOne(empId);

        List<VacationRequest> approvedVacationRequest = vacationRequestRepository.getApprovedVacationRequest(empId);

        List<Long> vacationDaysList = approvedVacationRequest.stream().map(vacationRequest -> {
            return (DAYS.between(vacationRequest.getFromDate(), vacationRequest.getToDate()));
        }).collect(Collectors.toList());

        return (int) (vacationTracking.getAllowedVacations() - vacationDaysList.stream().reduce(0L, Long::sum));
    }
}
