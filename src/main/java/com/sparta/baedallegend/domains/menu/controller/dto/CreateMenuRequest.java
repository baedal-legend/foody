package com.sparta.baedallegend.domains.menu.controller.dto;

import com.sparta.baedallegend.domains.menu.domain.Menu;
import com.sparta.baedallegend.domains.menu.domain.MenuStatus;
import com.sparta.baedallegend.domains.shop.domain.Shop;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateMenuRequest {

	private String shopId;
	private String name;
	private int price;
	private String description;
	private MenuStatus menuStatus;

	public Menu toEntity(Shop shop) {
		return Menu.of(name, price, description, menuStatus, shop);
	}

}
