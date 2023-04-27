package com.staff.staffAttendance.controller.rest;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.dto.DepartmentDto;
import com.staff.staffAttendance.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentRestController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    @ResponseBody
    public ResponseDTO findAll(){
        return this.departmentService.findAll();
    }

    @PostMapping
    public ResponseDTO create(@RequestBody DepartmentDto departmentDto){
        return this.departmentService.create(departmentDto);
    }

    @PutMapping
    public ResponseDTO update(@RequestBody DepartmentDto departmentDto){
        return this.departmentService.update(departmentDto);
    }

    @DeleteMapping("/delete/{depart_seq}")
    public ResponseDTO delete(@PathVariable  int depart_seq){
        return this.departmentService.delete(depart_seq);
    }

}
