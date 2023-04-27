package com.staff.staffAttendance.mapper;

import com.staff.staffAttendance.dto.PositionDto;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PositionMapper {

    @Select("SELECT * from tb_positions WHERE enabled = TRUE")
    @ResultMap("com.staff.staffAttendance.mapper.PositionMapper.posResult")
    List<PositionDto> findAll();

    @Select("SELECT posName from tb_positions WHERE posName = #{posName}")
    String findByPosName(String posName);

    @Select("SELECT posSeq from tb_positions WHERE posSeq = #{posSeq}")
    PositionDto findById(int posSeq);

    @Select("SELECT * from tb_positions WHERE posSeq = #{posSeq}")
    PositionDto findAllById(int posSeq);

    @Insert("INSERT into tb_positions(posName,description) VALUES(#{posName},#{description})")
    @ResultMap("com.staff.staffAttendance.mapper.PositionMapper.posResult")
    void create(PositionDto positionDto);

    @Update("UPDATE tb_positions SET posName=#{posName}, description =#{description} WHERE posSeq =#{posSeq}")
    @ResultMap("com.staff.staffAttendance.mapper.PositionMapper.posResult")
    void update(PositionDto positionDto);

    @Delete("UPDATE tb_positions SET enabled=FALSE WHERE posSeq =#{posSeq}")
    int delete(int posSeq);

}
