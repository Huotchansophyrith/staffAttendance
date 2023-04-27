package com.staff.staffAttendance.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

@Data
@Alias("departDto")
@EqualsAndHashCode(callSuper=false)
public class DepartmentDto {

    private int departSeq;
    private String short_name;
    private String name;
    private String description;
    private int brId;
    private boolean enabled = true;

}


