package com.sparta.baedallegend.domains.region.controller.dto;

import com.sparta.baedallegend.domains.region.domain.Region;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateRegionRequest {

	private String name;


	public Region toEntity() {
		return Region.of(name);
	}

}
