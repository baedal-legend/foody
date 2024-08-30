package com.sparta.baedallegend.domains.auth.service;

import com.sparta.baedallegend.domains.auth.domain.FoodyPrincipal;
import com.sparta.baedallegend.domains.auth.utils.jwt.JwtProperties;
import com.sparta.baedallegend.domains.auth.utils.jwt.JwtProvider;
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
