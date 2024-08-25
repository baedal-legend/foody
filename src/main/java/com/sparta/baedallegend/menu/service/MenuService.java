package com.sparta.baedallegend.menu.service;

import com.sparta.baedallegend.menu.repo.MenuRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepo menuRepo;
}
