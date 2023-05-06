package fr.wf3.alphabetise.config.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "application.jwt")
@NoArgsConstructor @Getter //@Setter
public class JwtConfig {
    private String secretKey;
    private String tokenPrefix;
    @Setter
    private Integer tokenExpirationAfterHours;

    public String getAuthorisationHeader(){
        return HttpHeaders.AUTHORIZATION;
    }
}
