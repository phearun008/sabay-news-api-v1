package com.news.sabay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.news.sabay.entity.News;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/sabaynews")
public class SabayNewsController {

	@Autowired
	private SabayApi sabayApi;
	
	private String requestUrl = "http://news.sabay.com.kh/wp-content/themes/sabaynews_v9.0.5/ajax.php";
	
	@ApiOperation("Find article by category id { ID:[1, 3, 4, 6], NAME:[life, entertainment, technology, sport] }")
	@RequestMapping(value="/article", method = RequestMethod.GET)
	public ResponseEntity<List<News>> findByCategory(
			@RequestParam(value="cid", defaultValue="1", required=false) String categoryId, 
			@RequestParam(value="page", defaultValue="1", required=false) String page){
		
		return sabayApi.loadData(requestUrl, categoryId, page);
	}

	
	
/*	
 * public static void main(String[] args) {
	
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		String url = "http://news.sabay.com.kh/wp-content/themes/sabaynews_v9.0.5/ajax.php";
		
		MultiValueMap<String, String> data = new LinkedMultiValueMap<>();

		data.add("action", "do_action");
		data.add("do_action", "moreposts");
		data.add("term_id", "4");
		data.add("term_name", "cat");
		data.add("paged", "1");
		
		HttpEntity<Object> requestEntity = new HttpEntity<>(data, headers);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
		
		TypeToken<List<News>> token = new TypeToken<List<News>>(){};
		List<News> newsList = new Gson().fromJson(response.getBody(), token.getType());
		
		newsList.forEach(news->{
			System.out.println(news);
		});
	}	
	
	*/
}
