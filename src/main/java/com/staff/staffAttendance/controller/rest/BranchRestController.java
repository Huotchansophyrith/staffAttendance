package com.staff.staffAttendance.controller.rest;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.dto.BranchDto;
import com.staff.staffAttendance.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/branches")
public class BranchRestController {

    @Autowired
    private BranchService branchService;

    @GetMapping
    public ResponseDTO findAll(){
        return this.branchService.findAll();
    }

    @PostMapping
    public ResponseDTO create(@RequestBody BranchDto branchDto){
        return this.branchService.create(branchDto);
    }

    @PutMapping
    public ResponseDTO update(@RequestBody BranchDto branchDto){
        return this.branchService.update(branchDto);
    }

    @DeleteMapping("/delete/{branch_seq}")
    public ResponseDTO detete(@PathVariable int branch_seq){
        return this.branchService.delete(branch_seq);
    }

}
