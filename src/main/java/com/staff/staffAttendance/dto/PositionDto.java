package com.staff.staffAttendance.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

@Data
@Alias("posDto")
@EqualsAndHashCode(callSuper=false)
public class PositionDto {

    private int posSeq;
    private String posName;
    private String description;
    private boolean enabled = true;

}
