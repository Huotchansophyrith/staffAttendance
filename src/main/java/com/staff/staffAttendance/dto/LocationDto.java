package com.staff.staffAttendance.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

@Data
@Alias("locationDto")
@EqualsAndHashCode(callSuper=false)
public class LocationDto {

    private int locSeq;
    private String name;
    private String latitude;
    private String longitude;
    private int brId;
    private boolean enabled = true;

}
