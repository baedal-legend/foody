package com.sparta.baedallegend.domains.category.service;

import com.sparta.baedallegend.domains.category.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;
}
