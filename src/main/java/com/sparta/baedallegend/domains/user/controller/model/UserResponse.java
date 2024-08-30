package com.sparta.baedallegend.domains.user.controller.model;

import com.sparta.baedallegend.domains.user.domain.User;

public record UserResponse(
	Long id,
	String email,
	String nickname,
	String roleDetails
	// TODO Auditor 적용 후 가입일 응답 항목 추가
) {

	public static UserResponse from(User user) {
		return new UserResponse(
			user.getId(),
			user.getEmail(),
			user.getNickname(),
			user.getRoleDetails()
		);
	}

}
