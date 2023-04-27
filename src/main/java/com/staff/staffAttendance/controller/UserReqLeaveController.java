package com.staff.staffAttendance.controller;

import com.staff.staffAttendance.mapper.UserMapper;
import com.staff.staffAttendance.mapper.UserReqLeaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userReqLeave")
public class UserReqLeaveController {
    @Autowired
    private UserReqLeaveMapper userReqLeaveMapper;


    private UserMapper userMapper;

    public UserReqLeaveController(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    @GetMapping("/reqLeaveList")
    public String list(Model model){

        model.addAttribute("leaveOpen", "menu-open");
        model.addAttribute("listActive", "active");
        return "layouts/user-leave/list";

    }
    @GetMapping("/userReqLeave")
    public String reqLeave(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        model.addAttribute("username", currentPrincipalName);
        model.addAttribute("leaveOpen", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/user-leave/create-update";
    }



//    private UserAdDto getCurrentLoginUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        return this.userMapper.findByCurrentUsername(currentPrincipalName);
//    }



}
