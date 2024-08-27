package com.sparta.baedallegend.auth.controller.model;

public record SignInRequest(
	String email,
	String password
) {

}
