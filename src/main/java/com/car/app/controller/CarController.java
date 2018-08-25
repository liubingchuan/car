package com.car.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.app.common.BaseResponse;
import com.car.app.dao.mapper.UserMapper;



@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/funrockcar")
public class CarController {

	private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
    private UserMapper mapper;
	
	@PostMapping("/register")
	@ResponseBody
	public BaseResponse register() {
		return null;
	}
	
}
