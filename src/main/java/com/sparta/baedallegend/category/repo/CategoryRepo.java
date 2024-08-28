package com.sparta.baedallegend.category.repo;

import com.sparta.baedallegend.category.domain.Category;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, UUID> {

	Optional<Category> findById(UUID categoryId);

}
