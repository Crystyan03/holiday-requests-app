package de.arvato.vacationrequestmodule.repositories;


import de.arvato.vacationrequestmodule.data.VacationRequestDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRequestRepository extends JpaRepository<VacationRequestDO, String> {
}
