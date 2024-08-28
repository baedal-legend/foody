package com.sparta.baedallegend.menu.service;

import com.sparta.baedallegend.menu.controller.dto.CreateMenuRequest;
import com.sparta.baedallegend.menu.domain.Menu;
import com.sparta.baedallegend.menu.repo.MenuRepo;
import com.sparta.baedallegend.shop.domain.Shop;
import com.sparta.baedallegend.shop.repo.ShopRepo;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuService {

	private final MenuRepo menuRepo;
	private final ShopRepo shopRepo;

	@Transactional
	public String create(CreateMenuRequest createMenuRequest) {
		UUID shopId = createMenuRequest.getShop_id();
		Shop shop = shopRepo.findById(shopId).orElseThrow(() ->
			new IllegalArgumentException("존재하지 않는 가게입니다."));
		// 확인 후 새로운 메뉴 추가
		Menu menu = createMenuRequest.toEntity(shop);
		// 새로운 메뉴를 저장
		Menu saveMenu = menuRepo.save(menu);
		return saveMenu.getId().toString();
	}

}
