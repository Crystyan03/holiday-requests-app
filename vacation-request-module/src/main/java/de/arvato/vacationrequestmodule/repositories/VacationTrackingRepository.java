package de.arvato.vacationrequestmodule.repositories;

import de.arvato.vacationrequestmodule.data.VacationTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationTrackingRepository extends JpaRepository<VacationTracking, Long> {
}
