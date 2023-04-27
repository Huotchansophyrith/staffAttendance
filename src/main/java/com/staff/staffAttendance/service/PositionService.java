package com.staff.staffAttendance.service;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.dto.PositionDto;
import org.springframework.stereotype.Service;

@Service
public interface PositionService {

     ResponseDTO findAll();
     ResponseDTO create(PositionDto positionDto);
     ResponseDTO update(PositionDto positionDto);
     ResponseDTO delete(int posSeq);
}
