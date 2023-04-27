package com.staff.staffAttendance.service.imp;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.constant.Status;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.UserDto;
import com.staff.staffAttendance.mapper.UserMapper;
import com.staff.staffAttendance.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceIImp implements UserServiceI {

    @Autowired
    private UserMapper userMapper;

    private final String NOT_FOUND_USER_NAME ="Username and Password not found";
    private final String FIND_SUCCESS ="Find Successfully";
    private final String CREATE_SUCCESS ="Create Successfully";
    private final String UPDATE_SUCCESS ="Update Successfully";
    private final String EXSITS ="Existing Data";
    private final String DELETE ="Delete Successfully";

    @Override
    public UserDto loadUserByUsernameAndPassword(String username, String password)throws RequestException{
        return userMapper.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public ResponseDTO findAll() throws RequestException {
        List<UserDto> user = this.userMapper.findALl();
        return new ResponseDTO(FIND_SUCCESS,user);
    }

    @Override
    public Map<String,Object> findUserByUsernameAndPassword(String username, String password) throws RequestException{
        Map<String,Object> user = this.userMapper.findUserByUsernameAndPassword(username,  password);
        if (!user.isEmpty()){
            return user;
        }
        throw new RequestException(String.format(NOT_FOUND_USER_NAME, user));
    }

    @Override
    public ResponseDTO create(UserDto userDto) throws RequestException {
        String ckStaffNum = this.userMapper.findByUsername(userDto.getUsername());
        if (ckStaffNum == null){
//            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            this.userMapper.create(userDto);
            return new ResponseDTO(CREATE_SUCCESS);
        }
        return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
    }

    @Override
    public ResponseDTO update(UserDto userDto) throws RequestException {
        UserDto existUser =  this.userMapper.findById(userDto.getUserSeq());
//        if(!userDto.getPassword().equals(existUser.getPassword())){
//            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        }
        try{
            this.userMapper.update(userDto);
            return new ResponseDTO(UPDATE_SUCCESS);
        }catch (Exception e){
            return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
        }
    }

    @Override
    public ResponseDTO delete(int userSeq) throws RequestException {
//        final String userDefault = "default";
//        String user = this.userMapper.findUserNumDefault(userDefault);
//        if (user != null){
//            throw new RequestException(NO_DELETE);
//        }else {
            this.userMapper.delete(userSeq);
            return new ResponseDTO(DELETE);
//        }
    }

}
