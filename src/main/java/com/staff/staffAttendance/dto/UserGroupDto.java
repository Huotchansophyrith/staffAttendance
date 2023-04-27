package com.staff.staffAttendance.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

@Data
@Alias("userGDto")
@EqualsAndHashCode(callSuper=false)

public class UserGroupDto {
    private int gSeq;
    private int managerId;
    private int memberId;
    private int userId;

}
