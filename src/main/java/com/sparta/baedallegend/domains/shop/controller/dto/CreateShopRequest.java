package com.sparta.baedallegend.domains.shop.controller.dto;

import com.sparta.baedallegend.domains.region.domain.Region;
import com.sparta.baedallegend.domains.shop.domain.Shop;
import com.sparta.baedallegend.domains.user.domain.User;
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

	public Shop toEntity(User user, Region region) {
		return Shop.of(name, phoneNumber, description, address, user, region);
	}

}
