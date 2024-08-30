package com.sparta.baedallegend.domains.shop.controller.dto;

import com.sparta.baedallegend.domains.shop.domain.Shop;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class FindAllShopResponse {

	private String id;
	private String name;
	private String description;
	private String status;

	public static FindAllShopResponse from(Shop shop) {
		return new FindAllShopResponse(shop.getId().toString(), shop.getName(),
			shop.getDescription(), shop.getStatus().getDescription());
	}

	// TODO 평점 추가 필요
}
