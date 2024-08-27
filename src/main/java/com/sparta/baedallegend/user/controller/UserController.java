package com.sparta.baedallegend.user.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import com.sparta.baedallegend.global.config.annotations.LoginUser;
import com.sparta.baedallegend.user.controller.model.UserResponse;
import com.sparta.baedallegend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
	path = "/user",
	consumes = APPLICATION_JSON_VALUE,
	produces = APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class UserController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final UserService userService;

	@GetMapping("/me")
	ResponseEntity<UserResponse> me(@LoginUser Long id) {
		log.info("[{}]", id);
		return ResponseEntity.ok(userService.loadUserById(id));
	}

}
