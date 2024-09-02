package com.sparta.baedallegend.domains.category.controller.dto;

import com.sparta.baedallegend.domains.category.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateCategoryRequest {

	private String name;
	private int priority;

	public Category toEntity() {
		return Category.of(name, priority);
	}


}
