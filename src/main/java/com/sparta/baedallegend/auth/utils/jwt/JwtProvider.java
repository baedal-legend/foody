package com.sparta.baedallegend.auth.utils.jwt;

import static com.sparta.baedallegend.auth.utils.jwt.SingingUtils.generateSigningKey;

import com.sparta.baedallegend.auth.domain.FoodyPrincipal;
import io.jsonwebtoken.Jwts;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.crypto.SecretKey;

public class JwtProvider {

	private static final String ID = "id";
	private static final String ROLE = "role";

	public static String create(
		JwtProperties jwtProperties,
		FoodyPrincipal principal
	) {
		SecretKey signingKey = generateSigningKey(jwtProperties.secretKey());
		Instant issuedAt = Instant.now();
		Date expirationDate = getExpirationDate(issuedAt, jwtProperties.expirationMinutes());

		return Jwts.builder()
			.issuer(jwtProperties.issuer())
			.issuedAt(Date.from(issuedAt))
			.audience().add(jwtProperties.audience())
			.and()
			.claim(ID, principal.id())
			.claim(ROLE, principal.role())
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
