package com.staff.staffAttendance.service;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.UserGroupDto;
import org.springframework.stereotype.Service;

@Service
public interface UserGroupService {

    ResponseDTO findAll() throws RequestException;
    ResponseDTO create(UserGroupDto userGroupDto) throws RequestException;
    ResponseDTO update(UserGroupDto userGroupDto) throws RequestException;
}
