package de.arvato.vacationrequestui.security.service;

import de.arvato.vacationrequestui.security.model.User;
import de.arvato.vacationrequestui.security.model.UserPrincipal;
import de.arvato.vacationrequestui.security.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(user);
    }
}
