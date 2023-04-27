package com.staff.staffAttendance.common.constant;

public enum Status {
    SUCCESS("SUCCESS"), EXIST("EXIST"), NOT_FOUND("NOT FOUND"), FAILED("FAILED"), ERROR("ERROR");

    private String value;

    private Status(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
