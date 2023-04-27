package com.staff.staffAttendance.service;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserServiceI {

    UserDto loadUserByUsernameAndPassword(String username, String password) throws RequestException;
    ResponseDTO findAll() throws RequestException;

//    for login to client app
    Map<String,Object> findUserByUsernameAndPassword(String username,String password) throws RequestException;

    ResponseDTO create(UserDto userDto) throws RequestException;
    ResponseDTO update(UserDto userDto) throws RequestException;
    ResponseDTO delete(int userSeq) throws RequestException;

}
