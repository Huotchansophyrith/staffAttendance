//package com.staff.staffAttendance.controller.rest;
//
//import com.staff.staffAttendance.common.constant.ResponseDTO;
//import com.staff.staffAttendance.dto.StaffDto;
//import com.staff.staffAttendance.service.StaffService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(value = "/api/v1/staffs")
//public class StaffRestController {
//
//    @Autowired
//    private StaffService staffService;
//
//    @GetMapping
//    public ResponseDTO findAll(){
//        return this.staffService.findAll();
//    }
//
//    @PostMapping
//    public ResponseDTO create(@RequestBody StaffDto staffDto){
//        return this.staffService.create(staffDto);
//    }
//
//    @PutMapping
//    public ResponseDTO update(@RequestBody StaffDto staffDto){
//        return this.staffService.update(staffDto);
//    }
//
//    @DeleteMapping("/delete/{staff_seq}")
//    public ResponseDTO delete(@PathVariable int staff_seq){
//        return this.staffService.delete(staff_seq);
//    }
//
//}
