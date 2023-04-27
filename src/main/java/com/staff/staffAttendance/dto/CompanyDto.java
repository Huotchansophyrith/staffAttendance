package com.staff.staffAttendance.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

@Data
@Alias("companyDto")
@EqualsAndHashCode(callSuper=false)
public class CompanyDto {

    private int company_seq;
    private String company_name;
    private String company_short_name;
    private String description;
    private int branch_id;
    private int adm_id;
    private boolean enabled = true;

}
