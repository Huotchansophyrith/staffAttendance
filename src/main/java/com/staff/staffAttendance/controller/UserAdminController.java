//package com.staff.staffAttendance.controller;
//
//import com.staff.staffAttendance.dto.UserAdDto;
//import com.staff.staffAttendance.dto.UserDto;
//import com.staff.staffAttendance.mapper.UserAdMapper;
//import com.staff.staffAttendance.mapper.UserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/user-admin")
//public class UserAdminController {
//
//    @Autowired
//    private UserAdMapper userAdMapper;
//
//    @GetMapping
//    public String list(Model model){
//        model.addAttribute("teamOpen", "menu-open");
//        model.addAttribute("userAdOp", "menu-open");
//        model.addAttribute("lstActive", "active");
//        return "layouts/user-admin/list";
//    }
//
//    @GetMapping("/add")
//    public String create(Model model){
//        model.addAttribute("teamOpen", "menu-open");
//        model.addAttribute("userAdOp", "menu-open");
//        model.addAttribute("addActive", "active");
//        return "layouts/user-admin/create";
//    }
//
//    @GetMapping("/update/{adm_seq}")
//    public String update(Model model, @PathVariable int adm_seq){
//        UserAdDto adminId = this.userAdMapper.findById(adm_seq);
//        model.addAttribute("adminId", adminId);
//        model.addAttribute("action", "update");
//        model.addAttribute("teamOpen", "menu-open");
//        model.addAttribute("userAdOp", "menu-open");
//        model.addAttribute("addActive", "active");
//        return "layouts/user-admin/create";
//    }
//
//}
