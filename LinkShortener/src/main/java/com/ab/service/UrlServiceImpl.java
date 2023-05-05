package com.ab.service;

import java.nio.charset.Charset;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.binding.UrlBinding;
import com.ab.entity.Url;
import com.ab.repository.UrlRepository;
import com.google.common.hash.Hashing;

@Service
public class UrlServiceImpl implements IUrlService {
	
	@Autowired
	private UrlRepository urlRepo;

	@Override
	public Url generateShortLink(UrlBinding url1) {
		String orgLink=url1.getUrl();
		Url result=null;
		if(!orgLink.isEmpty()) {
			//convert into short Link
			String encodedUrl=encodeUrl(orgLink);
			
			Url url=new Url();
			url.setCreationDate(LocalDateTime.now());
			url.setOriginalLink(orgLink);
			url.setShortLink(encodedUrl);
			result=persistShortLink(url);
		}
		return result;
	}

	//to generate short Link using guava library
	private String encodeUrl(String orgLink) {
		String encodedUrl=Hashing.murmur3_32().hashString(orgLink, Charset.defaultCharset()).toString();
		return encodedUrl;
	}

	@Override
	public Url persistShortLink(Url url) {
		Url details=urlRepo.save(url);
		return details;
	}

	@Override
	public Url getEncodedUrl(String url) {
		Url details=urlRepo.findByShortLink(url);
		return details;
	}

	@Override
	public void deleteShortLink(Url url) {
		urlRepo.delete(url);
	}

}
