package com.sparta.baedallegend.auth.domain;

import com.sparta.baedallegend.user.domain.Role;

public record FoodyPrincipal(
	Long id,
	Role role
) {

	public static FoodyPrincipal of(Long id, Role role) {
		return new FoodyPrincipal(id, role);
	}

}
