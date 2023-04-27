package com.staff.staffAttendance.mapper;

import com.staff.staffAttendance.dto.AdminReqLeaveDto;
import com.staff.staffAttendance.dto.UserReqLeaveDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminReqLeaveMapper {
    @Select("SELECT adminReqLeaveSeq AS adminReqLeaveSeq, type_leave AS typeLeave , start_date AS startDate, end_date as endDate, reason as reason,username as username,userid as userid,status as status from tb_user_reqleave WHERE enabled = TRUE")
    @ResultMap("com.staff.staffAttendance.mapper.AdminReqLeaveMapper.adminReqLeaveResult")
    List<AdminReqLeaveDto> findAllReq();

    @Select("SELECT tur.reqleaveseq AS reqLeaveSeq," +
            "       tur.type_leave AS typeLeave ," +
            "       tur.start_date AS startDate," +
            "       tur.end_date as endDate," +
            "       tur.reason as reason" +
            "       ,tur.userid as userid," +
            "       tur.status as status," +
            "       concat(tu.usernum, '(', tu.username, ')') AS userIdNm" +
            " from tb_user_reqleave tur" +
            " inner join tb_users tu on tur.userid = tu.userseq" +
            " WHERE tur.enabled = TRUE")
    @ResultMap("com.staff.staffAttendance.mapper.UserReqLeaveMapper.reqLeaveResult")
    List<UserReqLeaveDto> findAllReq1();

//    @Update("UPDATE tb_admin_reqleave set status='approved' WHERE reqleaveSeq = #{reqLeaveSeq}")
//    @ResultMap("com.staff.staffAttendance.mapper.UserMapper.userResult")
//    void updateApproveRefuse(AdminReqLeaveDto adminReqLeaveDto);

    @Insert("INSERT into tb_admin_reqLeave(type_leave,status,start_date,end_date,reason,userid) VALUES(#{typeLeave}, #{status},#{startDate},#{endDate},#{reason},#{userId})") /* userid use the same as data     #{userId}) use the same as dto */
    @ResultMap("com.staff.staffAttendance.mapper.AdminReqLeaveMapper.adminReqLeaveResult")
    void create(AdminReqLeaveDto adminReqLeaveDto);
}

