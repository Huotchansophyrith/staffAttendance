//package com.staff.staffAttendance.service.imp;
//
//import com.staff.staffAttendance.common.constant.ResponseDTO;
//import com.staff.staffAttendance.common.constant.Status;
//import com.staff.staffAttendance.common.exception.RequestException;
//import com.staff.staffAttendance.dto.CompanyDto;
//import com.staff.staffAttendance.mapper.CompanyMapper;
//import com.staff.staffAttendance.service.CompanyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class CompanyServiceImp implements CompanyService {
//    @Autowired
//    private CompanyMapper companyMapper;
//
//    private final String FIND_SUCCESS ="Find Successfully";
//    private final String CREATE_SUCCESS ="Create Successfully";
//    private final String UPDATE_SUCCESS ="Update Successfully";
//    private final String EXSITS ="Existing Data";
//    private final String DELETE ="Delete Successfully";
//
//    @Override
//    public ResponseDTO findAll() throws RequestException {
//        List<Map<String,Object>> com = this.companyMapper.findAll();
//        return new ResponseDTO(FIND_SUCCESS,com);
//    }
//
//    @Override
//    public ResponseDTO create(CompanyDto companyDto) throws RequestException {
//        String comName = this.companyMapper.findByComName(companyDto.getCompany_name());
//        if (comName == null){
//            this.companyMapper.create(companyDto);
//            return new ResponseDTO(CREATE_SUCCESS);
//        }
//        return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
//    }
//
//    @Override
//    public ResponseDTO update(CompanyDto companyDto) throws RequestException {
//        this.companyMapper.findById(companyDto.getCompany_seq());
//        try{
//            this.companyMapper.update(companyDto);
//            return new ResponseDTO(UPDATE_SUCCESS);
//        }catch (Exception e){
//            return new ResponseDTO(EXSITS, Status.EXIST.value(), 409);
//        }
//    }
//
//    @Override
//    public ResponseDTO delete(int company_seq) throws RequestException {
//        this.companyMapper.delete(company_seq);
//        return new ResponseDTO(DELETE) ;
//    }
//}
