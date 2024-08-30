package com.sparta.baedallegend.domains.auth.service.strategy;

import com.sparta.baedallegend.domains.auth.controller.model.SignUpRequest;
import com.sparta.baedallegend.domains.user.domain.Role;
import com.sparta.baedallegend.domains.user.domain.User;
import com.sparta.baedallegend.domains.user.domain.wrap.Password;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CreateCustomerStrategy implements CreateUserService {

	private final EntityManager entityManager;
	private final PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public Long createUser(SignUpRequest signUpRequest) {
		Password encodedPassword = encryptPassword(signUpRequest.password());
		User savedUser = saveUser(signUpRequest.toEntity(encodedPassword));

		return savedUser.getId();
	}

	public User saveUser(User user) {
		entityManager.persist(user);
		entityManager.flush();
		user.applyUserCreated(user.getId());

		return user;
	}

	@Override
	public boolean isMatched(Role role) {
		return role.isCustomer();
	}

	private Password encryptPassword(String password) {
		String encodePassword = passwordEncoder.encode(password);
		return Password.from(encodePassword);
	}

}
