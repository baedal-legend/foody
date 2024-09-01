package com.sparta.baedallegend.domains.shop.repo;

import com.sparta.baedallegend.domains.shop.domain.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ShopRepositoryCustom {

	Page<Shop> search(PageRequest pageRequest, String keyword);

}
