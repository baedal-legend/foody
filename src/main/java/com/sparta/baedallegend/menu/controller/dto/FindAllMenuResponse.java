package com.sparta.baedallegend.menu.controller.dto;


import com.sparta.baedallegend.menu.domain.Menu;
import com.sparta.baedallegend.menu.domain.MenuStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindAllMenuResponse {

	private String id;
	private String name;
	private String description;
	private int price;
	private MenuStatus menuStatus;

	public static FindAllMenuResponse from(Menu menu) {
		return new FindAllMenuResponse(menu.getId().toString(),
			menu.getName(),
			menu.getDescription(),
			menu.getPrice(),
			menu.getMenuStatus());
	}

}
