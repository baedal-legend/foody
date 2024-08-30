package com.sparta.baedallegend.domains.auth.controller.model;

import com.sparta.baedallegend.domains.user.domain.Role;
import com.sparta.baedallegend.domains.user.domain.User;
import com.sparta.baedallegend.domains.user.domain.wrap.Password;

public record SignUpRequest(
	String email,
	String password,
	String name,
	String nickname,
	Role signUpType
) {

	public User toEntity(Password encodedPassword) {
		return User.of(email, encodedPassword, name, nickname, signUpType);
	}

}
