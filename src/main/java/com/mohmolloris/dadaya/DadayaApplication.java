package com.mohmolloris.dadaya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DadayaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DadayaApplication.class, args);
	}

}
