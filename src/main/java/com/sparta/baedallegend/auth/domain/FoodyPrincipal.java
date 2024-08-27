package com.sparta.baedallegend.auth.domain;

import com.sparta.baedallegend.user.domain.Role;

public record FoodyPrincipal(
	Long id,
	String email,
	Role role
) {

	public static FoodyPrincipal of(Long id, String email, Role role) {
		return new FoodyPrincipal(id, email, role);
	}

}
