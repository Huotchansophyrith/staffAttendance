package com.staff.staffAttendance.service.imp;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.constant.Status;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.UserGroupDto;
import com.staff.staffAttendance.mapper.UserGMapper;
import com.staff.staffAttendance.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserGroupServiceImp implements UserGroupService {
    @Autowired
    private UserGMapper userGMapper;
    private final String FIND_SUCCESS ="Find Successfully";
    private final String CREATE_SUCCESS ="Create Successfully";
    private final String UPDATE_SUCCESS ="Update Successfully";
    private final String EXSITS ="Existing Data";

    @Override
    public ResponseDTO findAll() throws RequestException {
        List<UserGroupDto> user = this.userGMapper.findAll();
        return new ResponseDTO(FIND_SUCCESS,user);
    }

    @Override
    public ResponseDTO create(UserGroupDto userGroupDto) throws RequestException {
        this.userGMapper.create(userGroupDto);
        return new ResponseDTO(CREATE_SUCCESS);
    }

    @Override
    public ResponseDTO update(UserGroupDto userGroupDto) throws RequestException {
        UserGroupDto existUser =  this.userGMapper.findById(userGroupDto.getGSeq());
        try{
            this.userGMapper.update(userGroupDto);
            return new ResponseDTO(UPDATE_SUCCESS);
        }catch (Exception e){
            return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
        }
    }
}
