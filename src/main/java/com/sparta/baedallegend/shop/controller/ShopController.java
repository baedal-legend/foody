package com.sparta.baedallegend.shop.controller;

import com.sparta.baedallegend.shop.controller.dto.CreateShopRequest;
import com.sparta.baedallegend.shop.service.ShopService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

	private final ShopService shopService;

	@PostMapping
	public ResponseEntity<Void> create(Long userId,
		@RequestBody CreateShopRequest createShopRequest) {

		final String shopId = shopService.create(userId, createShopRequest);

		URI uri = UriComponentsBuilder
			.fromUriString("/shop/{shopId}")
			.buildAndExpand(shopId)
			.toUri();

		return ResponseEntity.created(uri).build();
	}

}
