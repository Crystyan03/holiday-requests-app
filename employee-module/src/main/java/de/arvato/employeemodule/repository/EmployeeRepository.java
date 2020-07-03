package de.arvato.employeemodule.repository;

import de.arvato.employeemodule.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Iterable<Employee> findAllBySupervisor(boolean supervisor);

    Employee findByUsername(String username);
}

