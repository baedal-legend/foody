package com.sparta.baedallegend.auth.controller.model;

import com.sparta.baedallegend.user.domain.User;
import com.sparta.baedallegend.user.domain.wrap.Password;

public record SignUpRequest(
	String email,
	String password,
	String name,
	String nickname,
	SignUpType signUpType
) {

	public User toEntity(Password encodedPassword) {
		return User.of(email, encodedPassword, name, nickname, signUpType);
	}

}
