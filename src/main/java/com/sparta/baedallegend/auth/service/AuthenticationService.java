package com.sparta.baedallegend.auth.service;

import com.sparta.baedallegend.auth.controller.model.SignInRequest;
import com.sparta.baedallegend.auth.domain.FoodyPrincipal;
import com.sparta.baedallegend.auth.exception.AuthErrorCode;
import com.sparta.baedallegend.auth.exception.AuthException;
import com.sparta.baedallegend.user.domain.User;
import com.sparta.baedallegend.user.repo.UserRepo;
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

		return FoodyPrincipal.of(user.getId(), user.getRole());
	}

	private User loadUserByUsername(String email) {
		return userRepo.findByEmail(email)
			.orElseThrow(() -> new AuthException(AuthErrorCode.BAD_CREDENTIALS));
	}

	private void checkPasswordIsMatched(SignInRequest signInRequest, User user) {
		if (!passwordEncoder.matches(signInRequest.password(), user.getPassword())) {
			throw new AuthException(AuthErrorCode.BAD_CREDENTIALS);
		}
	}

}
