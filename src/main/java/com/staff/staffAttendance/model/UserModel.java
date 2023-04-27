package com.staff.staffAttendance.model;

public class UserModel {
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

    public UserModel(int userSeq, String fullName, String username, String password, String userNum, int userType, int age, int gender, String email, String phone, String proImg, String proImgPath, String createDateTime, int createId, String updateDateTime, int updateId, int logCount, int posId, int brId, int departId, boolean enabled) {
        this.userSeq = userSeq;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.userNum = userNum;
        this.userType = userType;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.proImg = proImg;
        this.proImgPath = proImgPath;
        this.createDateTime = createDateTime;
        this.createId = createId;
        this.updateDateTime = updateDateTime;
        this.updateId = updateId;
        this.logCount = logCount;
        this.posId = posId;
        this.brId = brId;
        this.departId = departId;
        this.enabled = enabled;
    }

    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProImg() {
        return proImg;
    }

    public void setProImg(String proImg) {
        this.proImg = proImg;
    }

    public String getProImgPath() {
        return proImgPath;
    }

    public void setProImgPath(String proImgPath) {
        this.proImgPath = proImgPath;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public int getCreateId() {
        return createId;
    }

    public void setCreateId(int createId) {
        this.createId = createId;
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public int getUpdateId() {
        return updateId;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }

    public int getLogCount() {
        return logCount;
    }

    public void setLogCount(int logCount) {
        this.logCount = logCount;
    }

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }

    public int getBrId() {
        return brId;
    }

    public void setBrId(int brId) {
        this.brId = brId;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
