package com.car.app.dao.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import com.car.app.dao.mapper.BasedProvider;
import com.car.app.model.ImeiUser;

import java.util.List;

@Mapper
@Component
public interface ImeiUserMapper {

    @Select("SELECT * FROM imei_user")
    List<ImeiUser> getAll();
    
    @Select("SELECT * FROM imei_user where imei = #{imei} and count = #{count}")
    List<ImeiUser> getIMEIUserByIMEIAndCount(@Param("imei") String imei, @Param("count") Integer count);
    
    @Select("SELECT * FROM imei_user where imei = #{imei}")
    List<ImeiUser> getIMEIUserByIMEI(@Param("imei") String imei);

    @InsertProvider(type = BasedProvider.class, method = BasedProvider.INSERT)
    int insertIMEIUser(ImeiUser iu);

    @Delete("DELETE FROM imei_user")
    void deleteAll();
    
    @Update("update imei_user set count = #{count} where imei = #{imei}")
    void updateImei(@Param("imei") String imei, @Param("count") Integer count);


}
