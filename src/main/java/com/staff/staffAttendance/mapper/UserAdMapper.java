//package com.staff.staffAttendance.mapper;
//
//import com.staff.staffAttendance.dto.UserAdDto;
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//
//@Mapper
//public interface UserAdMapper {
//
//    @Select("SELECT * from tb_admin WHERE enabled = TRUE")
//    @ResultMap("com.staff.staffAttendance.mapper.UserAdMapper.userAdResult")
//    List<UserAdDto> findAll();
//
//    @Select("SELECT adm_seq from tb_admin WHERE username = #{username}")
//    UserAdDto findByCurrentUsername(String username);
//
//    @Select("SELECT username from tb_admin WHERE username = #{username}")
//    String findByUsername(String username);
//
//    @Select("SELECT * from tb_admin WHERE adm_seq = #{adm_seq}")
//    UserAdDto findAllById(int adm_seq);
//
//    @Select("SELECT adm_seq from tb_admin WHERE adm_seq = #{adm_seq}")
//    UserAdDto findById(int adm_seq);
//
//    @Insert("INSERT into tb_admin(full_name,username,password,create_at,update_at,login_count) " +
//            "VALUES(#{full_name},#{username},#{password},#{create_at},#{update_at},#{login_count})")
//    @ResultMap("com.staff.staffAttendance.mapper.UserAdMapper.userAdResult")
//    void create(UserAdDto userAdDto);
//
//    @Update("UPDATE tb_admin SET full_name=#{full_name} ,username=#{username},password=#{password},create_at=#{create_at}," +
//            "update_at=#{update_at},login_count=#{login_count}" +
//            "WHERE adm_seq =#{adm_seq}")
//    @ResultMap("com.staff.staffAttendance.mapper.UserAdMapper.userAdResult")
//    void update(UserAdDto userAdDto);
//
//    @Delete("UPDATE tb_admin SET enabled=FALSE WHERE adm_seq =#{adm_seq}")
//    int delete(int adm_seq);
//
//}
