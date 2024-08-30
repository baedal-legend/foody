package com.sparta.baedallegend.global.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.baedallegend.domains.auth.filter.JwtFilter;
import com.sparta.baedallegend.domains.auth.service.AuthenticationService;
import com.sparta.baedallegend.domains.auth.utils.jwt.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AuthorizationConfig {

	private final AuthenticationService authenticationService;
	private final JwtProperties jwtProperties;
	private final ObjectMapper objectMapper;

	@Bean
	public JwtFilter jwtFilter() {
		return new JwtFilter(jwtProperties, authenticationService);
	}

}
