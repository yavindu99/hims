package hims.login.version2.service;

import hims.login.version2.entity.User;
import hims.login.version2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service(value = "userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User loadUserByUsername(String userId) {

        User user = userRepository.findUserByUserId(userId);

        new AccountStatusUserDetailsChecker().check(user);

        return user;

    }

}
