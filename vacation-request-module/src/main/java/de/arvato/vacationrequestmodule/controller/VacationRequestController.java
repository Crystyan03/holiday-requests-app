package de.arvato.vacationrequestmodule.controller;


import de.arvato.vacationrequestmodule.data.VacationRequest;
import de.arvato.vacationrequestmodule.service.VacationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/vacationrequest")
public class VacationRequestController {

    @Autowired
    private VacationRequestService vacationRequestService;

    @PostMapping
    public VacationRequest createRequest(@RequestBody VacationRequest vacationRequestDO) {
        return vacationRequestService.createVacationRequest(vacationRequestDO);
    }

    @Transactional
    @GetMapping("availabledays/{empId}")
    public int getVacationBalance(@PathVariable("empId") Long empId) {
        return vacationRequestService.queryVacationBalance(empId);
    }
}
