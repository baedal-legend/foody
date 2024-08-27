package com.sparta.baedallegend.auth.service;

import com.sparta.baedallegend.auth.controller.model.SignUpRequest;
import com.sparta.baedallegend.auth.exception.AuthErrorCode;
import com.sparta.baedallegend.auth.exception.AuthException;
import com.sparta.baedallegend.user.repo.UserRepo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignUpFacade {

	private final UserRepo userRepo;
	private final List<CreateUserService> createUserServices;

	public Long signUp(SignUpRequest signUpRequest) {
		validate(signUpRequest);

		return createUserServices.stream()
			.filter(it -> it.isMatched(signUpRequest.signUpType()))
			.findAny()
			.orElseThrow()
			.createUser(signUpRequest)
			;
	}

	private void validate(SignUpRequest signUpRequest) {
		validateDuplicatedEmail(signUpRequest.email());
		validateDuplicatedNickname(signUpRequest.nickname());
	}

	private void validateDuplicatedEmail(String email) {
		if (userRepo.existsByEmail(email)) {
			throw new AuthException(AuthErrorCode.DUPLICATED_EMAIL, email);
		}
	}

	private void validateDuplicatedNickname(String nickname) {
		if (userRepo.existsByNickname(nickname)) {
			throw new AuthException(AuthErrorCode.DUPLICATED_NICKNAME, nickname);
		}
	}

}
