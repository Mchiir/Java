package study.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/","/h2_console/**").permitAll() // Requires authentication for Swagger docs
                        .anyRequest().authenticated() // Allow other requests without authentication
                )
                .httpBasic(Customizer.withDefaults()) // Enables basic authentication
                .headers(headers -> headers
                        .frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()))
                .csrf(csrf -> csrf.disable()); // Disable CSRF for simplicity (consider your security needs)

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        String username = "user";
        String password = "user";

        UserDetails user = User.builder()
                .username(username) // Use the username from .env
                .password(passwordEncoder().encode(password)) // Encode the password from .env
                .roles("USER") // Assign roles as needed
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}