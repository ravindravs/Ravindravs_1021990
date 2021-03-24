package com.javatech.com.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class CardConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}