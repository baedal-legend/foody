package com.sparta.baedallegend.menu.repo;

import com.sparta.baedallegend.menu.domain.Menu;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<Menu, UUID> {

	Page<Menu> findByIsPublicTrueAndShopId(Pageable pageable, UUID shopId);

}
