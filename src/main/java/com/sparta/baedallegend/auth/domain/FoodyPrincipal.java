package com.sparta.baedallegend.auth.domain;

public record FoodyPrincipal(
	Long id,
	String email,
	String roleDetails
) {

	public static FoodyPrincipal of(Long id, String email, String roleDetails) {
		return new FoodyPrincipal(id, email, roleDetails);
	}

}
