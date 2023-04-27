package com.staff.staffAttendance.controller.rest;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.dto.AdminReqLeaveDto;
import com.staff.staffAttendance.dto.UserReqLeaveDto;
import com.staff.staffAttendance.service.AdminReqLeaveService;
import com.staff.staffAttendance.service.UserReqLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/adminReqLeave")
public class AdminReqLeaveRestController {

    @Autowired
    private UserReqLeaveService userReqLeaveService;

    @Autowired
    private AdminReqLeaveService adminReqLeaveService;

    @GetMapping
    public ResponseDTO findAll(){
        return this.adminReqLeaveService.findAllReq1();
    }

    @PostMapping
    public ResponseDTO create(@RequestBody UserReqLeaveDto userReqLeaveDto){
        return this.adminReqLeaveService.create(userReqLeaveDto);
    }

    @PutMapping
    public ResponseDTO approve(@RequestBody UserReqLeaveDto userReqLeaveDto){
        return this.adminReqLeaveService.update_Approve(userReqLeaveDto);
    }

    @PutMapping(value = "refuse")
    public ResponseDTO refuse(@RequestBody UserReqLeaveDto userReqLeaveDto){
        return this.adminReqLeaveService.update_Refuse(userReqLeaveDto);
    }


}
