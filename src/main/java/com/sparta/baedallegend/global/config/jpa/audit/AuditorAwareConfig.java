package com.sparta.baedallegend.global.config.jpa.audit;

import static org.springframework.security.config.Elements.ANONYMOUS;

import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class AuditorAwareConfig {

	@Bean
	public AuditorAware<Long> auditorAware() {
		return () -> Optional.of(SecurityContextHolder.getContext())
			.map(SecurityContext::getAuthentication)
			.filter(this::isAuthenticated)
			.map(Authentication::getPrincipal)
			.map(Long.class::cast);
	}

	private boolean isAuthenticated(Authentication authentication) {
		return authentication.isAuthenticated() && isNotAnonymousUser(authentication);
	}

	private boolean isNotAnonymousUser(Authentication authentication) {
		return !authentication.getName().contains(ANONYMOUS);
	}

}
