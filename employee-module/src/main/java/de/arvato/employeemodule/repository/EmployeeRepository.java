package de.arvato.employeemodule.repository;

import de.arvato.employeemodule.model.EmployeeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDO, String> {
}

