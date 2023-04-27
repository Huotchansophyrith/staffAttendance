package com.staff.staffAttendance.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("userAdDto")
public class UserAdDto {
    private int adm_seq;
    private String full_name;
    private String username;
    private String password;
    private Date create_at;
    private Date update_at;
    private int login_count;
    private Boolean enabled =true;
}
