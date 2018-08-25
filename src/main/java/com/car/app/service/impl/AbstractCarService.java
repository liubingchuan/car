package com.car.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.car.app.service.CarService;

public abstract class AbstractCarService implements CarService{

	@Autowired
	protected RestTemplate restTemplate;

	protected String endpoint;

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	public static final Logger logger = LoggerFactory.getLogger(AbstractCarService.class);


}
