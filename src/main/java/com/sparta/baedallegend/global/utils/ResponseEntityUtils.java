package com.sparta.baedallegend.global.utils;

import org.springframework.http.ResponseEntity;

public class ResponseEntityUtils {

	public static ResponseEntity<Void> created(String uriFormat, Object path) {
		return ResponseEntity.created(UriComponentUtils.makeUrl(uriFormat, path)).build();
	}

}
