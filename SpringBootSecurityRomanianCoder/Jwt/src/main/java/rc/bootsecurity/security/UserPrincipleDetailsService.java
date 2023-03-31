package rc.bootsecurity.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rc.bootsecurity.db.UserRepository;
import rc.bootsecurity.model.User;

@Service
public class UserPrincipleDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public UserPrincipleDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);

        return new UserPrinciple(user);
    }
}
