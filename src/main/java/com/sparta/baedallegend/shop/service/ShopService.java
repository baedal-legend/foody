package com.sparta.baedallegend.shop.service;

import com.sparta.baedallegend.shop.repo.ShopRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepo shopRepo;
}
