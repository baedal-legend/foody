package com.sparta.baedallegend.domains.user.exception;

public class UserException extends RuntimeException {

	private final UserErrorCode code;

	public UserException(UserErrorCode code, Object... args) {
		super(formattedMessage(code.getMessage(), args));
		this.code = code;
	}

	private static String formattedMessage(String message, Object... args) {
		return message.formatted(args);
	}

}
