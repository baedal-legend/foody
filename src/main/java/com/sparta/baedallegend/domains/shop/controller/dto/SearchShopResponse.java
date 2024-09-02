package com.sparta.baedallegend.domains.shop.controller.dto;

import com.sparta.baedallegend.domains.shop.domain.Shop;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

	public static SearchShopResponse of(Shop shop, String keyword) {
		return new SearchShopResponse(shop.getId().toString(), shop.getName(),
			shop.getDescription(), shop.getStatus().getDescription(),
			shop.getMenus().stream().map(menu -> menu.getName())
				.filter(name -> name.contains(keyword))
				.limit(3)
				.collect(Collectors.toList()));
	}

}
