package com.sparta.baedallegend.domains.user.domain;

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

	public boolean isCustomer() {
		return this == CUSTOMER;
	}

	public boolean isOwner() {
		return this == OWNER;
	}

	public boolean isMaster() {
		return this == MASTER;
	}
}
