package com.news.sabay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.news.sabay.entity.News;

@Component
public class SabayApi {
	
	@Autowired
	private HttpHeaders headers;
	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<List<News>> loadData(String requestUrl, String categoryId, String page){
		
		MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
		
		data.add("action", "do_action");
		data.add("do_action", "moreposts");
		data.add("term_id", categoryId);
		data.add("term_name", "cat");
		data.add("paged", page);
		HttpEntity<Object> requestEntity = new HttpEntity<>(data, headers);

		ResponseEntity<String> newsResponse = restTemplate.exchange(requestUrl, HttpMethod.POST, requestEntity, String.class);
		
		TypeToken<List<News>> token = new TypeToken<List<News>>(){};
		List<News> news = new Gson().fromJson(newsResponse.getBody(), token.getType());

		return new ResponseEntity<List<News>>(news, HttpStatus.OK);
	}
}
