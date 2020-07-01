package de.arvato.vacationrequestmodule.repositories;


import de.arvato.vacationrequestmodule.data.VacationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRequestRepository extends JpaRepository<VacationRequest, Long> {
}
