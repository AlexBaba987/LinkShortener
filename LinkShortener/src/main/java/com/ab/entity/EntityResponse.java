package com.ab.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class EntityResponse {

	private String originalUrl;
	private String shortLink;
}
