package com.sparta.baedallegend.menu.repo;

import com.sparta.baedallegend.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuRepo extends JpaRepository<Menu, UUID> {
}
