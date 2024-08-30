package com.sparta.baedallegend.domains.menu.repo;

import com.sparta.baedallegend.domains.menu.domain.Menu;
import com.sparta.baedallegend.domains.shop.domain.Shop;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<Menu, UUID> {

	List<Menu> findByShopAndIsPublicTrue(Shop shop);

	@Query("SELECT m FROM Menu m WHERE m.name LIKE %:keyword%")
	List<Menu> findByNameLike(String keyword);

}
