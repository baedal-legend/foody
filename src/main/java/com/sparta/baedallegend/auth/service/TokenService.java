package com.sparta.baedallegend.auth.service;

import com.sparta.baedallegend.auth.domain.FoodyPrincipal;
import com.sparta.baedallegend.auth.utils.jwt.JwtProperties;
import com.sparta.baedallegend.auth.utils.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

	private final JwtProperties jwtProperties;

	public String issueAccessToken(FoodyPrincipal principal) {
		return JwtProvider.create(jwtProperties, principal);
	}

}
