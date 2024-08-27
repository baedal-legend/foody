package com.sparta.baedallegend.user.domain;

import lombok.Getter;

@Getter
public enum Role {
	CUSTOMER("고객"),
	OWNER("가게 주인"),
	MASTER("관리자"),
	;

	private final String description;

	Role(String description) {
		this.description = description;
	}
}
