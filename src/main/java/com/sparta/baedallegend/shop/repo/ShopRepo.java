package com.sparta.baedallegend.shop.repo;

import com.sparta.baedallegend.shop.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShopRepo extends JpaRepository<Shop, UUID> {
}
