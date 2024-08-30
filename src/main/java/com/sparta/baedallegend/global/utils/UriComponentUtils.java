package com.sparta.baedallegend.global.utils;

import java.net.URI;
import org.springframework.web.util.UriComponentsBuilder;

public class UriComponentUtils {

	public static <T> URI makeUrl(String baseUri, T path) {
		return UriComponentsBuilder
			.fromUriString(baseUri)
			.buildAndExpand(path)
			.toUri();
	}

}
