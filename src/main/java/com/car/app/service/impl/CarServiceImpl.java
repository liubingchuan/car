package com.car.app.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.dao.CarDao;

@Service
public class CarServiceImpl extends AbstractCarService{

	private final Logger logger = LogManager.getLogger(this.getClass());
    
    @Autowired
    CarDao rdsUserDao;
    
}
