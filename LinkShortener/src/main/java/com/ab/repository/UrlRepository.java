package com.ab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ab.entity.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {

	public Url findByShortLink(String shortLink);
}
