package com.crio.LearningNavigator;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LearningNavigatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningNavigatorApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	@Scope("prototype")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
