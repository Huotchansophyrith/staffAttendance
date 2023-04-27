package com.staff.staffAttendance.mapper;

import com.staff.staffAttendance.dto.UserDto;
import com.staff.staffAttendance.dto.UserReqLeaveDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserReqLeaveMapper {

    @Select("SELECT reqleaveseq AS reqLeaveSeq, type_leave AS typeLeave , start_date AS startDate, end_date as endDate, reason as reason,userid as userid,status as status from tb_user_reqleave WHERE enabled = TRUE AND userid = #{userId}")
    @ResultMap("com.staff.staffAttendance.mapper.UserReqLeaveMapper.reqLeaveResult")
    List<UserReqLeaveDto> findAll(int userId);

    @Select("SELECT reqleaveseq AS reqLeaveSeq, type_leave AS typeLeave , start_date AS startDate, end_date as endDate, reason as reason,username as username,userid as userid,status as status from tb_user_reqleave WHERE enabled = TRUE")
    @ResultMap("com.staff.staffAttendance.mapper.UserReqLeaveMapper.reqLeaveResult")
    List<UserReqLeaveDto> findAllReq();

    @Select("SELECT * from tb_user_reqleave WHERE reqLeaveSeq = #{reqLeaveSeq}")
    UserDto findById(int reqLeaveSeq);

    @Insert("INSERT into tb_user_reqleave(type_leave,status,start_date,end_date,reason,userid) VALUES(#{typeLeave}, #{status},#{startDate},#{endDate},#{reason},#{userId})") /* userid use the same as data     #{userId}) use the same as dto */
    @ResultMap("com.staff.staffAttendance.mapper.UserReqLeaveMapper.reqLeaveResult")
    void create(UserReqLeaveDto userReqLeaveDto);

//    void update(UserReqLeaveDto userReqLeaveDto);

    @Update("UPDATE tb_user_reqleave SET typeLeave=#{typeLeave}, status =#{status}, startDate =#{startDate}, endDate =#{endDate}, reason =#{reason} WHERE brSeq =#{brSeq}")
    @ResultMap("com.staff.staffAttendance.mapper.UserReqLeaveMapper.reqLeaveResult")
    void update(UserReqLeaveDto userReqLeaveDto);

    @Update("UPDATE tb_user_reqleave set status='Approved' WHERE reqleaveSeq = #{reqLeaveSeq}")
    @ResultMap("com.staff.staffAttendance.mapper.UserMapper.userResult")
    void updateApprove(UserReqLeaveDto userReqLeaveDto);

    @Update("UPDATE tb_user_reqleave set status='Refused' WHERE reqleaveSeq = #{reqLeaveSeq}")
    @ResultMap("com.staff.staffAttendance.mapper.UserMapper.userResult")
    void updateRefuse(UserReqLeaveDto userReqLeaveDto);

//    @Delete("UPDATE tb_user_reqleave SET enabled=FALSE WHERE reqLeaveSeq =#{reqLeaveSeq}")
//    int delete(int reqLeaveSeq);

//    @Update("UPDATE tb_user_reqleave SET status=Approved WHERE reqLeaveSeq =#{reqLeaveSeq}")
//    int approve(int reqLeaveSeq);

}














