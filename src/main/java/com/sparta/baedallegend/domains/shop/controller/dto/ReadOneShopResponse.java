package com.sparta.baedallegend.domains.shop.controller.dto;

import com.sparta.baedallegend.domains.shop.domain.Shop;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReadOneShopResponse {

	private String name;
	private String phoneNumber;
	private String description;
	private String address;
	private List<ReadOneShopMenuResponse> menus = new ArrayList<>();

	public static ReadOneShopResponse of(Shop shop, List<ReadOneShopMenuResponse> menuResponses) {
		return new ReadOneShopResponse(shop.getName(),
			shop.getPhoneNumber(), shop.getDescription(), shop.getAddress(), menuResponses);

	}

}
