package com.staff.staffAttendance.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

@Data
@Alias("staffDto")
@EqualsAndHashCode(callSuper=false)
public class StaffDto {

    private int staff_seq;
    private String staff_number;
    private String full_name;
    private int age;
    private int gender;
    private String email;
    private String phone;
    private String profile_img;
    private String profile_img_path;
    private int account_status;
    private int pos_id;
    private int branch_id;
    private int department_id;
    private int adm_id;
    private boolean enabled = true;

}
