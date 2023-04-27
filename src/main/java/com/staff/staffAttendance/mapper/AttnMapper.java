package com.staff.staffAttendance.mapper;

import com.staff.staffAttendance.dto.AttnDto;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

@Mapper
public interface AttnMapper {

    @Select("SELECT ta.attnSeq,ta.userNum,ta.attnDt,ta.approveDt,ta.approveBy,ta.attnType,ta.createBy,ta.createBt,\n" +
            "       (SELECT ts.fullName FROM tb_users ts WHERE ts.userSeq = ta.userId) AS fullName,\n" +
            "       (SELECT tu.username FROM tb_users tu WHERE tu.userSeq = ta.userId) AS userName\n" +
            "       FROM tb_attn ta;")
    List<Map<String,Object>> findAll();

    @Select("SELECT attnSeq from tb_attn WHERE attnSeq = #{attnSeq}")
    AttnDto findById(int attnSeq);

    @Insert("INSERT into tb_attn(userNum,attnType,attnDt,createBy,createBt,approveBy,approveDt,userId) " +
            "VALUES(#{userNum},#{attnType}, #{attnDt},#{createBy},#{createBt},#{approveBy},#{approveDt},#{userId})")
    @ResultMap("com.staff.staffAttendance.mapper.AttnMapper.attnResult")
    void create(AttnDto attnDto);

    @Update("UPDATE tb_attn SET userNum=#{userNum},attnType=#{attnType}, attnDt =#{attnDt}, createBy =#{createBy}, " +
            "createBt =#{createBt},approveBy =#{approveBy},approveDt =#{approveDt},userId =#{userId}" +
            "WHERE attnSeq =#{attnSeq}")
    @ResultMap("com.staff.staffAttendance.mapper.AttnMapper.attnResult")

    void update(AttnDto attnDto);

}
