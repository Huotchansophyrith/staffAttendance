package com.staff.staffAttendance.service;

import com.staff.staffAttendance.common.constant.ResponseDTO;
import com.staff.staffAttendance.dto.BranchDto;
import org.springframework.stereotype.Service;

@Service
public interface BranchService {
     ResponseDTO findAll();
     ResponseDTO create(BranchDto branchDto);
     ResponseDTO update(BranchDto branchDto);
     ResponseDTO delete(int brSeq);
}
