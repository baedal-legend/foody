package com.sparta.baedallegend.shop.controller.dto;

import com.sparta.baedallegend.menu.domain.Menu;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
