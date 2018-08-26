package com.car.app.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.car.app.model.Information;

@Mapper
@Component
public interface InfoMapper {

    @Select("SELECT * FROM information order by timestamps asc")
    List<Information> getAll();
    
    @Select("SELECT * FROM information where imei = #{imei} and iotstate = #{iotstate} order by timestamps desc")
    List<Information> getInfosByImeiAndIotstate(@Param("iotstate") String iotstate, @Param("imei") String imei);
    
    @InsertProvider(type = BasedProvider.class, method = BasedProvider.INSERT)
    int insertInfo(Information info);

    @Delete("DELETE FROM information where imei = #{imei} and iotstate = #{iotstate} and timestamps = #{timestamps}")
    void deleteOne(@Param("timestamps") Long timestamps, @Param("imei") String imei, @Param("iotstate") String iotstate);

}
