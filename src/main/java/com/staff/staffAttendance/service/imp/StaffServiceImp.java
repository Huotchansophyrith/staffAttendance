//package com.staff.staffAttendance.service.imp;
//
//import com.staff.staffAttendance.common.constant.ResponseDTO;
//import com.staff.staffAttendance.common.constant.Status;
//import com.staff.staffAttendance.common.exception.RequestException;
//import com.staff.staffAttendance.dto.StaffDto;
//import com.staff.staffAttendance.mapper.StaffMapper;
//import com.staff.staffAttendance.service.StaffService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class StaffServiceImp implements StaffService {
//
//    @Autowired
//    private StaffMapper staffMapper;
//
//    private final String FIND_SUCCESS ="Find Successfully";
//    private final String CREATE_SUCCESS ="Create Successfully";
//    private final String UPDATE_SUCCESS ="Update Successfully";
//    private final String EXSITS ="Existing Data";
//    private final String DELETE ="Delete Successfully";
//
//
//    @Override
//    public ResponseDTO findAll() throws RequestException {
//        List<Map<String,Object>> staff = this.staffMapper.findAll();
//        return new ResponseDTO(FIND_SUCCESS,staff);
//    }
//
//    @Override
//    public ResponseDTO create(StaffDto staffDto) throws RequestException {
//        String ckStaffNum = this.staffMapper.findByStaffNum(staffDto.getStaff_number());
//        if (ckStaffNum == null){
//            this.staffMapper.create(staffDto);
//            return new ResponseDTO(CREATE_SUCCESS);
//        }
//        return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
//    }
//
//    @Override
//    public ResponseDTO update(StaffDto staffDto) throws RequestException {
//        this.staffMapper.findById(staffDto.getStaff_seq());
//        try{
//            this.staffMapper.update(staffDto);
//            return new ResponseDTO(UPDATE_SUCCESS);
//        }catch (Exception e){
//            return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
//        }
//    }
//
//    @Override
//    public ResponseDTO delete(int staff_seq) throws RequestException {
//        this.staffMapper.delete(staff_seq);
//        return new ResponseDTO(DELETE);
//    }
//}
