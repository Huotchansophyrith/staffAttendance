package com.staff.staffAttendance.controller;

import com.staff.staffAttendance.dto.AttnDto;
import com.staff.staffAttendance.dto.UserDto;
import com.staff.staffAttendance.mapper.AttnMapper;
import com.staff.staffAttendance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/attn")
public class AttendanceController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AttnMapper attnMapper;

    @GetMapping
    public String list(Model model){
//        model.addAttribute("currentUser", getCurrentLoginUser().getUserSeq());
        model.addAttribute("attnOpen", "menu-open");
        model.addAttribute("attnOp", "menu-open");
        model.addAttribute("lstActive", "active");
        return "layouts/attendance/list";
    }

    @GetMapping("/report-staff")
    public String reportStaff(Model model){
        model.addAttribute("RMOpen", "menu-open");
        model.addAttribute("dailyReByStaffActive", "active");
        return "layouts/attendance/report/report-by-staff";
    }

    @GetMapping("/add")
    public String create(Model model){
//        model.addAttribute("currentUserName", getCurrentLoginUser().getUsername());
        model.addAttribute("attnOpen", "menu-open");
        model.addAttribute("attnOp", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/attendance/create";
    }

    @GetMapping("/update/{attnSeq}")
    public String update(Model model, @PathVariable int attnSeq){
        AttnDto attnId = this.attnMapper.findById(attnSeq);
        model.addAttribute("attnId", attnId);
//        model.addAttribute("currentUser", getCurrentLoginUser().getUserSeq());
        model.addAttribute("action", "update");
        model.addAttribute("attnOpen", "menu-open");
        model.addAttribute("attnOp", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/attendance/create";
    }

//    private UserDto getCurrentLoginUserType() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        return this.userMapper.findByCurrentUserType(currentPrincipalName);
//    }

}
