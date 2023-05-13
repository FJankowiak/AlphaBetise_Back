package fr.wf3.alphabetise.config;

import fr.wf3.alphabetise.config.jwt.JwtConfig;
import fr.wf3.alphabetise.config.jwt.JwtTokenVerifier;
import fr.wf3.alphabetise.config.jwt.JwtUsernameAndPasswordAuthentificationFilter;
import fr.wf3.alphabetise.services.UserAuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.crypto.SecretKey;
import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
//@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration /*extends WebSecurityConfigurerAdapter */ {
    private final PasswordEncoder passwordEncoder;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;
    private final UserAuthentificationService userAuthentificationService;
    private final CustomAuthenticationManager customAuthenticationManager;
    private final JwtTokenVerifier jwtTokenVerifier;

    @Autowired
    public SecurityConfiguration(PasswordEncoder passwordEncoder, SecretKey secretKey, JwtConfig jwtConfig, UserAuthentificationService userAuthentificationService, CustomAuthenticationManager customAuthenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
        this.userAuthentificationService = userAuthentificationService;
        this.customAuthenticationManager = customAuthenticationManager;
        this.jwtTokenVerifier = new JwtTokenVerifier(secretKey, jwtConfig);
    }

//    @Override
//    protected void configure(AuthentificationManagerBuilder)

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .cors().configurationSource(request -> {
                    CorsConfiguration cors = new CorsConfiguration().applyPermitDefaultValues();
                    cors.addAllowedMethod(HttpMethod.GET);
                    cors.addAllowedMethod(HttpMethod.POST);
                    cors.addAllowedMethod(HttpMethod.PUT);
                    cors.addAllowedMethod(HttpMethod.DELETE);
                    cors.addAllowedHeader("*");
                    // Ajouter le fait d'exposer le header qui contiendra le token
                    cors.addExposedHeader("Authorization");
                    // Potentiellement, on peut ajouter une whitelist des sites autorisés
                    //                cors.addAllowedOrigin("http://localhost:4200);
                    return cors;

                })
//                .and().authorizeRequests().antMatchers("/livres/books**").permitAll()
//                .and().authorizeRequests().antMatchers("/login").permitAll()
//                .and().authorizeRequests().anyRequest().authenticated()
                .and().authorizeRequests().anyRequest().permitAll()
        ;
        // Provoquer une erreur 401 quand on est pas authentifié
        http.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
        // Mettre en place les filtres de tokens situés ailleurs dans le projet
        http.addFilterBefore(new JwtUsernameAndPasswordAuthentificationFilter(customAuthenticationManager, jwtConfig, secretKey), UsernamePasswordAuthenticationFilter.class);
        http.addFilterAfter(jwtTokenVerifier, UsernamePasswordAuthenticationFilter.class);

        return http.build();
        // Pallier au CORS policy
//        http.cors().configurationSource(new CorsConfigurationSource() {
//            @Override
//            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//            }
//        });
    }

//    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }

    @Bean
    public Filter authCheckFilter() {
        // supply dependencies
        return jwtTokenVerifier;
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userAuthentificationService);
        return provider;
    }
}
