package com.faber.configuration;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.faber.exception.AccessDeniedExceptionHandler;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 * @email nguyenducthien@fabercompany.co.jp
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and();//enable CORS
        http.exceptionHandling().accessDeniedHandler(new AccessDeniedExceptionHandler());//Add custom access denied handler
        http.headers().contentSecurityPolicy(
                "default-src 'self' 'unsafe-inline'; img-src 'self' data:; media-src localhost; script-src 'self' 'unsafe-inline'; font-src 'self' fonts.gstatic.com; style-src 'self' 'unsafe-inline'  fonts.googleapis.com");//Add csp
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://localhost:8080",
                                                      "http://localhost:8080"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
