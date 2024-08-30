package com.sparta.baedallegend.domains.auth.utils.jwt;

import com.sparta.baedallegend.domains.auth.domain.FoodyPrincipal;
import io.jsonwebtoken.Jwts;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.crypto.SecretKey;

public class JwtProvider {


	public static String create(
		JwtProperties jwtProperties,
		FoodyPrincipal principal
	) {
		SecretKey signingKey = JwtUtils.generateSigningKey(jwtProperties.secretKey());
		Instant issuedAt = Instant.now();
		Date expirationDate = getExpirationDate(issuedAt, jwtProperties.expirationMinutes());

		return Jwts.builder()
			.issuer(jwtProperties.issuer())
			.issuedAt(Date.from(issuedAt))
			.audience().add(jwtProperties.audience())
			.and()
			.claim(JwtUtils.ID, principal.id())
			.claim(JwtUtils.ROLE, principal.roleDetails())
			.claim(JwtUtils.EMAIL, principal.email())
			.expiration(expirationDate)
			.signWith(signingKey)
			.compact();
	}

	private static Date getExpirationDate(Instant issuedAt, int expirationMinutes) {
		Instant expriationInstant = issuedAt
			.plus(expirationMinutes, ChronoUnit.MINUTES);
		return Date.from(expriationInstant);
	}

}
