package com.sparta.baedallegend.menu.controller.dto;

import com.sparta.baedallegend.menu.domain.Menu;
import com.sparta.baedallegend.menu.domain.MenuStatus;
import com.sparta.baedallegend.shop.domain.Shop;
import lombok.Getter;

@Getter
public class CreateMenuRequest {

	private String name;
	private int price;
	private String description;
	private MenuStatus menuStatus;

	public Menu toEntity(Shop shop) {
		return Menu.of(name, price, description, menuStatus, shop);
	}

}
