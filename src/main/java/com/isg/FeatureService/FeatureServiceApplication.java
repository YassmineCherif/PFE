package com.isg.FeatureService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FeatureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeatureServiceApplication.class, args);
	}

}
