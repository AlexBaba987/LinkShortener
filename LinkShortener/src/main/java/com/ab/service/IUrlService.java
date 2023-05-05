package com.ab.service;

import com.ab.binding.UrlBinding;
import com.ab.entity.Url;

public interface IUrlService {

	public Url generateShortLink(UrlBinding url);
	public Url persistShortLink(Url url);
	public Url getEncodedUrl(String url);
	public void deleteShortLink(Url url);
}
