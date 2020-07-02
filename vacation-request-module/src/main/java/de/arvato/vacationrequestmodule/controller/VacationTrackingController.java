package de.arvato.vacationrequestmodule.controller;


import de.arvato.vacationrequestmodule.data.VacationTracking;
import de.arvato.vacationrequestmodule.service.VacationTrackerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class VacationTrackingController {

    @Autowired
    private VacationTrackerService vacationTrackerService;

    @PostMapping("/vacationtracking")
    public VacationTracking createRequest(@RequestBody VacationTracking vacationTracking) {
        return vacationTrackerService.postAnnualVacations(vacationTracking);
    }
}
