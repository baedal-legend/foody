package com.sparta.baedallegend.domains.category.service;

import com.sparta.baedallegend.domains.category.controller.dto.CreateCategoryRequest;
import com.sparta.baedallegend.domains.category.domain.Category;
import com.sparta.baedallegend.domains.category.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryRepo categoryRepo;

	public String create(CreateCategoryRequest createCategoryRequest) {
		Category category = createCategoryRequest.toEntity();
		Category saveCategory = categoryRepo.save(category);
		return saveCategory.getId().toString();
	}

}
