package com.constructora.maquinarias_pesada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
public class MaquinariasPesadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaquinariasPesadaApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
