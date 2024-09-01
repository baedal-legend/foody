package com.sparta.baedallegend.domains.shop.repo;

import static com.sparta.baedallegend.domains.menu.domain.QMenu.menu;
import static com.sparta.baedallegend.domains.shop.domain.QShop.shop;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.baedallegend.domains.shop.domain.Shop;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

@RequiredArgsConstructor
public class ShopRepositoryImpl implements ShopRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public Page<Shop> search(PageRequest pageRequest, String keyword) {

		List<Shop> shops = queryFactory
			.select(shop).distinct()
			.from(menu)
			.rightJoin(menu.shop, shop)
			.where(shop.name.contains(keyword)
				.or(menu.name.contains(keyword)))
			.offset(pageRequest.getOffset())
			.limit(pageRequest.getPageSize())
			.fetch();

		return new PageImpl<>(shops, pageRequest, shops.size());
	}

}
