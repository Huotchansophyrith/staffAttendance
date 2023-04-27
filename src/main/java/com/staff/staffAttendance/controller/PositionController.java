package com.staff.staffAttendance.controller;

import com.staff.staffAttendance.dto.PositionDto;
import com.staff.staffAttendance.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("positions")
public class PositionController {

    @Autowired
    private PositionMapper positionMapper;

    @GetMapping()
    public String list(Model model){
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("posOp", "menu-open");
        model.addAttribute("lstActive", "active");
        return "layouts/position/lists";
    }
    
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("posOp", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/position/create";
    }

    @GetMapping("/update/{posSeq}")
    public String update(Model model, @PathVariable int posSeq){
        PositionDto posId = this.positionMapper.findAllById(posSeq);
        model.addAttribute("posId", posId);
        model.addAttribute("action", "update");
        model.addAttribute("teamOpen", "menu-open");
        model.addAttribute("posOp", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/position/create";
    }


}
