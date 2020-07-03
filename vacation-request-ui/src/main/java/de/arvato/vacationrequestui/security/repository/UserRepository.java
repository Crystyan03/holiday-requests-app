package de.arvato.vacationrequestui.security.repository;

import de.arvato.vacationrequestui.security.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
