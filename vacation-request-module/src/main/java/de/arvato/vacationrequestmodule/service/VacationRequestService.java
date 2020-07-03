package de.arvato.vacationrequestmodule.service;


import com.google.common.collect.ImmutableMap;
import de.arvato.vacationrequestmodule.VacationRequestConfigurations;
import de.arvato.vacationrequestmodule.component.EmailServiceImpl;
import de.arvato.vacationrequestmodule.data.Employee;
import de.arvato.vacationrequestmodule.data.VacationRequest;
import de.arvato.vacationrequestmodule.data.VacationTracking;
import de.arvato.vacationrequestmodule.exceptions.VacationRequestStatusBadRequest;
import de.arvato.vacationrequestmodule.repositories.VacationRequestRepository;
import de.arvato.vacationrequestmodule.repositories.VacationTrackingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static de.arvato.vacationrequestmodule.validator.VacationRequestValidator.validateVacationRequest;
import static java.time.temporal.ChronoUnit.DAYS;

@Service
@Slf4j
public class VacationRequestService {

    @Autowired
    VacationRequestConfigurations configurations;

    @Autowired
    private VacationRequestRepository vacationRequestRepository;

    @Autowired
    private VacationTrackingRepository vacationTrackingRepository;

    @Autowired
    private EmailServiceImpl emailServiceImpl;

    public VacationRequest createVacationRequest(VacationRequest vacationRequest) {
        validateVacationRequest(vacationRequest);

        //call vacation request module
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> uriParams = ImmutableMap.<String, String>builder().put("id", vacationRequest.getSupervisorId().toString())
                .build();

        String url = configurations.getEmployeeModuleUri() + "/{id}";
        ResponseEntity<Employee> employeeSupervisor = restTemplate.getForEntity(url, Employee.class, uriParams);
        if (employeeSupervisor.getBody().isSupervisor()) {
            String message = "New VacationRequest was added! by the user: " + employeeSupervisor.getBody().getUsername();
            emailServiceImpl.sendSimpleMessage(employeeSupervisor.getBody().getEmail(), "VacationRequest", message);
        } else {
            log.error("Employee is not a supervisor!!");
        }
        return vacationRequestRepository.saveAndFlush(vacationRequest);
    }

    public int queryVacationBalance(Long empId) {
        VacationTracking vacationTracking = vacationTrackingRepository.getOne(empId);

        List<VacationRequest> approvedVacationRequest = vacationRequestRepository.getApprovedVacationRequest(empId);

        List<Long> vacationDaysList = approvedVacationRequest.stream().map(vacationRequest -> {
            return (DAYS.between(vacationRequest.getFrom(), vacationRequest.getTo()));
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
