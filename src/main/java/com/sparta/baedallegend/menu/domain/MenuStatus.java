package com.sparta.baedallegend.menu.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.stream.Stream;

public enum MenuStatus {
	ON_SALE("판매중"), SOLD_OUT("하루품절"), HIDDEN("숨김");
	private String description;

	MenuStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@JsonCreator
	public static MenuStatus parsing(String description) {
		return Stream.of(MenuStatus.values())
			.filter(menuStatus -> menuStatus.toString().equals(description.toUpperCase()))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("메뉴 상태 유형이 잘못되었습니다."));
	}
}
