package com.sparta.baedallegend.global.config.jpa.generator;

import static org.hibernate.type.descriptor.java.IntegerJavaType.ZERO;

import java.util.UUID;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ShortenUUIDGenerator implements IdentifierGenerator {

	public static final String SHORTEN_UUID_GENERATOR = "shortenUUID";
	public static final int SHORTEN_UUID_LENGTH = 8;

	@Override
	public Object generate(
		SharedSessionContractImplementor sharedSessionContractImplementor,
		Object o
	) {
		return generateShortenUUID();
	}

	private String generateShortenUUID() {
		return UUID.randomUUID()
			.toString()
			.substring(ZERO, SHORTEN_UUID_LENGTH);
	}

}
