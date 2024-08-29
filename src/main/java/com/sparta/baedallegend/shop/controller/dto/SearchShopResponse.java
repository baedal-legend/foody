package com.sparta.baedallegend.shop.controller.dto;

import com.sparta.baedallegend.shop.domain.Shop;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchShopResponse {

	private String id;
	private String name;
	private String description;
	private String status;
	private List<String> menuNames = new ArrayList<>();

	private SearchShopResponse(String id, String name, String description, String status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
	}

	public static SearchShopResponse from(Shop shop) {
		return new SearchShopResponse(shop.getId().toString(), shop.getName(),
			shop.getDescription(), shop.getStatus().getDescription());
	}

	public void addMenuName(String menuName) {
		menuNames.add(menuName);
	}


}
