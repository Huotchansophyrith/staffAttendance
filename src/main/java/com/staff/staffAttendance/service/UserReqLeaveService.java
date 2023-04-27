package com.staff.staffAttendance.service;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.UserReqLeaveDto;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface UserReqLeaveService {


    ResponseDTO findAll(Principal principal)throws RequestException;

    ResponseDTO findAllReq()throws RequestException;

    ResponseDTO create(UserReqLeaveDto userReqLeaveDto)throws RequestException;

    ResponseDTO update(UserReqLeaveDto userReqLeaveDto)throws RequestException;

}
