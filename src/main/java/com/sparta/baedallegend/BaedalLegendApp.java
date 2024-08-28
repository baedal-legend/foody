package com.sparta.baedallegend;

import com.sparta.baedallegend.auth.utils.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class BaedalLegendApp {

	public static void main(String[] args) {
		SpringApplication.run(BaedalLegendApp.class, args);
	}

}
