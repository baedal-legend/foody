package com.sparta.baedallegend.shop.exception;

import com.sparta.baedallegend.global.config.exception.BusinessException;

public class ShopException extends BusinessException {

	private final ShopErrorCode code;

	public ShopException(ShopErrorCode code, Object... args) {
		super(code.getStatus(), code.toString(), code.getMessage(), args);
		this.code = code;
	}

}
