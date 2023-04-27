package com.staff.staffAttendance.service.imp;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.constant.Status;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.UserReqLeaveDto;
import com.staff.staffAttendance.mapper.UserMapper;
import com.staff.staffAttendance.mapper.UserReqLeaveMapper;
import com.staff.staffAttendance.service.UserReqLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.List;

@Service
public class UserReqLeaveServiceImpl implements UserReqLeaveService {

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
    public ResponseDTO findAll(Principal principal)throws RequestException {

        //get username from login and query it to get id...then query that id to get detail and compare

        int userId = this.userMapper.getUserByUsername(principal.getName());
        List<UserReqLeaveDto> userReqLeaveDto = this.userReqLeaveMapper.findAll(userId);

        return new ResponseDTO(FIND_SUCCESS,userReqLeaveDto);
    }

    @Override
    public ResponseDTO findAllReq()throws RequestException{
        List<UserReqLeaveDto> reqList = this.userReqLeaveMapper.findAllReq();
        return new ResponseDTO(FIND_SUCCESS,reqList);
    }

//    @Override
//    public ResponseDTO create(UserReqLeaveDto userReqLeaveDto)throws RequestException{
//        this.userReqLeaveMapper.create(userReqLeaveDto);
//        return new ResponseDTO(CREATE_SUCCESS);
//    }


    @Override
    public ResponseDTO create(UserReqLeaveDto userReqLeaveDto)throws RequestException{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userLoginName = auth.getPrincipal().toString();
        int userSeq = userMapper.getUserByUsername(userLoginName); // get user's seq by comparing username in database
        userReqLeaveDto.setUserId(userSeq);
        this.userReqLeaveMapper.create(userReqLeaveDto);
        return new ResponseDTO(CREATE_SUCCESS);
    }
    
    @Override
    public ResponseDTO update(UserReqLeaveDto userReqLeaveDto)throws RequestException{

        this.userReqLeaveMapper.findById(userReqLeaveDto.getReqLeaveSeq());

        try{
            this.userReqLeaveMapper.update(userReqLeaveDto);
            return new ResponseDTO(UPDATE_SUCCESS);
        }catch (Exception e){
            return new ResponseDTO(EXIST, Status.EXIST.value(),409);
        }

    }

//    @Override
//    public ResponseDTO approve(int reqLeaveSeq) throws RequestException {
//
//        this.userReqLeaveMapper.approve(reqLeaveSeq);
//        return new ResponseDTO("Approve");
//       }


}
