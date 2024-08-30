package com.sparta.baedallegend.domains.auth.utils.jwt;

import com.sparta.baedallegend.domains.auth.domain.FoodyPrincipal;
import com.sparta.baedallegend.domains.auth.exception.AuthException;
import com.sparta.baedallegend.domains.auth.exception.AuthErrorCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.WeakKeyException;
import java.util.Set;
import javax.crypto.SecretKey;

public class JwtResolver {

	public static FoodyPrincipal resolve(String token, JwtProperties jwtProperties) {
		Claims claims = parse(token, jwtProperties);
		validateAudience(claims, jwtProperties.audience());

		return extractPrincipal(claims);
	}

	private static void validateAudience(Claims claims, String audience) {
		Set<String> audiences = claims.getAudience();

		if (!audiences.contains(audience)) {
			throw new AuthException(AuthErrorCode.UNSUPPORTED_AUDIENCE);
		}
	}

	public static Claims parse(String token, JwtProperties jwtProperties) {
		try {
			SecretKey signingKey = JwtUtils.generateSigningKey(jwtProperties.secretKey());

			return Jwts.parser()
				.verifyWith(signingKey)
				.build()
				.parseSignedClaims(token)
				.getPayload();
		} catch (WeakKeyException | NullPointerException weakKeyException) {
			throw new AuthException(AuthErrorCode.INVALID_SIGNATURE);
		} catch (ExpiredJwtException expiredJwtException) {
			throw new AuthException(AuthErrorCode.TOKEN_IS_EXPIRED);
		} catch (MalformedJwtException malformedJwtException) {
			throw new AuthException(AuthErrorCode.INVALID_TOKEN_FORMAT);
		} catch (Exception unexpectedException) {
			throw new RuntimeException(unexpectedException);
		}
	}

	private static FoodyPrincipal extractPrincipal(Claims claims) {
		Long id = claims.get(JwtUtils.ID, Long.class);
		String email = claims.get(JwtUtils.EMAIL, String.class);
		String roleDetails = claims.get(JwtUtils.ROLE, String.class);

		return FoodyPrincipal.of(id, email, roleDetails);
	}

}
