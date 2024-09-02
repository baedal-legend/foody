package com.sparta.baedallegend;

import com.sparta.baedallegend.domains.auth.utils.jwt.JwtProperties;
import com.sparta.baedallegend.global.config.redis.RedisProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	JwtProperties.class,
	RedisProperties.class
})
public class BaedalLegendApp {

	public static void main(String[] args) {
		SpringApplication.run(BaedalLegendApp.class, args);
	}

}
