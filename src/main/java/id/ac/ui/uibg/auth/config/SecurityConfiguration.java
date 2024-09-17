package id.ac.ui.uibg.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.authorizeHttpRequests((requests) -> requests
//
//                        .requestMatchers("/", "/home", "/product/products", "/api/v1/auth/**", "/register", "/css/**", "/js/**", "/img/**", "/scss/**", "/fonts/**").permitAll()
//                        .requestMatchers("/product/update/**", "/product/delete/**")
//                        .anyRequest().authenticated())
//                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer
//                        .loginPage("/login").permitAll()
//                        .defaultSuccessUrl("/", true)
//                        .failureUrl("/login?error=true"))
//                .build();
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors().configurationSource(request -> {
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.setAllowedOriginPatterns(List.of("*"));
                    configuration.setAllowedHeaders(List.of("Authorization", "Content-Type", "Accept"));
                    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH"));
                    return configuration;
                }).and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**")
                .permitAll()
                .requestMatchers("/api/tournaments/**").authenticated()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
