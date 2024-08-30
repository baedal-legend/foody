package com.sparta.baedallegend.domains.shop.exception;

import com.sparta.baedallegend.global.exception.BusinessException;

public class ShopException extends BusinessException {

	private final ShopErrorCode code;

	public ShopException(ShopErrorCode code, Object... args) {
		super(code.getStatus(), code.toString(), code.getMessage(), args);
		this.code = code;
	}

}
