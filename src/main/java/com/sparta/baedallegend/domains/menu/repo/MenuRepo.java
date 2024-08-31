package com.sparta.baedallegend.domains.menu.repo;

import com.sparta.baedallegend.domains.menu.domain.Menu;
import com.sparta.baedallegend.domains.shop.domain.Shop;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<Menu, UUID> {

	Page<Menu> findByIsPublicTrueAndShopId(Pageable pageable, UUID shopId);

	List<Menu> findByShopAndIsPublicTrue(Shop shop);

	Optional<Menu> findByIdAndIsPublicTrue(UUID menuId);

	@Query("SELECT m FROM Menu m WHERE m.name LIKE %:keyword%")
	List<Menu> findByNameLike(String keyword);


}
