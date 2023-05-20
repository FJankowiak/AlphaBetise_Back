package fr.wf3.alphabetise.config;

import fr.wf3.alphabetise.entities.User;
import fr.wf3.alphabetise.security.MyUserDetails;
import fr.wf3.alphabetise.services.UserAuthentificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {
    private final UserAuthentificationService userAuthentificationService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MyUserDetails user = userAuthentificationService.loadUserByUsername(authentication.getName());
        String pwd = authentication.getCredentials().toString();
        if(!getPasswordEncoder().matches(pwd, user.getPassword())) {
//            System.err.println(pwd);
//            System.err.println(user.getPassword());
//            System.err.println(getPasswordEncoder().matches(pwd, user.getPassword()));
            throw new BadCredentialsException("Wrong login/password");
        }
        return new UsernamePasswordAuthenticationToken(user, user.getPassword());
    }
}
