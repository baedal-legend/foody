package com.sparta.baedallegend.shop.repo;

import com.sparta.baedallegend.shop.domain.ShopCategory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopCategoryRepo extends JpaRepository<ShopCategory, UUID> {

}
