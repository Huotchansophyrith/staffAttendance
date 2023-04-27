package com.staff.staffAttendance.controller.rest;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.dto.UserReqLeaveDto;
import com.staff.staffAttendance.service.UserReqLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/v1/userReqLeave")
public class UserReqLeaveRestController {

    @Autowired
    private UserReqLeaveService userReqLeaveService;


    @GetMapping
    public ResponseDTO findAll(Principal principal){
        return this.userReqLeaveService.findAll(principal);
    }

    @PostMapping
    public ResponseDTO create(@RequestBody UserReqLeaveDto userReqLeaveDto){
        return this.userReqLeaveService.create(userReqLeaveDto);
    }

    @PutMapping
    public ResponseDTO update(@RequestBody UserReqLeaveDto userReqLeaveDto){
        return this.userReqLeaveService.update(userReqLeaveDto);
    }


}

