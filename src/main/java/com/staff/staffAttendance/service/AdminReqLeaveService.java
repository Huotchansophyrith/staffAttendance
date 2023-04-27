package com.staff.staffAttendance.service;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.AdminReqLeaveDto;
import com.staff.staffAttendance.dto.UserReqLeaveDto;
import org.springframework.stereotype.Service;

@Service
public interface AdminReqLeaveService {
    ResponseDTO findAllReq()throws RequestException;

    ResponseDTO findAllReq1()throws RequestException;

    ResponseDTO create(UserReqLeaveDto userReqLeaveDto)throws RequestException;

    ResponseDTO update_Approve(UserReqLeaveDto userReqLeaveDto)throws RequestException;

    ResponseDTO update_Refuse(UserReqLeaveDto userReqLeaveDto)throws RequestException;
}
