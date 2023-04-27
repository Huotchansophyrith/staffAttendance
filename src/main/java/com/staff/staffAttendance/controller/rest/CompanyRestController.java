//package com.staff.staffAttendance.controller.rest;
//
//import com.staff.staffAttendance.common.constant.ResponseDTO;
//import com.staff.staffAttendance.dto.CompanyDto;
//import com.staff.staffAttendance.service.CompanyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v1/company")
//public class CompanyRestController {
//
//    @Autowired
//    private CompanyService companyService;
//
//    @GetMapping
//    public ResponseDTO findAll(){
//        return this.companyService.findAll();
//    }
//
//    @PostMapping
//    public ResponseDTO create(@RequestBody CompanyDto companyDto){
//        return companyService.create(companyDto);
//    }
//
//    @PutMapping
//    public ResponseDTO update(@RequestBody CompanyDto companyDto){
//        return companyService.update(companyDto);
//    }
//
//    @DeleteMapping("/delete/{company_seq}")
//    public ResponseDTO detete(@PathVariable int company_seq){
//        return companyService.delete(company_seq);
//    }
//
//}
