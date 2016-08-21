package com.news.sabay.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

	@Bean
	public HttpHeaders header() {
		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);
		//headers.set("Authorization", "Basic YWRtaW46YWRtaW4=");
		return headers;
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		//restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		//restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}

}
