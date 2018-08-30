package com.chindx.youth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

import com.chindx.youth.config.RedisConfig;

@EnableCaching
@SpringBootApplication
@Import(value = { RedisConfig.class })
public class YouthspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(YouthspringApplication.class, args);
	}	
}
