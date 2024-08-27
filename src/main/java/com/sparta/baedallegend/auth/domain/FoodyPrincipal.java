package com.sparta.baedallegend.auth.domain;

import com.sparta.baedallegend.user.domain.Role;

public class FoodyPrincipal {

	private Long id;
	private Role role;

	private FoodyPrincipal(Long id, Role role) {
		this.id = id;
		this.role = role;
	}

	public static FoodyPrincipal of(Long id, Role role) {
		return new FoodyPrincipal(id, role);
	}

}
