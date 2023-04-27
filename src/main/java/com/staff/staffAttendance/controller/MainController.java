package com.staff.staffAttendance.controller;

import com.staff.staffAttendance.dto.UserDto;
import com.staff.staffAttendance.mapper.UserMapper;
import com.staff.staffAttendance.mapper.UserReqLeaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class MainController implements ErrorController {

    private UserMapper userMapper;

    @Autowired
    private HttpSession session;

    public MainController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping({"/", "/dashboard"})
    public String dashboard(Model model, HttpServletRequest request,Principal principal) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        int userType =  this.userMapper.getUserType(currentPrincipalName);
        model.addAttribute("userType",userType);



//      userType equal zero it's mean user admin, so it's show only dashboard for admin
        if (userType == 1){
            return "user-index";
        }else{
            return "index";
        }
    }


    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

}
