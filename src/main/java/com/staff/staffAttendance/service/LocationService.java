package com.staff.staffAttendance.service;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.LocationDto;
import org.springframework.stereotype.Service;

@Service
public interface LocationService {

    ResponseDTO findAll() throws RequestException;
    ResponseDTO create(LocationDto locationDto) throws RequestException;
    ResponseDTO update(LocationDto locationDto) throws RequestException;
    ResponseDTO delete(int logSeq) throws RequestException;

}
