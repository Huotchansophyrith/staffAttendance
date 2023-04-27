package com.staff.staffAttendance.constant;

public class Constants {
    public enum UpCodeValues {
        OS_CD, DEVC_STA_CD, ILGL_USE_TYPE_CD, USER_LOG_TYPE_CD, MDM_POLI_STA_CD,
        MDM_POLI_TYPE_CD,RESV_PROC_STA_CD, TGT_TYPE_CD, MDM_APP_TYPE_CD, TRMS_TYPE_CD,CD_TYPE_CD;
        public static final String CONST_MDM_POLI_TYEP_CD = "MDM_POLI_TYPE_CD";
        public static final String GROUP_CODE = "g";
        public static final String CODE = "c";
    }

    public static final String TGT_TYPE_CODE_DEPT = "01";
    public static final String TGT_TYPE_CODE_GRP = "02";
    public static final String TGT_TYPE_CODE_USR = "03";
    public static final String DEFAULT_POLICY = "기본 정책";
    public static final String DEFAULT_RESV_PROC_STA_CD= "01";
    public static final String YES = "Y";
    public static final String NO = "N";
    public static final String DEPARTMENT_ROOT_NAME = "전체";
    public static final String RESERVATION = "예약";

    // Device Status Code
    public static final String DV_NOT_INSTALL = "01";
    public static final String DV_POLI_ENFORC = "02";
    public static final String DV_POLI_OFF = "03";
    public static final String DV_LOST = "04";
    public static final String DV_LOST_LOCK = "05";
    public static final String DV_INIT = "06";

    public static final String API_KEY = "api-key";


}