package de.arvato.vacationrequestmodule.controller;


import de.arvato.vacationrequestmodule.data.VacationRequest;
import de.arvato.vacationrequestmodule.service.VacationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationRequestController {

    @Autowired
    private VacationRequestService vacationRequestService;

    @PostMapping("/vacationrequest")
    public VacationRequest createRequest(@RequestBody VacationRequest vacationRequestDO) {
        return vacationRequestService.createVacationRequest(vacationRequestDO);
    }

}
