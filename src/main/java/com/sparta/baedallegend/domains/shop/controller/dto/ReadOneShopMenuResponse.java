package com.sparta.baedallegend.domains.shop.controller.dto;

import com.sparta.baedallegend.domains.menu.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReadOneShopMenuResponse {

	private String menuId;
	private String menuName;
	private int menuPrice;
	private String menuDescription;
	private String menuStatus;

	public static ReadOneShopMenuResponse from(Menu menu) {
		return new ReadOneShopMenuResponse(menu.getId().toString(), menu.getName(), menu.getPrice(),
			menu.getDescription(), menu.getMenuStatus().getDescription());
	}

}
