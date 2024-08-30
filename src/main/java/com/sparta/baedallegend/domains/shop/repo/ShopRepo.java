package com.sparta.baedallegend.domains.shop.repo;

import com.sparta.baedallegend.domains.shop.domain.ShopStatus;
import com.sparta.baedallegend.domains.shop.domain.Shop;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepo extends JpaRepository<Shop, UUID> {

	ShopStatus openStatus = ShopStatus.OPEN;

	@Query("SELECT s FROM Shop s WHERE s.isPublic = true "
		+ "ORDER BY CASE "
		+ "WHEN s.status = 'OPEN' THEN 1 "
		+ "WHEN s.status = 'BREAK_TIME' THEN 2 "
		+ "WHEN s.status = 'CLOSED' THEN 3 "
		+ "END")
	Page<Shop> findByIsPublicTrue(PageRequest pageRequest);

	@Query("SELECT s FROM Shop s WHERE s.name LIKE %:keyword%")
	Page<Shop> findByNameLike(PageRequest pageRequest, @Param("keyword") String keyword);

}
