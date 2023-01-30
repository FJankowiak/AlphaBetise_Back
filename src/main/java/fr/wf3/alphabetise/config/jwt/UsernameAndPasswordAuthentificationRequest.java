package fr.wf3.alphabetise.config.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class UsernameAndPasswordAuthentificationRequest {
    private String username;
    private String password;



}
