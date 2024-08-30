package com.sparta.baedallegend.domains.auth.utils.jwt;

public class RequestHeaderUtils {

	public static final String BEARER_PREFIX = "Bearer ";

	public static String extractJwt(String authorizationHeader) {
		return authorizationHeader.substring(BEARER_PREFIX.length());
	}

}
