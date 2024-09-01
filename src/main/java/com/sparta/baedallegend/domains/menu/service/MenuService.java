package com.sparta.baedallegend.domains.menu.service;

import com.sparta.baedallegend.domains.menu.controller.dto.CreateMenuRequest;
import com.sparta.baedallegend.domains.menu.controller.dto.FindAllMenuResponse;
import com.sparta.baedallegend.domains.menu.domain.Menu;
import com.sparta.baedallegend.domains.menu.repo.MenuRepo;
import com.sparta.baedallegend.domains.shop.domain.Shop;
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
			new IllegalArgumentException("존재하지 않는 가게입니다."));
		// 확인 후 새로운 메뉴 추가
		Menu menu = createMenuRequest.toEntity(shop);
		// 새로운 메뉴를 저장
		Menu saveMenu = menuRepo.save(menu);
		shop.addMenu(saveMenu);
		return saveMenu.getId().toString();
	}

	public Page<FindAllMenuResponse> findAllMenu(
		String shop_id,
		Pageable pageable
	) {
		Page<Menu> menuList = menuRepo.findByIsPublicTrueAndShopId
			(
				pageable,
				UUID.fromString(shop_id));
		return menuList.map(FindAllMenuResponse::from);
	}

}
