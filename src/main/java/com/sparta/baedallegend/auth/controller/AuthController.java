package com.sparta.baedallegend.auth.controller;

import static com.sparta.baedallegend.global.config.utils.ResponseEntityUtils.created;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import com.sparta.baedallegend.auth.controller.model.SignInRequest;
import com.sparta.baedallegend.auth.controller.model.SignUpRequest;
import com.sparta.baedallegend.auth.controller.model.SignUpTypeResponse;
import com.sparta.baedallegend.auth.service.AuthenticationService;
import com.sparta.baedallegend.auth.service.SignUpFacade;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
	path = "/auth",
	consumes = APPLICATION_JSON_VALUE,
	produces = APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class AuthController {

	private static final String GET_AN_USER_URI = "/user/{id}";
	private final SignUpFacade signUpFacade;
	private final AuthenticationService authenticationService;

	@PostMapping("/sign-up")
	ResponseEntity<Void> signUp(@RequestBody SignUpRequest signUpRequest) {
		return created(
			GET_AN_USER_URI,
			signUpFacade.signUp(signUpRequest)
		);
	}

	@GetMapping("/type")
	ResponseEntity<?> signUpType() {
		return ResponseEntity.ok(SignUpTypeResponse.create());
	}

	@PostMapping("/sign-in")
	ResponseEntity<Void> signIn(
		@RequestBody SignInRequest signInRequest,
		HttpServletResponse response
	) {
		response.setHeader(AUTHORIZATION, authenticationService.authenticate(signInRequest));
		return ResponseEntity.ok().build();
	}

}
