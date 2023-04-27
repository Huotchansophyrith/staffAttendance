package com.staff.staffAttendance.controller;

import com.staff.staffAttendance.dto.BranchDto;
import com.staff.staffAttendance.mapper.BranchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("branches")
public class BranchController {

    @Autowired
    private BranchMapper branchMapper;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("branchOp", "menu-open");
        model.addAttribute("lstActive", "active");
        return "layouts/branch/lists";
    }
    
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("branchOp", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/branch/create";
    }


    @GetMapping("/update/{brSeq}")
    public String update(Model model, @PathVariable int brSeq){
        BranchDto branchId = this.branchMapper.findAllById(brSeq);
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("branchOp", "menu-open");
        model.addAttribute("addActive", "active");
        model.addAttribute("action", "update");
        model.addAttribute("branchId", branchId);
        return "layouts/branch/create";
    }

}
