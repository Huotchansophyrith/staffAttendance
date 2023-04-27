//package com.staff.staffAttendance.service.imp;
//
//import com.staff.staffAttendance.common.constant.ResponseDTO;
//import com.staff.staffAttendance.common.constant.Status;
//import com.staff.staffAttendance.common.exception.RequestException;
//import com.staff.staffAttendance.dto.UserAdDto;
//import com.staff.staffAttendance.dto.UserAdDto;
//import com.staff.staffAttendance.mapper.UserAdMapper;
//import com.staff.staffAttendance.mapper.UserMapper;
//import com.staff.staffAttendance.service.UserAdService;
//import com.staff.staffAttendance.service.UserServiceI;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserAdServiceImp implements UserAdService {
//
//    @Autowired
//    private UserAdMapper userMapper;
//
//    private BCryptPasswordEncoder passwordEncoder;
//
//
//    private final String FIND_SUCCESS ="Find Successfully";
//    private final String CREATE_SUCCESS ="Create Successfully";
//    private final String UPDATE_SUCCESS ="Update Successfully";
//    private final String EXSITS ="Existing Data";
//    private final String DELETE ="Delete Successfully";
//
//    @Override
//    public ResponseDTO findAll() throws RequestException {
//        List<UserAdDto> user = this.userMapper.findAll();
//        return new ResponseDTO(FIND_SUCCESS,user);
//    }
//
//    @Override
//    public ResponseDTO create(UserAdDto userAdDto) throws RequestException {
//        String ckStaffNum = this.userMapper.findByUsername(userAdDto.getUsername());
//        if (ckStaffNum == null){
////            userAdDto.setPassword(passwordEncoder.encode(userAdDto.getPassword()));
//            this.userMapper.create(userAdDto);
//            return new ResponseDTO(CREATE_SUCCESS);
//        }
//        return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
//    }
//
//    @Override
//    public ResponseDTO update(UserAdDto userAdDto) throws RequestException {
//        UserAdDto existUser =  this.userMapper.findById(userAdDto.getAdm_seq());
////        if(!userAdDto.getPassword().equals(existUser.getPassword())){
////            userAdDto.setPassword(passwordEncoder.encode(userAdDto.getPassword()));
////        }
//        try{
//            this.userMapper.update(userAdDto);
//            return new ResponseDTO(UPDATE_SUCCESS);
//        }catch (Exception e){
//            return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
//        }
//    }
//
//    @Override
//    public ResponseDTO delete(int adm_seq) throws RequestException {
//        this.userMapper.delete(adm_seq);
//        return new ResponseDTO(DELETE);
//    }
//}
