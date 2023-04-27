package com.staff.staffAttendance.controller.rest;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.dto.PositionDto;
import com.staff.staffAttendance.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/positions")
public class PositionRestController {

    @Autowired
    private PositionService positionService;

    @GetMapping
    public ResponseDTO findAll(){
        return this.positionService.findAll();
    }

    @PostMapping
    public ResponseDTO create(@RequestBody PositionDto positionDto){
        return this.positionService.create(positionDto);
    }

    @PutMapping
    public ResponseDTO update(@RequestBody PositionDto positionDto){
        return this.positionService.update(positionDto);
    }

    @DeleteMapping("/delete/{pos_seq}")
    public ResponseDTO detete(@PathVariable int pos_seq){
        return this.positionService.delete(pos_seq);
    }

}
