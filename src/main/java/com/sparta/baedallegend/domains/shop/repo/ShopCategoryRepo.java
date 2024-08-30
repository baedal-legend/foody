package com.sparta.baedallegend.domains.shop.repo;

import com.sparta.baedallegend.domains.shop.domain.ShopCategory;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopCategoryRepo extends JpaRepository<ShopCategory, UUID> {

}
