package com.sparta.baedallegend.domains.auth.utils.jwt;

import static org.springframework.security.config.Elements.JWT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = JWT)
public record JwtProperties(
	@Value("${spring.application.name}") String issuer,
	String audience,
	int expirationMinutes,
	String secretKey

) {

}
