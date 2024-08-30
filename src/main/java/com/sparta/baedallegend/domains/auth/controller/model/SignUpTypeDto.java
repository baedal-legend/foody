package com.sparta.baedallegend.domains.auth.controller.model;

import com.sparta.baedallegend.domains.user.domain.Role;

public record SignUpTypeDto(
	String field,
	String description
) {

	public static SignUpTypeDto of(Role role) {
		return new SignUpTypeDto(
			role.name(),
			role.getDescription()
		);
	}

}
