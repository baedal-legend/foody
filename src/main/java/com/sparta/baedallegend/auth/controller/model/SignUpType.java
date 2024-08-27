package com.sparta.baedallegend.auth.controller.model;

import lombok.Getter;

@Getter
public enum SignUpType {
	CUSTOMER("고객"),
	OWNER("가게 주인"),
	MANAGER("관리자"),
	;

	private final String description;

	SignUpType(String description) {
		this.description = description;
	}

	public boolean isCustomer() {
		return this == CUSTOMER;
	}
}
