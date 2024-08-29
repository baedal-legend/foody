package com.sparta.baedallegend.shop.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ShopErrorCode {
	NOT_EXIST(NOT_FOUND, "요청에 해당하는 가게가 존재하지 않습니다. : [%s]");

	private final HttpStatus status;
	private final String message;

	ShopErrorCode(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}
}
