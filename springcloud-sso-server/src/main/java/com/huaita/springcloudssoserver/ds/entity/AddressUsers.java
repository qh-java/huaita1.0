package com.huaita.springcloudssoserver.ds.entity;

import java.util.Date;

public class AddressUsers extends Entity {
    // 主键
    private String id;
    // 通讯录编码
    private String bookId;
    // 人员id
    private String userId;
    // 人员类型
    private String userType;
    // 人员电话
    private String userPhone;
    // 手机
    private String userMobilePhone;
    // 邮箱
    private String userEmail;
    // 传真
    private String userFox;
    // 排序
    private String bookSort;
    // 创建者
    private String createUser;
    // 创建时间
    private Date createTime;
    // 人员姓名
    private String userName;
    // 组内职务
    private String groupDuty;
    // 部门
    private String deptCode;
    // 部门名称
    private String deptName;
    // 部门职位
    private String deptDuty;
    private String deptDutyName;
    // 备注
    private String remark;

    public AddressUsers(String id, String bookId, String userId, String userType, String userPhone, String userMobilePhone, String userEmail, String userFox, String bookSort, String createUser, Date createTime, String userName, String groupDuty, String deptCode, String deptName, String deptDuty, String deptDutyName, String remark) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.userType = userType;
        this.userPhone = userPhone;
        this.userMobilePhone = userMobilePhone;
        this.userEmail = userEmail;
        this.userFox = userFox;
        this.bookSort = bookSort;
        this.createUser = createUser;
        this.createTime = createTime;
        this.userName = userName;
        this.groupDuty = groupDuty;
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.deptDuty = deptDuty;
        this.deptDutyName = deptDutyName;
        this.remark = remark;
    }

    public AddressUsers() {
    }

    public String getDeptDutyName() {
        return deptDutyName;
    }

    public void setDeptDutyName(String deptDutyName) {
        this.deptDutyName = deptDutyName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserMobilePhone() {
        return userMobilePhone;
    }

    public void setUserMobilePhone(String userMobilePhone) {
        this.userMobilePhone = userMobilePhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFox() {
        return userFox;
    }

    public void setUserFox(String userFox) {
        this.userFox = userFox;
    }

    public String getBookSort() {
        return bookSort;
    }

    public void setBookSort(String bookSort) {
        this.bookSort = bookSort;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGroupDuty() {
        return groupDuty;
    }

    public void setGroupDuty(String groupDuty) {
        this.groupDuty = groupDuty;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptDuty() {
        return deptDuty;
    }

    public void setDeptDuty(String deptDuty) {
        this.deptDuty = deptDuty;
    }

}
