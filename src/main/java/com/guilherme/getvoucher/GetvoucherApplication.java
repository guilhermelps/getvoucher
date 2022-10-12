package com.guilherme.getvoucher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class GetvoucherApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetvoucherApplication.class, args);
	}

}
