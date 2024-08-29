package com.sparta.baedallegend.menu.domain;

public enum MenuStatus {
	ON_SALE("판매중"), SOLD_OUT("하루품절"), HIDDEN("숨김");
	private String description;

	MenuStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
