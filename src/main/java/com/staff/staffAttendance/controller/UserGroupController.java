package com.staff.staffAttendance.controller;

import com.staff.staffAttendance.dto.UserDto;
import com.staff.staffAttendance.dto.UserGroupDto;
import com.staff.staffAttendance.mapper.UserGMapper;
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
@RequestMapping("/users-g")
public class    UserGroupController {
    @Autowired
    private UserGMapper userGMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public String list(Model model){
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("userGOp", "menu-open");
        model.addAttribute("lstActive", "active");
        return "layouts/user-group/list";
    }

    @GetMapping("/add")
    public String create(Model model){
        model.addAttribute("currentUser",getCurrentUser().getUserSeq());
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("userGOp", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/user-group/create";
    }

    @GetMapping("/update/{gSeq}")
    public String update(Model model, @PathVariable int gSeq){
        UserGroupDto userId = this.userGMapper.findById(gSeq);

        model.addAttribute("userId", userId);
        model.addAttribute("action", "update");
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("userGOp", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/user-group/create";
    }

    private UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return this.userMapper.getCurrentUserLogin(currentPrincipalName);
    }

}
