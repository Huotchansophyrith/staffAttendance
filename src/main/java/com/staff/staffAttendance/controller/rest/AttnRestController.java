package com.staff.staffAttendance.controller.rest;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.dto.AttnDto;
import com.staff.staffAttendance.service.AttnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/attn")
public class AttnRestController {

    @Autowired
    private AttnService attnService;

//    @GetMapping("/find-all/{adm_id}")
//    public ResponseDTO findAllByAdminId(@PathVariable int adm_id){
//        return this.attnService.findAllByAdminId(adm_id);
//    }

    @GetMapping
    public ResponseDTO findAll(){
        return this.attnService.findAll();
    }

    @PostMapping
    public ResponseDTO create(@RequestBody AttnDto attnDto){
        return this.attnService.create(attnDto);
    }

    @PutMapping
    public ResponseDTO update(@RequestBody AttnDto attnDto){
        return this.attnService.update(attnDto);
    }

}
