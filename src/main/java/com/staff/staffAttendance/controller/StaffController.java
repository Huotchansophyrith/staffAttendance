//package com.staff.staffAttendance.controller;
//
//import com.staff.staffAttendance.dto.StaffDto;
//import com.staff.staffAttendance.dto.UserAdDto;
//import com.staff.staffAttendance.dto.UserDto;
//import com.staff.staffAttendance.mapper.StaffMapper;
//import com.staff.staffAttendance.mapper.UserAdMapper;
//import com.staff.staffAttendance.mapper.UserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/staffs")
//public class StaffController {
//
//    @Autowired
//    private StaffMapper staffMapper;
//
//    @Autowired
//    private UserAdMapper userAdMapper;
//
//    @GetMapping
//    public String listView(Model model){
//        model.addAttribute("teamOpen", "menu-open");
//        model.addAttribute("stfOp", "menu-open");
//        model.addAttribute("lstActive", "active");
//        return "layouts/staff/list";
//    }
//
//    @GetMapping("/create")
//    public String create(Model model){
//        model.addAttribute("currentUser", getCurrentLoginUser().getAdm_seq());
//        model.addAttribute("teamOpen", "menu-open");
//        model.addAttribute("stfOp", "menu-open");
//        model.addAttribute("addActive", "active");
//        return "layouts/staff/create";
//    }
//
//    @GetMapping("/update/{staff_seq}")
//    public String update(Model model, @PathVariable int staff_seq){
//        StaffDto staffId = this.staffMapper.findAllById(staff_seq);
//        Map<String,Object> allName = this.staffMapper.findBrDepartPosByStaffId(staff_seq);
//        model.addAttribute("currentUser", getCurrentLoginUser().getAdm_seq());
//        model.addAttribute("staffId", staffId);
//        model.addAttribute("allName", allName);
//        model.addAttribute("action", "update");
////        model.addAttribute("currentUser", getCurrentLoginUser().getUsername());
//        model.addAttribute("teamOpen", "menu-open");
//        model.addAttribute("stfOp", "menu-open");
//        model.addAttribute("addActive", "active");
//        return "layouts/staff/create";
//    }
//
//    private UserAdDto getCurrentLoginUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        return this.userAdMapper.findByCurrentUsername(currentPrincipalName);
//    }
//
//}
