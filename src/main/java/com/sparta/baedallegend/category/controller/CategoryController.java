package com.sparta.baedallegend.category.controller;

import com.sparta.baedallegend.category.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepo categoryRepo;
}
