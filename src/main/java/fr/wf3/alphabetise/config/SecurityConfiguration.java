package fr.wf3.alphabetise.config;

import fr.wf3.alphabetise.config.jwt.JwtConfig;
import fr.wf3.alphabetise.config.jwt.JwtTokenVerifier;
import fr.wf3.alphabetise.config.jwt.JwtUsernameAndPasswordAuthentificationFilter;
import fr.wf3.alphabetise.services.UserAuthentificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;

@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    private final UserAuthentificationService userAuthentificationService;

    public SecurityConfiguration(SecretKey secretKey, JwtConfig jwtConfig, UserAuthentificationService userAuthentificationService) {
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
        this.userAuthentificationService = userAuthentificationService;
    }

//    @Override
//    protected void configure(AuthentificationManagerBuilder)

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthentificationFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordAuthentificationFilter.class)
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest()
                .authenticated();

        // Pallier au CORS policy
        http.cors().configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration cors = new CorsConfiguration().applyPermitDefaultValues();
                cors.addAllowedMethod(HttpMethod.GET);
                cors.addAllowedMethod(HttpMethod.POST);
                cors.addAllowedMethod(HttpMethod.PUT);
                cors.addAllowedMethod(HttpMethod.DELETE);
//                cors.addAllowedOrigin(); // TODO ajouter
                return cors;
            }
        });
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(getPasswordEncoder());
        provider.setUserDetailsService(userAuthentificationService);
        return provider;
    }
}
