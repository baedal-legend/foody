package com.sparta.baedallegend.domains.menu.exception;

import com.sparta.baedallegend.global.exception.BusinessException;


public class MenuException extends BusinessException {

	private final MenuErrorCode code;

	public MenuException(MenuErrorCode code, Object... args) {
		super(code.getStatus(), code.toString(), code.getMessage(), args);
		this.code = code;
	}

}
