package com.sparta.baedallegend.auth.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sparta.baedallegend.auth.controller.model.SignInRequest;
import com.sparta.baedallegend.auth.controller.model.SignUpRequest;
import com.sparta.baedallegend.auth.service.AuthenticationService;
import com.sparta.baedallegend.auth.service.SignUpFacade;
import com.sparta.baedallegend.base.WebMvcTestBase;
import com.sparta.baedallegend.user.domain.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.MimeTypeUtils;

@DisplayName("API:Auth")
class AuthControllerTest extends WebMvcTestBase {

	@MockBean
	private SignUpFacade signUpFacade;

	@MockBean
	private AuthenticationService authenticationService;

	@Test
	@DisplayName("[회원 가입][POST:201]")
	void signUp() throws Exception {
		// Given
		final String uri = "/auth/sign-up";
		SignUpRequest signUpRequest = new SignUpRequest(
			"customer@foody.io",
			"password",
			"홍길동",
			"Red홍",
			Role.CUSTOMER
		);
		given(signUpFacade.signUp(signUpRequest)).willReturn(1L);

		// When
		ResultActions resultActions = mockMvc.perform(post(uri)
			.contentType(MimeTypeUtils.APPLICATION_JSON_VALUE)
			.accept(MimeTypeUtils.APPLICATION_JSON_VALUE)
			.content(objectMapper.writeValueAsBytes(signUpRequest))
		);

		// Then
		resultActions.andDo(print())
			.andExpect(status().isCreated());
	}

	@Test
	@DisplayName("[회원 타입][GET:200]")
	void signUpType() throws Exception {
		// Given
		final String uri = "/auth/type";

		// When
		ResultActions resultActions = mockMvc.perform(get(uri)
			.contentType(MimeTypeUtils.APPLICATION_JSON_VALUE)
			.accept(MimeTypeUtils.APPLICATION_JSON_VALUE)
		);

		// Then
		resultActions.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	@DisplayName("[로그인][POST:200]")
	void signIn() throws Exception {
		// Given
		final String uri = "/auth/sign-in";
		SignInRequest signInRequest = new SignInRequest(
			"customer@foody.io",
			"password"
		);

		given(authenticationService.authenticate(signInRequest)).willReturn(anyString());

		// When
		ResultActions resultActions = mockMvc.perform(post(uri)
			.contentType(MimeTypeUtils.APPLICATION_JSON_VALUE)
			.accept(MimeTypeUtils.APPLICATION_JSON_VALUE)
			.content(objectMapper.writeValueAsBytes(signInRequest))
		);

		// Then
		resultActions.andDo(print())
			.andExpect(status().isOk());
	}

}
