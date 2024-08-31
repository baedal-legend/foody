package com.sparta.baedallegend.domains.menu.controller;

import com.sparta.baedallegend.domains.menu.controller.dto.CreateMenuRequest;
import com.sparta.baedallegend.domains.menu.controller.dto.FindMenuResponse;
import com.sparta.baedallegend.domains.menu.service.MenuService;
import com.sparta.baedallegend.global.utils.ResponseEntityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
@Slf4j
public class MenuController {

	private final MenuService menuService;

	@PostMapping
	public ResponseEntity<Void> createMenu(
		@RequestBody CreateMenuRequest createMenuRequest
	) {
		final String menuId = menuService.create(createMenuRequest);
		return ResponseEntityUtils.created("/menu/{menu_id}", menuId);
	}

	@GetMapping("/{shopId}")
	public Page<FindMenuResponse> findAllMenu(
		@PathVariable String shopId,
		@RequestParam(value = "page", defaultValue = "0") int page,
		@RequestParam(value = "size", defaultValue = "1") int size
	) {
		Pageable pageable = PageRequest.of(page, size);
		Page<FindMenuResponse> menuList = menuService.findAllMenu(shopId, pageable);
		return menuList;
	}

	@GetMapping("/menu/{menuId}")
	public FindMenuResponse FindOneMenu(
		@PathVariable String menuId) {
		return menuService.findOneMenu(menuId);
	}

}
