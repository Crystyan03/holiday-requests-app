package de.arvato.vacationrequestmodule.repositories;

import de.arvato.vacationrequestmodule.data.VacationTrackingDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationTrackingRepository extends JpaRepository<VacationTrackingDO, String> {
}
