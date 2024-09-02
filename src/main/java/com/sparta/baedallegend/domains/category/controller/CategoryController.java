package com.sparta.baedallegend.domains.category.controller;

import com.sparta.baedallegend.domains.category.controller.dto.CreateCategoryRequest;
import com.sparta.baedallegend.domains.category.service.CategoryService;
import com.sparta.baedallegend.global.utils.ResponseEntityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;

	@PostMapping("/category")
	public ResponseEntity<Void> create(@RequestBody CreateCategoryRequest createCategoryRequest) {
		final String categoryId = categoryService.create(createCategoryRequest);
		return ResponseEntityUtils.created("/category/{categoryId}", categoryId);
	}

}
