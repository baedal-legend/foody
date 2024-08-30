package com.sparta.baedallegend.domains.auth.controller.model;

import com.sparta.baedallegend.domains.user.domain.Role;
import java.util.Arrays;
import java.util.List;

public record SignUpTypeResponse(
	List<SignUpTypeDto> elements
) {

	public static SignUpTypeResponse create() {
		List<SignUpTypeDto> signUpTypes = Arrays.stream(Role.values())
			.map(SignUpTypeDto::of)
			.toList();

		return new SignUpTypeResponse(signUpTypes);
	}

}
