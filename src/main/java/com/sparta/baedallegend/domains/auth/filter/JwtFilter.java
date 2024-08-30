package com.sparta.baedallegend.domains.auth.filter;

import static com.sparta.baedallegend.domains.auth.utils.jwt.RequestHeaderUtils.BEARER_PREFIX;
import static com.sparta.baedallegend.domains.auth.utils.jwt.RequestHeaderUtils.extractJwt;

import com.sparta.baedallegend.domains.auth.domain.FoodyPrincipal;
import com.sparta.baedallegend.domains.auth.exception.AuthException;
import com.sparta.baedallegend.domains.auth.service.AuthenticationService;
import com.sparta.baedallegend.domains.auth.utils.jwt.JwtProperties;
import com.sparta.baedallegend.domains.auth.utils.jwt.JwtResolver;
import com.sparta.baedallegend.domains.auth.exception.AuthErrorCode;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

	private static final String EXCEPTION = "exception";

	private final JwtProperties jwtProperties;
	private final AuthenticationService authenticationService;

	@Override
	protected void doFilterInternal(
		HttpServletRequest request,
		HttpServletResponse response,
		FilterChain chain
	) throws ServletException, IOException {
		String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (StringUtils.hasText(authorizationHeader)) {
			try {
				String token = extractToken(authorizationHeader);
				FoodyPrincipal principal = extractPrincipal(token);
				registerAuthentication(principal, request);
			} catch (Exception e) {
				request.setAttribute(EXCEPTION, e);
			}
		}
		chain.doFilter(request, response);
	}

	private String extractToken(String authorizationHeader) {
		checkIsBearerToken(authorizationHeader);
		return extractJwt(authorizationHeader);
	}

	private void checkIsBearerToken(String header) {
		if (!header.startsWith(BEARER_PREFIX)) {
			throw new AuthException(AuthErrorCode.IS_NOT_BEARER_TOKEN);
		}
	}

	private FoodyPrincipal extractPrincipal(String token) {
		FoodyPrincipal principal = JwtResolver.resolve(token, jwtProperties);
		authenticationService.loadUserByUsername(principal.email());

		return principal;
	}

	private void registerAuthentication(FoodyPrincipal principal, HttpServletRequest request) {
		UsernamePasswordAuthenticationToken authentication = createUsernamePasswordToken(principal);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	}

	private static UsernamePasswordAuthenticationToken createUsernamePasswordToken(
		FoodyPrincipal principal
	) {
		GrantedAuthority authority = new SimpleGrantedAuthority(principal.roleDetails());

		return new UsernamePasswordAuthenticationToken(
			principal.id(),
			null,
			List.of(authority)
		);
	}

}
