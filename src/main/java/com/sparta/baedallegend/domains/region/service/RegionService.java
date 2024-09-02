package com.sparta.baedallegend.domains.region.service;

import com.sparta.baedallegend.domains.region.controller.dto.CreateRegionRequest;
import com.sparta.baedallegend.domains.region.domain.Region;
import com.sparta.baedallegend.domains.region.repo.RegionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionService {

	private final RegionRepo regionRepo;

	public String create(CreateRegionRequest createRegionRequest) {
		Region region = createRegionRequest.toEntity();
		Region saveRegion = regionRepo.save(region);
		return saveRegion.getId().toString();
	}

}
