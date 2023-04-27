package com.staff.staffAttendance.controller;

import com.staff.staffAttendance.mapper.AdminReqLeaveMapper;
import com.staff.staffAttendance.mapper.UserMapper;
import com.staff.staffAttendance.mapper.UserReqLeaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/adminReqLeave")
public class AdminReqLeaveController {

    @Autowired
    private AdminReqLeaveMapper adminReqLeaveMapper;

    @Autowired
    private UserReqLeaveMapper userReqLeaveMapper;

    private UserMapper userMapper;

    public AdminReqLeaveController(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    @GetMapping("/add")
    public String adminReqLeave(Model model){
        model.addAttribute("leaveOpen", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/admin-leave/create-update";
    }

    @GetMapping("/list")
    public String adminLeaveList(Model model){

        model.addAttribute("leaveOpen", "menu-open");
        model.addAttribute("listActive", "active");
        return "layouts/admin-leave/list";
    }

}
