package fr.wf3.alphabetise.services;

import fr.wf3.alphabetise.entities.User;
import fr.wf3.alphabetise.repositories.UserRepository;
import fr.wf3.alphabetise.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private User findByUsername(String username){
        return userRepository.findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Login/mot de passe non reconnus")
                );
    }

    @Override
    @Transactional(readOnly = true)
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.err.println("dans le loadUserByUsername");
        if(username == null || username.equals("")){
            throw new UsernameNotFoundException("Login/mot de passe non reconnus");
        }

        User u = findByUsername(username);
//
//        if(!u.isPresent()){
//            throw new UsernameNotFoundException("Login/mot de passe non reconnus");
//        }

        return new MyUserDetails(u);
    }

//    @Override
}
