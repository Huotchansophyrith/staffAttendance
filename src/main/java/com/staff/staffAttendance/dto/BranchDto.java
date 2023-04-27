package com.staff.staffAttendance.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

@Data
@Alias("branchDto")
@EqualsAndHashCode(callSuper=false)
public class BranchDto {

    private int brSeq;
    private String name;
    private String address;
    private String description;
    private boolean enabled = true;
}
