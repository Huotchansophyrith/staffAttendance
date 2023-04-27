package com.staff.staffAttendance.controller;

import com.staff.staffAttendance.dto.DepartmentDto;
import com.staff.staffAttendance.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("departments")
public class DepartmentController {
    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping
    public String list(Model model){
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("departOp", "menu-open");
        model.addAttribute("lstActive", "active");
        return "layouts/department/lists";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("departOp", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/department/create";
    }

    @GetMapping("/update/{departSeq}")
    public String update(Model model, @PathVariable int departSeq){
        DepartmentDto departId = this.departmentMapper.findAllById(departSeq);
        Map<String,Object> BranchName = this.departmentMapper.findBranchNameByDepartId(departSeq);
        model.addAttribute("departId", departId);
        model.addAttribute("BranchName", BranchName);
        model.addAttribute("action", "update");
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("departOp", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/department/create";
    }


}
