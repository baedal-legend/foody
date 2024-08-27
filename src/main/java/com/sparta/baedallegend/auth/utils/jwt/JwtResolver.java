package com.sparta.baedallegend.auth.utils.jwt;

import static com.sparta.baedallegend.auth.exception.AuthErrorCode.INVALID_SIGNATURE;
import static com.sparta.baedallegend.auth.exception.AuthErrorCode.INVALID_TOKEN_FORMAT;
import static com.sparta.baedallegend.auth.exception.AuthErrorCode.TOKEN_IS_EXPIRED;
import static com.sparta.baedallegend.auth.exception.AuthErrorCode.UNSUPPORTED_AUDIENCE;
import static com.sparta.baedallegend.auth.utils.jwt.JwtUtils.EMAIL;
import static com.sparta.baedallegend.auth.utils.jwt.JwtUtils.ID;
import static com.sparta.baedallegend.auth.utils.jwt.JwtUtils.ROLE;
import static com.sparta.baedallegend.auth.utils.jwt.JwtUtils.generateSigningKey;

import com.sparta.baedallegend.auth.domain.FoodyPrincipal;
import com.sparta.baedallegend.auth.exception.AuthException;
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
			throw new AuthException(UNSUPPORTED_AUDIENCE);
		}
	}

	public static Claims parse(String token, JwtProperties jwtProperties) {
		try {
			SecretKey signingKey = generateSigningKey(jwtProperties.secretKey());

			return Jwts.parser()
				.verifyWith(signingKey)
				.build()
				.parseSignedClaims(token)
				.getPayload();
		} catch (WeakKeyException | NullPointerException weakKeyException) {
			throw new AuthException(INVALID_SIGNATURE);
		} catch (ExpiredJwtException expiredJwtException) {
			throw new AuthException(TOKEN_IS_EXPIRED);
		} catch (MalformedJwtException malformedJwtException) {
			throw new AuthException(INVALID_TOKEN_FORMAT);
		} catch (Exception unexpectedException) {
			throw new RuntimeException(unexpectedException);
		}
	}

	private static FoodyPrincipal extractPrincipal(Claims claims) {
		Long id = claims.get(ID, Long.class);
		String email = claims.get(EMAIL, String.class);
		String roleDetails = claims.get(ROLE, String.class);

		return FoodyPrincipal.of(id, email, roleDetails);
	}

}
