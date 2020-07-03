package de.arvato.vacationrequestmodule.repositories;


import de.arvato.vacationrequestmodule.data.RequestStatus;
import de.arvato.vacationrequestmodule.data.VacationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VacationRequestRepository extends JpaRepository<VacationRequest, Long> {

    @Query("select vr from VacationRequest vr where vr.empId = :empId and vr.status ='APPROVED'")
    List<VacationRequest> getApprovedVacationRequest(Long empId);

    @Query("select vr from VacationRequest vr where vr.supervisorId = :supervisorId")
    List<VacationRequest> getVacationRequestsWithSupervisor(Long supervisorId);

    @Query("select vr from VacationRequest vr where vr.empId = :employeeId")
    List<VacationRequest> getVacationRequestsByEmpId(Long employeeId);

    @Query("select vr from VacationRequest vr where vr.status in :status and vr.from BETWEEN :fromDate and :toDate")
    List<VacationRequest> getMonthlyVacationReport(LocalDate fromDate, LocalDate toDate, List<RequestStatus> status);
}
