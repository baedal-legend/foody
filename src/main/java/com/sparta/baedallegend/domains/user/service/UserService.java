package com.sparta.baedallegend.domains.user.service;

import com.sparta.baedallegend.domains.user.controller.model.UserResponse;
import com.sparta.baedallegend.domains.user.domain.User;
import com.sparta.baedallegend.domains.user.exception.UserErrorCode;
import com.sparta.baedallegend.domains.user.exception.UserException;
import com.sparta.baedallegend.domains.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

	private final UserRepo userRepo;

	public UserResponse loadUserById(Long id) {
		return UserResponse.from(findUser(id));
	}

	public User findUser(Long id) {
		return userRepo.findById(id)
			.orElseThrow(() -> new UserException(UserErrorCode.NOT_EXIST, id));
	}

	@Transactional
	public void deleteUser(Long id) {
		User user = findUser(id);
		user.delete();
	}

}
