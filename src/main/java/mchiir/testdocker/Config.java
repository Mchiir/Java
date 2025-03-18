package mchiir.testdocker;

import org.springframework.beans.factory.annotation.Value;
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
public class Config {

    @Value("${spring.security.user.name}")
    private String username;
    @Value("${spring.security.user.password}")
    private String password;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/").permitAll() // Requires authentication for Swagger docs
                        .anyRequest().authenticated() // Allow other requests without authentication
                )
                .httpBasic(Customizer.withDefaults()) // Enables basic authentication
                .csrf(csrf -> csrf.disable()); // CSRF disabled for simplicity

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Environment variables SPRING_SECURITY_USERNAME or SPRING_SECURITY_PASSWORD not set.");
        }

        // Create a user with credentials from environment variables
        UserDetails user = User.builder()
                .username(username) // Use the username from .env
                .password(passwordEncoder().encode(password)) // Encode the password from .env
                .roles("USER") // Assign roles as needed
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
