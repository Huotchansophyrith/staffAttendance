package com.staff.staffAttendance.service.imp;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.constant.Status;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.PositionDto;
import com.staff.staffAttendance.mapper.PositionMapper;
import com.staff.staffAttendance.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImp implements PositionService {

     @Autowired
     private PositionMapper positionMapper;

     private final String FIND_SUCCESS = "Find Successfully";
     private final String CREATE_SUCCESS = "Created Successfully";
     private final String UPDATE_SUCCESS = "Updated Successfully";
     private final String DELETE = "Deleted Successfully";
     private final String EXSITS = "EXSITS DATA";

    @Override
    public ResponseDTO findAll() throws RequestException {
        List<PositionDto> pos = this.positionMapper.findAll();
        return new ResponseDTO(FIND_SUCCESS,pos);
    }

    @Override
    public ResponseDTO create(PositionDto positionDto) throws RequestException{
        String chkName =this.positionMapper.findByPosName(positionDto.getPosName());
        if(chkName == null){
            this.positionMapper.create(positionDto);
            return new ResponseDTO(CREATE_SUCCESS);
        }
        return new ResponseDTO(EXSITS,Status.EXIST.value(), 409);
    }

    @Override
    public ResponseDTO update(PositionDto positionDto) throws RequestException {
        this.positionMapper.findById(positionDto.getPosSeq());
        try{
            this.positionMapper.update(positionDto);
            return new ResponseDTO(UPDATE_SUCCESS);
        }catch (Exception branch){
            return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
        }
    }


    @Override
    public ResponseDTO delete(int posSeq) throws RequestException{
        this.positionMapper.delete(posSeq);
        return new ResponseDTO(DELETE) ;
    }

}
