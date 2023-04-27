package com.staff.staffAttendance.service;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.dto.DepartmentDto;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {

    ResponseDTO findAll();
    ResponseDTO create(DepartmentDto departmentDto);
    ResponseDTO update(DepartmentDto departmentDto);
    ResponseDTO delete(int departSeq);

}
