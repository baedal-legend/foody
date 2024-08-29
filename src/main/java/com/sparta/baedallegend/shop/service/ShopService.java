package com.sparta.baedallegend.shop.service;

import com.sparta.baedallegend.category.domain.Category;
import com.sparta.baedallegend.category.repo.CategoryRepo;
import com.sparta.baedallegend.region.domain.Region;
import com.sparta.baedallegend.region.repo.RegionRepo;
import com.sparta.baedallegend.shop.controller.dto.CreateShopRequest;
import com.sparta.baedallegend.shop.controller.dto.FindAllShopResponse;
import com.sparta.baedallegend.shop.domain.Shop;
import com.sparta.baedallegend.shop.domain.ShopCategory;
import com.sparta.baedallegend.shop.repo.ShopCategoryRepo;
import com.sparta.baedallegend.shop.repo.ShopRepo;
import com.sparta.baedallegend.user.domain.User;
import com.sparta.baedallegend.user.repo.UserRepo;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShopService {

	private final ShopRepo shopRepo;
	private final UserRepo userRepo;
	private final CategoryRepo categoryRepo;
	private final ShopCategoryRepo shopCategoryRepo;
	private final RegionRepo regionRepo;

	@Transactional
	public String create(Long userId, CreateShopRequest createShopRequest) {
		User user = userRepo.findById(userId).orElseThrow(() ->
			new IllegalArgumentException("존재하지 않는 사용자입니다."));

		Region region = regionRepo.findById(UUID.fromString(createShopRequest.getRegionId()))
			.orElseThrow(() ->
				new IllegalArgumentException("존재하지 않는 지역입니다."));

		Shop shop = createShopRequest.toEntity(user, region);
		Shop createdShop = shopRepo.save(shop);

		// 카테고리 설정
		List<String> categoryIds = createShopRequest.getCategoryIds();
		for (String categoryId : categoryIds) {
			Category category = categoryRepo.findById(UUID.fromString(categoryId)).orElseThrow(() ->
				new IllegalArgumentException("존재하지 않는 카테고리입니다."));

			ShopCategory shopCategory = ShopCategory.of(shop, category);
			shopCategoryRepo.save(shopCategory);
		}

		return createdShop.getId().toString();
	} // TODO CustomException 활용하여 수정 필요

	public Page<FindAllShopResponse> findAll(PageRequest pageRequest) {
		Page<Shop> shops = shopRepo.findByIsPublicTrue(pageRequest);

		List<FindAllShopResponse> findAllShopResponses = shops.stream()
			.map(FindAllShopResponse::from)
			.collect(Collectors.toList());

		return new PageImpl<>(findAllShopResponses, pageRequest, shops.getSize());
	} // TODO 페이징 처리 필요

}
