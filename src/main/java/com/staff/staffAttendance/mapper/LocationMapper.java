package com.staff.staffAttendance.mapper;

import com.staff.staffAttendance.dto.LocationDto;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface LocationMapper {

    @Select("SELECT * from tb_locations WHERE enabled = TRUE")
    @ResultMap("com.staff.staffAttendance.mapper.LocationMapper.locationResult")
    List<LocationDto> findAll();

    @Select("SELECT name from tb_locations WHERE name = #{name}")
    String findByLocName(String name);

    @Select("SELECT loc_seq from tb_locations WHERE loc_seq = #{loc_seq}")
    LocationDto findById(int loc_seq);

    @Select("SELECT * from tb_locations WHERE loc_seq = #{loc_seq}")
    LocationDto findAllById(int loc_seq);

    @Insert("INSERT into tb_locations(name,latitude,branch_id,longitude) " +
            "VALUES(#{name}, #{latitude},#{branch_id},#{longitude})")
    @ResultMap("com.staff.staffAttendance.mapper.LocationMapper.locationResult")
    void create(LocationDto locationDto);

    @Update("UPDATE tb_locations SET name=#{name}, latitude =#{latitude}, branch_id =#{branch_id}, longitude =#{longitude} WHERE loc_seq =#{loc_seq}")
    @ResultMap("com.staff.staffAttendance.mapper.LocationMapper.locationResult")
    void update(LocationDto locationDto);

    @Delete("UPDATE tb_locations SET enabled=FALSE WHERE loc_seq =#{loc_seq}")
    int delete(int loc_seq);

}
