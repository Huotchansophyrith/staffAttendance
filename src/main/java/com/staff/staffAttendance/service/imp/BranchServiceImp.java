package com.staff.staffAttendance.service.imp;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.constant.Status;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.BranchDto;
import com.staff.staffAttendance.mapper.BranchMapper;
import com.staff.staffAttendance.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImp implements BranchService {

     @Autowired
     private BranchMapper branchMapper;

     private final String FIND_SUCCESS = "Find Successfully";
     private final String CREATE_SUCCESS = "Created Successfully";
     private final String UPDATE_SUCCESS = "Updated Successfully";
     private final String DELETE = "Deleted Successfully";
     private final String EXSITS = "EXSITS DATA";

    @Override
    public ResponseDTO findAll() throws RequestException {
        List<BranchDto> branchDto = this.branchMapper.findAll();
        return new ResponseDTO(FIND_SUCCESS,branchDto);
    }

    @Override
    public ResponseDTO create(BranchDto branchDto) throws RequestException{
        String chkName =this.branchMapper.findByBranchName(branchDto.getName());
        if(chkName == null){
            this.branchMapper.create(branchDto);
            return new ResponseDTO(CREATE_SUCCESS);
        }
        return new ResponseDTO(EXSITS,Status.EXIST.value(), 409);
    }

    @Override
    public ResponseDTO update(BranchDto branchDto) throws RequestException{
        this.branchMapper.findById(branchDto.getBrSeq());
        try{
            this.branchMapper.update(branchDto);
            return new ResponseDTO(UPDATE_SUCCESS);
        }catch (Exception branch){
            return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
        }
    }

    @Override
    public ResponseDTO delete(int brSeq) throws RequestException{
        this.branchMapper.delete(brSeq);
        return new ResponseDTO(DELETE) ;
    }


}
