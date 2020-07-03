package de.arvato.vacationrequestmodule.service;


import de.arvato.vacationrequestmodule.data.VacationTracking;
import de.arvato.vacationrequestmodule.repositories.VacationTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class VacationTrackerService {

    @Autowired
    private VacationTrackingRepository vacationTrackingRepository;

    @PostMapping("/vacationtracking")
    public VacationTracking postAnnualVacations(VacationTracking vacationTracking) {
        return vacationTrackingRepository.saveAndFlush(vacationTracking);
    }
}