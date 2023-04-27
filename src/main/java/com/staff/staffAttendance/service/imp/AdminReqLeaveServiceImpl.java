package com.staff.staffAttendance.service.imp;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.constant.Status;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.AdminReqLeaveDto;
import com.staff.staffAttendance.dto.UserReqLeaveDto;
import com.staff.staffAttendance.mapper.AdminReqLeaveMapper;
import com.staff.staffAttendance.mapper.UserMapper;
import com.staff.staffAttendance.mapper.UserReqLeaveMapper;
import com.staff.staffAttendance.service.AdminReqLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminReqLeaveServiceImpl implements AdminReqLeaveService {

    @Autowired
    private AdminReqLeaveMapper adminReqLeaveMapper;

    @Autowired
    private UserReqLeaveMapper userReqLeaveMapper;

    @Autowired
    private UserMapper userMapper;

    private final String FIND_SUCCESS = "Find Successfully";
    private final String CREATE_SUCCESS = "Created Successfully";
    private final String UPDATE_SUCCESS = "Updated Successfully";
    private final String DELETE = "Deleted Successfully";
    private final String EXIST = "EXIST DATA";


    @Override
    public ResponseDTO findAllReq()throws RequestException {
        List<AdminReqLeaveDto> reqList = this.adminReqLeaveMapper.findAllReq();
        return new ResponseDTO(FIND_SUCCESS,reqList);
    }
    @Override
    public ResponseDTO findAllReq1()throws RequestException {
        List<UserReqLeaveDto>  reqList = this.adminReqLeaveMapper.findAllReq1();
            return new ResponseDTO(FIND_SUCCESS,reqList);
    }

    @Override
    public ResponseDTO create(UserReqLeaveDto userReqLeaveDto)throws RequestException{
        this.userReqLeaveMapper.create(userReqLeaveDto);
        return new ResponseDTO(CREATE_SUCCESS);
    }

    @Override
    public ResponseDTO update_Approve(UserReqLeaveDto userReqLeaveDto)throws RequestException{
        try{
            this.userReqLeaveMapper.updateApprove(userReqLeaveDto);
            return new ResponseDTO(UPDATE_SUCCESS);
        }catch (Exception e){
            return new ResponseDTO(EXIST, Status.EXIST.value(),409);
        }
    }


    @Override
    public ResponseDTO update_Refuse(UserReqLeaveDto userReqLeaveDto)throws RequestException{
        try{
            this.userReqLeaveMapper.updateRefuse(userReqLeaveDto);
            return new ResponseDTO(UPDATE_SUCCESS);
        }catch (Exception e){
            return new ResponseDTO(EXIST, Status.EXIST.value(),409);
        }
    }




}
