package com.example.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Value("${rickandmortyapi.baseurl}")
    private String baseUrl;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
