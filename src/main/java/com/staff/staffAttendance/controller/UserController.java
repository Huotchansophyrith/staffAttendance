package com.staff.staffAttendance.controller;

import com.staff.staffAttendance.dto.UserDto;
import com.staff.staffAttendance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public String list(Model model){
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("userOp", "menu-open");
        model.addAttribute("lstActive", "active");
        return "layouts/user/list";
    }

    @GetMapping("/add")
    public String create(Model model){
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("userOp", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/user/create";
    }

    @GetMapping("/update/{userSeq}")
    public String update(Model model, @PathVariable int userSeq){
        UserDto userId = this.userMapper.findById(userSeq);
        Map<String,Object> findNameAll = this.userMapper.findBrDepartPosByUserId(userSeq);
        model.addAttribute("userId", userId);
        model.addAttribute("findNameAll", findNameAll);
        model.addAttribute("action", "update");
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("userOp", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/user/create";
    }


//    private UserDto getCurrentLoginUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        return this.userMapper.findByCurrentUsername(currentPrincipalName);
//    }

}
