package com.staff.staffAttendance.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

@Data
@Alias("attnDto")
@EqualsAndHashCode(callSuper=false)
public class AttnDto {

    private int attnSeq;
    private String userNum;
    private String attnType;
    private String attnDt;
    private String createBy;
    private String createBt;
    private String approveBy;
    private String approveDt;
    private int userId;


}
