package com.sparta.baedallegend.global.config.security;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import com.sparta.baedallegend.auth.filter.JwtFilter;
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

	private final JwtFilter jwtFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
			.csrf(AbstractHttpConfigurer::disable)
			.formLogin(AbstractHttpConfigurer::disable)
			.httpBasic(AbstractHttpConfigurer::disable)
			.headers(headers -> headers.frameOptions(FrameOptionsConfig::disable))
			.sessionManagement(session -> session.sessionCreationPolicy(STATELESS))

			// TODO 권한 별 Endpoint 관리를 위한 Enum 정의
			.authorizeHttpRequests(auth -> auth
				.requestMatchers(POST, "/auth/sign-up", "/auth/sign-in").permitAll()
				.requestMatchers(POST, "/shop/**").permitAll()
				.requestMatchers(POST, "/menu/**").permitAll()
				.requestMatchers(GET, "/menu/**").permitAll()
				
				.anyRequest().authenticated()
			)

			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

			.build();
	}

}
