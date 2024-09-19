package com.athletereview.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private JwtAuthEntryPoint authEntryPoint;
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	public SecurityConfig(CustomUserDetailsService userDetailsService, JwtAuthEntryPoint authEntryPoint) {
		this.userDetailsService = userDetailsService;
		this.authEntryPoint = authEntryPoint;
		
	}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// Spring 6 security lambda style
        http.csrf((csrf) -> csrf.disable());
        http.exceptionHandling(e -> e.authenticationEntryPoint(authEntryPoint));
        http.sessionManagement(sessionAuthenticationStrategy ->
        		sessionAuthenticationStrategy.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );		
        http.authorizeHttpRequests(request -> {
        	request.requestMatchers("/api/auth/**").permitAll();
			request.requestMatchers("/swagger-ui/index.html", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**").permitAll();
        	request.anyRequest().authenticated();
        });									
        // http.httpBasic(Customizer.withDefaults());
        		
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);	
        
		return http.build();
		
	}

    @Bean
    AuthenticationManager authenticationManager(
             AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

    @Bean
    PasswordEncoder passwordEncoder() {            
		return new BCryptPasswordEncoder();			  
	}


    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

}










