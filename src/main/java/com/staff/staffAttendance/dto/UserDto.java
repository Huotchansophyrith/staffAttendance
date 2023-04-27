package com.staff.staffAttendance.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("userDto")
public class UserDto {
    private int userSeq;
    private String fullName;
    private String username;
    private String password;
    private String userNum;
    private int userType;
    private int age;
    private int gender;
    private String email;
    private String phone;
    private String proImg;
    private String proImgPath;
    private String createDateTime;
    private int createId;
    private String updateDateTime;
    private int updateId;
    private int logCount;
    private int posId;
    private int brId;
    private int departId;
    private boolean enabled;
}
