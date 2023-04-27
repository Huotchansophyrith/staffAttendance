package com.staff.staffAttendance.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("userReqLeaveDto")
public class UserReqLeaveDto {

    private int reqLeaveSeq;
    private String typeLeave;
    private String status;
    private String startDate;
    private String endDate;
    private int userId;
    private String reason;
    private boolean enabled = true;

    private String userIdNm;
}

