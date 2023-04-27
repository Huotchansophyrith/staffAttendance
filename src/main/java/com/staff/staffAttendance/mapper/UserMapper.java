package com.staff.staffAttendance.mapper;

import com.staff.staffAttendance.dto.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM tb_users WHERE username = #{username} AND password = #{password}")
    UserDto getUserByUsernameAndPassword(String username,String password);

    @Select("SELECT userseq FROM tb_users WHERE username = #{username}")
    int getUserByUsername(String username);

//  for login in client app
    @Select("SELECT * FROM tb_users WHERE username = #{username} AND password = #{password}")
    Map<String, Object> findUserByUsernameAndPassword(String username,String password);

    @Select("SELECT userType FROM tb_users WHERE username = #{username} AND enabled = TRUE;")
    int getUserType(String username);

    @Select("SELECT * FROM tb_users WHERE enabled = TRUE")
    List<UserDto> findALl();

    @Select("SELECT * from tb_users WHERE userSeq = #{userSeq}")
    UserDto findById(int userSeq);

    @Select("SELECT username FROM tb_users WHERE username = #{username} AND enabled = TRUE")
    String findByUsername(String username);

    @Select("SELECT userSeq FROM tb_users WHERE username = #{username} AND enabled = TRUE")
    UserDto getCurrentUserLogin(String username);

    @Insert("INSERT INTO tb_users (fullName,username,password,userNum,userType,age,gender,email,phone,proImg,proImgPath,posId,brId,departId," +
            "createDateTime,createId,updateDateTime,updateId,logCount,enabled) VALUES (#{fullName},#{username},#{password},#{userNum},#{userType}," +
            "#{age},#{gender},#{email},#{phone},#{proImg},#{proImgPath},#{posId},#{brId},#{departId},#{createDateTime},#{createId},#{updateDateTime}," +
            "#{updateId},#{logCount},#{enabled}) ")
    @ResultMap("com.staff.staffAttendance.mapper.UserMapper.userResult")
    void create(UserDto userDto);

    @Update("UPDATE tb_users SET fullName= #{fullName},username= #{username},password= #{password},userNum = #{userNum},userType = #{userType}," +
            "age= #{age},gender= #{gender},email = #{email},phone = #{phone},proImg=#{proImg},proImgPath= #{proImgPath},posId=#{posId}," +
            "brId= #{brId},departId= #{departId},createDateTime= #{createDateTime},createId= #{createId},updateDateTime=#{updateDateTime},updateId= #{updateId}," +
            "logCount=#{logCount},enabled= #{enabled} WHERE userSeq =#{userSeq}")
    @ResultMap("com.staff.staffAttendance.mapper.UserMapper.userResult")
    void update(UserDto userDto);

    @Delete("UPDATE tb_users SET enabled=FALSE WHERE userSeq =#{userSeq} AND userNum != 'default' ")
    int delete(int userSeq);

    @Select("SELECT tu.brId,tu.departId,tu.posId," +
            "(SELECT br.name FROM tb_branches br WHERE br.brSeq = tu.brId ) AS brName," +
            "(SELECT td.name FROM tb_depart td WHERE td.departSeq = tu.departId ) AS departName," +
            "(SELECT tp.posName FROM tb_positions tp WHERE tp.posSeq = tu.posId ) AS posName " +
            "FROM tb_users tu WHERE tu.userSeq = #{userSeq}\n")
    Map<String,Object> findBrDepartPosByUserId(int userSeq);
}
