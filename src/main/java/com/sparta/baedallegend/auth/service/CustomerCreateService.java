package com.sparta.baedallegend.auth.service;

import com.sparta.baedallegend.auth.controller.model.SignUpRequest;
import com.sparta.baedallegend.auth.controller.model.SignUpType;
import com.sparta.baedallegend.user.domain.User;
import com.sparta.baedallegend.user.domain.wrap.Password;
import com.sparta.baedallegend.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerCreateService implements CreateUserService {

	private final UserRepo userRepo;
	private final PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	public Long createUser(SignUpRequest signUpRequest) {
		Password encodedPassword = encryptPassword(signUpRequest.password());
		User savedUser = userRepo.save(signUpRequest.toEntity(encodedPassword));

		return savedUser.getId();
	}

	@Override
	public boolean isMatched(SignUpType signUpType) {
		return signUpType.isCustomer();
	}

	private Password encryptPassword(String password) {
		String encodePassword = passwordEncoder.encode(password);
		return Password.from(encodePassword);
	}

}
