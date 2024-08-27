package com.sparta.baedallegend.shop.controller.dto;

import com.sparta.baedallegend.shop.domain.Shop;
import com.sparta.baedallegend.user.domain.User;
import java.util.List;
import lombok.Getter;

@Getter
public class CreateShopRequest {

	private String name;
	private String phoneNumber;
	private String description;
	private String address;
	private List<String> categoryIds;
	private String regionId;

	public Shop toEntity(User user) {
		return Shop.of(name, phoneNumber, description, address, user);
	}

}
