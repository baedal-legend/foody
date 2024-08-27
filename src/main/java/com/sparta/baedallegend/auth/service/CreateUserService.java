package com.sparta.baedallegend.auth.service;

import com.sparta.baedallegend.auth.controller.model.SignUpRequest;
import com.sparta.baedallegend.auth.controller.model.SignUpType;

public interface CreateUserService {

	Long createUser(SignUpRequest signUpRequest);

	boolean isMatched(SignUpType signUpType);

}
