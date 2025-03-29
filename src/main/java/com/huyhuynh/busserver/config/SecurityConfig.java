package com.huyhuynh.busserver.config;

import com.huyhuynh.busserver.security.jwt.JwtRequestFilter;
import com.huyhuynh.busserver.services.AccountInfoService;
import com.huyhuynh.busserver.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Configuration
public class SecurityConfig {

    @Autowired
    private final AccountInfoService accountInfoService;

    @Autowired
    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(AccountInfoService accountInfoService, JwtRequestFilter jwtRequestFilter) {
        this.accountInfoService = accountInfoService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(accountInfoService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(List.of(authProvider));
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers(
                            getAllowedUrls()
                    ).permitAll() //cho phép call mà ko cần token
                    .anyRequest().authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private String[] getAllowedUrls() {
        return Stream.concat(
                Arrays.stream(getListPagePermit()),
                Arrays.stream(getListApiPermit())
        ).toArray(String[]::new);
    }

    private String[] getListPagePermit(){
        return new String[]{
                "/register/**",
                "/company/**",
                "/login/**",
                "/register/css/**",
                "/register/js/**"
        };
    }

    private String[] getListApiPermit(){
        return new String[]{
                "/login",
                Constants.apiPrePath+"/company/create",
                Constants.apiPrePath+"/account/register",
                Constants.apiPrePath+"/authentication/authenticate",
        };
    }
}
