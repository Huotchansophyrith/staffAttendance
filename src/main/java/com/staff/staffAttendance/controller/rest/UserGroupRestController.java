package com.staff.staffAttendance.controller.rest;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.dto.UserGroupDto;
import com.staff.staffAttendance.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users-g")
public class UserGroupRestController {
    @Autowired
    private UserGroupService userGroupService;

    @GetMapping
    public ResponseDTO findAll(){
        return this.userGroupService.findAll();
    }

    @PostMapping
    public ResponseDTO create(@RequestBody UserGroupDto userGroupDto){
        return this.userGroupService.create(userGroupDto);
    }

    @PutMapping
    public ResponseDTO update(@RequestBody UserGroupDto userGroupDto){
        return this.userGroupService.update(userGroupDto);
    }
}
