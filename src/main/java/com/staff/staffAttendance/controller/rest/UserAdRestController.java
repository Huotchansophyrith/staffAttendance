//package com.staff.staffAttendance.controller.rest;
//
//import com.staff.staffAttendance.common.constant.ResponseDTO;
//import com.staff.staffAttendance.dto.UserAdDto;
//import com.staff.staffAttendance.service.UserAdService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(value = "/api/v1/user-admin")
//public class UserAdRestController {
//
//    @Autowired
//    private UserAdService userServiceI;
//
//    @GetMapping
//    public ResponseDTO findAll(){
//        return this.userServiceI.findAll();
//    }
//
//    @PostMapping
//    public ResponseDTO create(@RequestBody UserAdDto userDto){
//        return this.userServiceI.create(userDto);
//    }
//
//    @PutMapping
//    public ResponseDTO update(@RequestBody UserAdDto userDto){
//        return this.userServiceI.update(userDto);
//    }
//
//    @DeleteMapping("/delete/{adm_seq}")
//    public ResponseDTO delete(@PathVariable int adm_seq){
//        return this.userServiceI.delete(adm_seq);
//    }
//
//}
