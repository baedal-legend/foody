package com.sparta.baedallegend.domains.auth.controller.model;

public record SignInRequest(
	String email,
	String password
) {

}
