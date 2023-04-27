package com.staff.staffAttendance.service.imp;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.common.constant.Status;
import com.staff.staffAttendance.common.exception.RequestException;
import com.staff.staffAttendance.dto.DepartmentDto;
import com.staff.staffAttendance.mapper.DepartmentMapper;
import com.staff.staffAttendance.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    private final String FIND_SUCCESS = "Find Successfully";
    private final String CREATE_SUCCESS = "Created Successfully";
    private final String UPDATE_SUCCESS = "Updated Successfully";
    private final String DELETE = "Deleted Successfully";
    private final String EXSITS = "EXSITS DATA";

    @Override
    public ResponseDTO findAll() throws RequestException {
        List<Map<String,Object>> listDepart = this.departmentMapper.findAll();
        return new ResponseDTO(FIND_SUCCESS,listDepart);
    }

    @Override
    public ResponseDTO create(DepartmentDto departmentDto) throws RequestException {
//        String chkName =this.departmentMapper.findByBranchName(departmentDto.getName());
//        if(chkName == null){
            this.departmentMapper.create(departmentDto);
            return new ResponseDTO(CREATE_SUCCESS);
//        }
//        return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
    }

    @Override
    public ResponseDTO update(DepartmentDto departmentDto) throws RequestException{
        this.departmentMapper.findById(departmentDto.getDepartSeq());
        try{
            this.departmentMapper.update(departmentDto);
            return new ResponseDTO(UPDATE_SUCCESS);
        }catch (Exception branch){
            return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
        }
    }

    @Override
    public ResponseDTO delete(int departSeq) throws RequestException {
        this.departmentMapper.delete(departSeq);
        return new ResponseDTO(DELETE) ;
    }
}
