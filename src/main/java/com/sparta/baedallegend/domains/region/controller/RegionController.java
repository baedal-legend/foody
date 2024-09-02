package com.sparta.baedallegend.domains.region.controller;

import com.sparta.baedallegend.domains.region.controller.dto.CreateRegionRequest;
import com.sparta.baedallegend.domains.region.service.RegionService;
import com.sparta.baedallegend.global.utils.ResponseEntityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegionController {

	private final RegionService regionService;

	@PostMapping("/region")
	public ResponseEntity<Void> create(@RequestBody CreateRegionRequest createRegionRequest) {

		final String regionId = regionService.create(createRegionRequest);
		return ResponseEntityUtils.created("/region/{regionId}", regionId);
	}

}
