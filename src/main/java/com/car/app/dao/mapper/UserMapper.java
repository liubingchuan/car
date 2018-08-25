package com.car.app.dao.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import com.car.app.dao.mapper.BasedProvider;
import com.car.app.model.User;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    @Select("SELECT * FROM rds_user")
    List<User> getAll();

//    @Insert("INSERT INTO rds_user (uid, user_id) "
//        + "VALUES (#{rdsUser.uid}, #{rdsUser.userId})")
//    void insertRdsUser(@Param("rdsUser") RdsUser rdsUser);
    @InsertProvider(type = BasedProvider.class, method = BasedProvider.INSERT)
    int insertRdsUser(User rdsUser);

    @Delete("DELETE FROM rds_user")
    void deleteAll();

}
