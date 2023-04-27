package com.staff.staffAttendance.service;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.AttnDto;
import org.springframework.stereotype.Service;

@Service
public interface AttnService {

//    ResponseDTO findAllByAdminId(int adm_id) throws RequestException;
    ResponseDTO findAll() throws RequestException;
    ResponseDTO create(AttnDto attnDto) throws RequestException;
    ResponseDTO update(AttnDto attnDto) throws RequestException;
//    ResponseDTO delete(int attn_seq) throws RequestException;

}
