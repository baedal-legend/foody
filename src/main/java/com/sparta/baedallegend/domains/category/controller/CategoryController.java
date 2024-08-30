package com.sparta.baedallegend.domains.category.controller;

import com.sparta.baedallegend.domains.category.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepo categoryRepo;
}
