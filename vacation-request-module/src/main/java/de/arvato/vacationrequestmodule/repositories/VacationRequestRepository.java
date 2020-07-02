package de.arvato.vacationrequestmodule.repositories;


import de.arvato.vacationrequestmodule.data.VacationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRequestRepository extends JpaRepository<VacationRequest, Long> {

    @Query("select vr from VacationRequest vr where vr.empId = :empId and vr.status ='APPROVED'")
    List<VacationRequest> getApprovedVacationRequest(Long empId);
}
