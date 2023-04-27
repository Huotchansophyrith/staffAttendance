package com.staff.staffAttendance.mapper;

import com.staff.staffAttendance.dto.UserGroupDto;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserGMapper {
    @Select("SELECT * from tb_user_groups")
    @ResultMap("com.staff.staffAttendance.mapper.UserGMapper.userGResult")
    List<UserGroupDto> findAll();

    @Select("SELECT gSeq from tb_user_groups WHERE gSeq = #{gSeq}")
    UserGroupDto findById(int gSeq);

    @Select("SELECT * from tb_user_groups WHERE gSeq = #{gSeq}")
    UserGroupDto findAllById(int gSeq);

    @Insert("INSERT into tb_user_groups(managerId,memberId,userId) VALUES(#{managerId},#{memberId},#{userId})")
    @ResultMap("com.staff.staffAttendance.mapper.UserGMapper.userGResult")
    void create(UserGroupDto userGroupDto);

    @Update("UPDATE tb_user_groups SET managerId=#{managerId},memberId=#{memberId},userId=#{userId} WHERE gSeq =#{gSeq}")
    @ResultMap("com.staff.staffAttendance.mapper.UserGMapper.userGResult")
    void update(UserGroupDto userGroupDto);

//    @Delete("UPDATE tb_user_groups SET enabled=FALSE WHERE g_seq =#{g_seq}")
//    int delete(int g_seq);

}
