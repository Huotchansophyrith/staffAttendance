package com.staff.staffAttendance.controller.rest;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.dto.UserDto;
import com.staff.staffAttendance.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserRestController {

    @Autowired
    private UserServiceI userServiceI;

    @GetMapping
    public ResponseDTO findAll(){
        return this.userServiceI.findAll();
    }

    //    for login to client app
    @PostMapping("/username_pass")
    public Map<String, Object> findUserByUsernameAndPassword(@RequestBody Map<String,Object> params){
        String username = params.get("username").toString();
        String password = params.get("password").toString();
        return this.userServiceI.findUserByUsernameAndPassword(username,password);
    }

    @PostMapping
    public ResponseDTO create(@RequestBody UserDto userDto){
        return this.userServiceI.create(userDto);
    }

    @PutMapping
    public ResponseDTO update(@RequestBody UserDto userDto){
        return this.userServiceI.update(userDto);
    }

    @DeleteMapping("/delete/{userSeq}")
    public ResponseDTO delete(@PathVariable int userSeq){
        return this.userServiceI.delete(userSeq);
    }

}
