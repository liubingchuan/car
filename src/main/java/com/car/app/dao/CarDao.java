package com.car.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.app.dao.mapper.UserMapper;
import com.car.app.model.User;

@Service
public class CarDao {

    @Autowired
    UserMapper mapper;

    public List<User> getAll(){
    	return mapper.getAll();
    }
    
    public void insertRdsUser(User rdsUser) {
    	mapper.insertRdsUser(rdsUser);
    }
    
    public void deleteAll(){
    	mapper.deleteAll();
    }
}
