package com.chinthana.learn.springboot.restfull.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chinthana.learn.springboot.restfull.currencyexchangeservice.domain.ExchangeValue;
import com.chinthana.learn.springboot.restfull.currencyexchangeservice.repo.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getCurrencyExchaneValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(environment.getProperty("local.server.port"));		
		return  exchangeValueRepository.findByFromAndTo(from, to);	
		
	}
}
