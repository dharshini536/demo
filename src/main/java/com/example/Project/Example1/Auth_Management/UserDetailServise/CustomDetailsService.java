    package com.example.Project.Example1.Auth_Management.UserDetailServise;

    import com.example.Project.Example1.adminManagement.adapter.UserAdapter;
    import com.example.Project.Example1.adminManagement.entity.UserAccount;
    import com.example.Project.Example1.adminManagement.Repository.UserRepository;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Service;

    import java.util.Optional;
    import java.util.stream.Collectors;

    @Service
    public class CustomDetailsService implements UserDetailsService {
        private final UserRepository userRepo;
        private final UserAdapter userAdapter;


        public CustomDetailsService(UserRepository userRepo, UserAdapter userAdapter) {
            this.userRepo = userRepo;
            this.userAdapter = userAdapter;
        }

        @Override
        public UserDetails loadUserByUsername(String emailOrMobile) throws UsernameNotFoundException {
            Optional<UserAccount> optionalUser;

            if (emailOrMobile.contains("@")) {
                optionalUser = userAdapter.findByEmail(emailOrMobile);
            } else {
                optionalUser = userAdapter.findByMobileNumber(emailOrMobile);
            }

            UserAccount user = optionalUser
                    .orElseThrow(() -> new UsernameNotFoundException("User not found: " + emailOrMobile));

            var authorities = user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());

            return new org.springframework.security.core.userdetails.User(
                    emailOrMobile,
                    user.getPassword(),
                    authorities
            );
        }
    }