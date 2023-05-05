package com.ab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ab.binding.UrlBinding;
import com.ab.entity.EntityResponse;
import com.ab.entity.Url;
import com.ab.service.IUrlService;

@RestController
public class LinkShortenerController {

	@Autowired
	private IUrlService urlService;
	
	@Autowired
	private EntityResponse response;
	
	@PostMapping("/generate")
	public ResponseEntity<EntityResponse> generateShortLink(@RequestBody UrlBinding url){
		Url urlResult=urlService.generateShortLink(url);
		
		if(urlResult!=null) {
			response.setOriginalUrl(url.getUrl());
			response.setShortLink(urlResult.getShortLink());
		}
		else {
			response.setOriginalUrl("404");
			response.setShortLink("error... please try again");
		}
		
		return new ResponseEntity<EntityResponse>(response,HttpStatus.OK);
	}
	
	@PostMapping("/{url}")
	public ResponseEntity<EntityResponse> openLink(@PathVariable("url") UrlBinding url){
		return null;
	}
}
