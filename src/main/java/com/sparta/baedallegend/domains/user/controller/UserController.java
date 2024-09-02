package com.sparta.baedallegend.domains.user.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import com.sparta.baedallegend.domains.user.controller.model.UserResponse;
import com.sparta.baedallegend.domains.user.service.UserService;
import com.sparta.baedallegend.global.config.security.annotations.LoginUser;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/{id}")
	ResponseEntity<UserResponse> findUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.findUserById(id));
	}


	@DeleteMapping("/withdraw")
	ResponseEntity<Void> withdraw(@LoginUser Long id) {
		log.info("[{}]", id);
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}

}
