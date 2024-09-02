package com.sparta.baedallegend.domains.menu.service;

import com.sparta.baedallegend.domains.menu.controller.dto.CreateMenuRequest;
import com.sparta.baedallegend.domains.menu.controller.dto.FindMenuResponse;
import com.sparta.baedallegend.domains.menu.domain.Menu;
import com.sparta.baedallegend.domains.menu.exception.MenuErrorCode;
import com.sparta.baedallegend.domains.menu.exception.MenuException;
import com.sparta.baedallegend.domains.menu.repo.MenuRepo;
import com.sparta.baedallegend.domains.shop.domain.Shop;
import com.sparta.baedallegend.domains.shop.exception.ShopErrorCode;
import com.sparta.baedallegend.domains.shop.exception.ShopException;
import com.sparta.baedallegend.domains.shop.repo.ShopRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuService {

	private final MenuRepo menuRepo;
	private final ShopRepository shopRepository;

	@Transactional
	public String create(CreateMenuRequest createMenuRequest) {
		String shopId = createMenuRequest.getShopId();
		Shop shop = shopRepository.findById(UUID.fromString(shopId)).orElseThrow(() ->
			new ShopException(ShopErrorCode.NOT_EXIST, shopId));
		Menu menu = createMenuRequest.toEntity(shop);
		Menu saveMenu = menuRepo.save(menu);
		shop.addMenu(saveMenu);
		return saveMenu.getId().toString();
	}

	public Page<FindMenuResponse> findAllMenu(
		String shopId,
		Pageable pageable
	) {
		Page<Menu> menuList = menuRepo.findByShopId(
			pageable,
			UUID.fromString(shopId)
		);
		if (menuList.getContent().isEmpty()) {
			throw new ShopException(ShopErrorCode.NOT_EXIST, shopId);
		}
		return menuList.map(FindMenuResponse::from);
	}

	public FindMenuResponse findOneMenu(String menuId) {
		Menu menu = menuRepo.findById(UUID.fromString(menuId)).orElseThrow(
			() -> new MenuException(MenuErrorCode.NOT_EXIST, menuId)
		);
		return FindMenuResponse.from(menu);
	}

}
