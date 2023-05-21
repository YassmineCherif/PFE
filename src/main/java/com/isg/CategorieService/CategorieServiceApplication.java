package com.isg.CategorieService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CategorieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategorieServiceApplication.class, args);
	}

}
