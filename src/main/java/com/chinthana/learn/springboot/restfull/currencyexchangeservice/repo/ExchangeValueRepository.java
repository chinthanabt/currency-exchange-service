package com.chinthana.learn.springboot.restfull.currencyexchangeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chinthana.learn.springboot.restfull.currencyexchangeservice.domain.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);

}
