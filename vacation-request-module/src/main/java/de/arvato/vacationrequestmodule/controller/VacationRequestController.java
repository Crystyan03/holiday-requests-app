package de.arvato.vacationrequestmodule.controller;


import de.arvato.vacationrequestmodule.data.VacationRequest;
import de.arvato.vacationrequestmodule.service.VacationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vacationrequest")
public class VacationRequestController {

    @Autowired
    private VacationRequestService vacationRequestService;

    @GetMapping("{requestId}")
    public Optional<VacationRequest> getVacationRequest(@PathVariable("requestId") Long requestId) {
        return vacationRequestService.getVacationRequestById(requestId);
    }

    @GetMapping
    public List<VacationRequest> getVacationRequest(@RequestParam(value = "supervisorId", required = false) Long supervisorId, @RequestParam(value = "employeeId", required = false) Long employeeId) {
        return vacationRequestService.getVacationRequestBySupervisorAndEmplyoeeId(supervisorId, employeeId);
    }

    @PostMapping
    public VacationRequest createRequest(@RequestBody VacationRequest vacationRequest) {
        return vacationRequestService.createVacationRequest(vacationRequest);
    }

    @PutMapping
    public VacationRequest updateVacationRequest(@RequestParam(value = "isSupervisor") Boolean isSupervisor, @RequestBody VacationRequest vacationRequest) {
        return vacationRequestService.updateVacationRequest(vacationRequest, isSupervisor);
    }

    @GetMapping("availabledays/{empId}")
    public int getVacationBalance(@PathVariable("empId") Long empId) {
        return vacationRequestService.queryVacationBalance(empId);
    }
}
