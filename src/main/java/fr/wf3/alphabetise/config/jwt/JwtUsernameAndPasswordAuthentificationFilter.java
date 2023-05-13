package fr.wf3.alphabetise.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class JwtUsernameAndPasswordAuthentificationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    public JwtUsernameAndPasswordAuthentificationFilter(AuthenticationManager authentificationManager, JwtConfig jwtConfig, SecretKey secretKey) {
        this.authenticationManager = authentificationManager;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UsernameAndPasswordAuthentificationRequest authenticationRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), UsernameAndPasswordAuthentificationRequest.class);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword()
            );

            System.err.println(authenticationRequest.getPassword());

            System.err.println("authentication : " + authentication);

            Authentication authenticate = authenticationManager.authenticate(authentication);
            return authenticate;

        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        // Ajouts pour un token en heures plutôt qu'en jours
        Calendar expirationTime = Calendar.getInstance();
        expirationTime.setTime(new Date());
        expirationTime.add(Calendar.HOUR, jwtConfig.getTokenExpirationAfterHours());

        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(expirationTime.getTime())
//                .setExpiration(java.sql.Date.valueOf(LocalDate.now()
//                        .plusDays(jwtConfig.getTokenExpirationAfterHours())
//                ))
                .setSubject(authResult.getName()) // je ne sais pas ce que ça fait
                .signWith(secretKey)
                .compact();

        response.addHeader(jwtConfig.getAuthorisationHeader(), jwtConfig.getTokenPrefix()+token);
    }

}
