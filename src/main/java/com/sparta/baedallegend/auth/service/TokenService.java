package com.sparta.baedallegend.auth.service;

import com.sparta.baedallegend.auth.domain.FoodyPrincipal;

public interface TokenService {

	String issueAccessToken(FoodyPrincipal principal);

}
