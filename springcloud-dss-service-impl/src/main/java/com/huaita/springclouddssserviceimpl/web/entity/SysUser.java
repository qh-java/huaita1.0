package com.huaita.springclouddssserviceimpl.web.entity;


import java.io.Serializable;
import java.util.Date;

public class SysUser  implements Serializable {

    public static final long serialVersionUID = 42L;
    public static final String USER_STATE_NORMAL = "normal"; // 用户正常状态
    public static final String USER_STATE_FREEZE = "freeze"; // 用户冻结状态
    public static final String INITIAL_PASSWORD = "123456"; // 初始密码
    private String userCode; // 用户编码
    private String userName; // 用户名
    private String userPassword; // 密码
    private String userDeptCode; // 用户部门编码
    private String userAreaId; // 用户区域编码
    private String userPhone; // 用户手机号
    private String userSex; // 用户性别
    private String extendFirst;
    private String extendSecond;
    private String extendThird;
    private String createUser; // 创建者
    private Date createDate; // 创建时间
    private String deptName; // 部门名称
    private String deptShowCode; // 部门展示编码
    private String userState; // 用户状态
    private String roleCode; // 角色编码
    private String roleName; // 角色名称
    private String officePhone; // 办公电话
    private String userFox; // 用户邮件

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getPdeptCode() {
        return pdeptCode;
    }

    public void setPdeptCode(String pdeptCode) {
        this.pdeptCode = pdeptCode;
    }

    private String idCardNum; // 身份证号
    private Date takeDate; // 操作时间
    private String remark; // 备注
    private String pdeptCode;
    private String token;// 登录token
    private String addressUserId;

    public String getAddressUserId() {
        return addressUserId;
    }

    public void setAddressUserId(String addressUserId) {
        this.addressUserId = addressUserId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public String getUserAreaId() {
        return this.userAreaId;
    }

    public void setUserAreaId(String userAreaId) {
        this.userAreaId = userAreaId;
    }

    public String getOfficePhone() {
        return this.officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getUserFox() {
        return this.userFox;
    }

    public void setUserFox(String userFox) {
        this.userFox = userFox;
    }

    public String getIdCardNum() {
        return this.idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public Date getTakeDate() {
        return this.takeDate;
    }

    public void setTakeDate(Date takeDate) {
        this.takeDate = takeDate;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRoleCode() {
        return this.roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getUserState() {
        return this.userState;
    }

//    public String getUserStateStr() {
//        return CacheHelper.getInstance().getDicValueText("user.state", this.userState);
//    }
//
//    public void setUserState(String userState) {
//        this.userState = userState;
//    }

    public String getUserCode() {
        return this.userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserDeptCode() {
        return this.userDeptCode;
    }

    public void setUserDeptCode(String userDeptCode) {
        this.userDeptCode = userDeptCode;
    }

    public String getUserPhone() {
        return this.userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserSex() {
        return this.userSex;
    }

//    public String getUserSexStr() {
//        return CacheHelper.getInstance().getDicValueText("sex", this.userSex);
//    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getExtendFirst() {
        return this.extendFirst;
    }

    public void setExtendFirst(String extendFirst) {
        this.extendFirst = extendFirst;
    }

    public String getExtendSecond() {
        return this.extendSecond;
    }

//    public String getExtendSecondStr() {
//        if (StringUtil.isNotBlank(this.extendSecond)) {
//            return CacheHelper.getInstance().getDicValueText("duty", this.extendSecond);
//        }
//
//        return "";
//    }

    public void setExtendSecond(String extendSecond) {
        this.extendSecond = extendSecond;
    }

    public String getExtendThird() {
        return this.extendThird;
    }

    public void setExtendThird(String extendThird) {
        this.extendThird = extendThird;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptShowCode() {
        return this.deptShowCode;
    }

    public void setDeptShowCode(String deptShowCode) {
        this.deptShowCode = deptShowCode;
    }
}
