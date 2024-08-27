package com.sparta.baedallegend.auth.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum AuthErrorCode {
	DUPLICATED_EMAIL(BAD_REQUEST, "이미 존재하는 이메일 입니다. : [%s]"),
	DUPLICATED_NICKNAME(BAD_REQUEST, "이미 존재하는 닉네임 입니다. : [%s]"),
	;

	private final HttpStatus status;
	private final String message;

	AuthErrorCode(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}
}
