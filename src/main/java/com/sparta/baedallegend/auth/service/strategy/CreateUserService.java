package com.sparta.baedallegend.auth.service.strategy;

import com.sparta.baedallegend.auth.controller.model.SignUpRequest;
import com.sparta.baedallegend.user.domain.Role;

public interface CreateUserService {

	Long createUser(SignUpRequest signUpRequest);

	boolean isMatched(Role role);

}
