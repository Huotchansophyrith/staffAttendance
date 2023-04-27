package com.staff.staffAttendance.controller;

import com.staff.staffAttendance.dto.LocationDto;
import com.staff.staffAttendance.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("locations")
public class GenerateQRController {

    @Autowired
    private LocationMapper locationMapper;

    @GetMapping
    public String list(Model model){
        model.addAttribute("attnOpen", "menu-open");
        model.addAttribute("genOp", "menu-open");
        model.addAttribute("lstActive", "active");
        return "layouts/generateQR/list-qr";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("attnOpen", "menu-open");
        model.addAttribute("genOp", "menu-open");
        model.addAttribute("addActive", "active");
        return "layouts/generateQR/create-qr";
    }

    @GetMapping("/update/{loc_seq}")
    public String update(Model model, @PathVariable int loc_seq){
        LocationDto locationId = this.locationMapper.findAllById(loc_seq);
        model.addAttribute("action", "update");
        model.addAttribute("attnOpen", "menu-open");
        model.addAttribute("genOp", "menu-open");
        model.addAttribute("addActive", "active");
        model.addAttribute("locationId", locationId);
        return "layouts/generateQR/create-qr";
    }

}
