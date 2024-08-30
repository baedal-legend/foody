package com.sparta.baedallegend.domains.auth.service.strategy;

import com.sparta.baedallegend.domains.auth.controller.model.SignUpRequest;
import com.sparta.baedallegend.domains.user.domain.Role;

public interface CreateUserService {

	Long createUser(SignUpRequest signUpRequest);

	boolean isMatched(Role role);

}
