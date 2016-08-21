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
@RequestMapping("/api/v1/sabayder")
public class SabayDerController {
	
	@Autowired
	private SabayApi sabayApi;
	
	private String requestUrl = "http://der.sabay.com/wp-content/themes/lifestyle_v1.0.8/ajax.php";
	
	@ApiOperation("Find article by category id { ID:[2,3,4], NAME:[food, hangout, fashion] }")
	@RequestMapping(value="/article", method = RequestMethod.GET)
	public ResponseEntity<List<News>> findByCategory(
			@RequestParam(value="cid", defaultValue="2", required=false) String categoryId,
			@RequestParam(value="page", defaultValue="1", required=false) String page){
		
		return sabayApi.loadData(requestUrl, categoryId, page);
	}
	
}
