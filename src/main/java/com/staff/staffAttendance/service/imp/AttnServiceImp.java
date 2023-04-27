package com.staff.staffAttendance.service.imp;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.constant.Status;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.AttnDto;
import com.staff.staffAttendance.dto.UserDto;
import com.staff.staffAttendance.mapper.AttnMapper;
import com.staff.staffAttendance.mapper.UserMapper;
import com.staff.staffAttendance.service.AttnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AttnServiceImp implements AttnService {

     @Autowired
     private AttnMapper attnMapper;

     @Autowired
     private UserMapper userMapper;

     private final String FIND_SUCCESS = "Find Successfully";
     private final String CREATE_SUCCESS = "Created Successfully";
     private final String UPDATE_SUCCESS = "Updated Successfully";
     private final String EXSITS = "EXSITS DATA";

//    @Override
//    public ResponseDTO findAllByAdminId(int adm_id) throws RequestException {
//        List<Map<String,Object>> attn = this.attnMapper.findAllByAdminId(getCurrentLoginUser().getAdm_seq());
//        return new ResponseDTO(FIND_SUCCESS,attn);
//    }

    @Override
    public ResponseDTO findAll() throws RequestException {
        List<Map<String,Object>> attn = this.attnMapper.findAll();
        return new ResponseDTO(FIND_SUCCESS,attn);
    }

    @Override
    public ResponseDTO create(AttnDto attnDto) throws RequestException{
        this.attnMapper.create(attnDto);
        return new ResponseDTO(CREATE_SUCCESS);
    }

    @Override
    public ResponseDTO update(AttnDto attnDto) throws RequestException{
        this.attnMapper.findById(attnDto.getAttnSeq());
        try{
            this.attnMapper.update(attnDto);
            return new ResponseDTO(UPDATE_SUCCESS);
        }catch (Exception e){
            return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
        }
    }

}
