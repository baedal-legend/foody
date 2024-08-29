package com.sparta.baedallegend.menu.controller;

import com.sparta.baedallegend.global.config.utils.ResponseEntityUtils;
import com.sparta.baedallegend.menu.controller.dto.CreateMenuRequest;
import com.sparta.baedallegend.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MenuController {

	private final MenuService menuService;

	@PostMapping("/menu")
	public ResponseEntity<Void> createMenu(
		@RequestBody CreateMenuRequest createMenuRequest
	) {
		final String menuId = menuService.create(createMenuRequest);
		return ResponseEntityUtils.created("/menu/{menu_id}", menuId);
	}

}
