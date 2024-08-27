package com.sparta.baedallegend.global.config.security;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import com.sparta.baedallegend.auth.filter.JwtFilter;
import com.sparta.baedallegend.auth.service.AuthenticationService;
import com.sparta.baedallegend.auth.utils.jwt.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

	private final AuthenticationService authenticationService;
	private final JwtProperties jwtProperties;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
			.csrf(AbstractHttpConfigurer::disable)
			.formLogin(AbstractHttpConfigurer::disable)
			.httpBasic(AbstractHttpConfigurer::disable)
			.headers(headers -> headers.frameOptions(FrameOptionsConfig::disable))
			.sessionManagement(session -> session.sessionCreationPolicy(STATELESS))

			.authorizeHttpRequests(auth -> auth
				.requestMatchers(POST, "/auth/sign-up", "/auth/sign-in").permitAll()
				.requestMatchers(POST, "/shop/**").permitAll()
				.anyRequest().authenticated()
			)

			.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class)

			.build();
	}

	@Bean
	public JwtFilter jwtFilter() {
		return new JwtFilter(jwtProperties, authenticationService);
	}

}
