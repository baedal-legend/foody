package com.sparta.baedallegend.domains.auth.service;

import com.sparta.baedallegend.domains.auth.controller.model.SignInRequest;
import com.sparta.baedallegend.domains.auth.domain.FoodyPrincipal;
import com.sparta.baedallegend.domains.auth.exception.AuthErrorCode;
import com.sparta.baedallegend.domains.auth.exception.AuthException;
import com.sparta.baedallegend.domains.user.domain.User;
import com.sparta.baedallegend.domains.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepo userRepo;
	private final PasswordEncoder passwordEncoder;
	private final TokenService tokenService;

	public String authenticate(SignInRequest signInRequest) {
		FoodyPrincipal principal = verifyUser(signInRequest);
		return tokenService.issueAccessToken(principal);
	}

	private FoodyPrincipal verifyUser(SignInRequest signInRequest) {
		User user = loadUserByUsername(signInRequest.email());
		checkPasswordIsMatched(signInRequest, user);

		return FoodyPrincipal.of(user.getId(), user.getEmail(), user.getRoleDetails());
	}

	public User loadUserByUsername(String email) {
		return userRepo.findByEmail(email)
			.orElseThrow(() -> new AuthException(AuthErrorCode.BAD_CREDENTIALS));
	}

	private void checkPasswordIsMatched(SignInRequest signInRequest, User user) {
		if (!passwordEncoder.matches(signInRequest.password(), user.getPassword())) {
			throw new AuthException(AuthErrorCode.BAD_CREDENTIALS);
		}
	}

}
