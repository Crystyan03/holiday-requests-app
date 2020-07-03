package de.arvato.vacationrequestmodule.service;


import de.arvato.vacationrequestmodule.data.VacationRequest;
import de.arvato.vacationrequestmodule.data.VacationTracking;
import de.arvato.vacationrequestmodule.exceptions.VacationRequestStatusBadRequest;
import de.arvato.vacationrequestmodule.repositories.VacationRequestRepository;
import de.arvato.vacationrequestmodule.repositories.VacationTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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


    public Optional<VacationRequest> getVacationRequestById(Long id) {
        return vacationRequestRepository.findById(id);
    }


    public List<VacationRequest> getVacationRequestBySupervisorAndEmplyoeeId(Long supervisorId, Long employeeId) {
        List<VacationRequest> vacationRequests = null;

        if (Objects.nonNull(supervisorId)) {
            vacationRequests = vacationRequestRepository.getVacationRequestsWithSupervisor(supervisorId);
        } else {
            vacationRequests = vacationRequestRepository.getVacationRequestsByEmpId(employeeId);
        }
        return vacationRequests;
    }

    public VacationRequest updateVacationRequest(VacationRequest request, Boolean isSupervisor) {
        validateIsSupervisorCondition(request, isSupervisor);
        return vacationRequestRepository.save(request);
    }


    //--------------------------------------------------------------------------------------------------
    //                                      UTILS
    //--------------------------------------------------------------------------------------------------

    private void validateIsSupervisorCondition(VacationRequest request, Boolean isSupervisor) {
        if (!isSupervisor) {
            if (!(getVacationRequestById(request.getRequestID()).get().getStatus()).equals(request.getStatus())) {
                throw new VacationRequestStatusBadRequest("Only Supervisor can update the REQUEST STATUS");
            }
        }
    }
}
