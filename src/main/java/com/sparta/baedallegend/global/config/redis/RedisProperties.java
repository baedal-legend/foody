package com.sparta.baedallegend.global.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.data.redis")
public record RedisProperties(
	@Value("${spring.data.redis.host}") String host,
	@Value("${spring.data.redis.port}") int port,
	@Value("${spring.data.redis.username}") String username,
	@Value("${spring.data.redis.password}") String password,
	@Value("${spring.data.redis.database}") int database
) {

}
