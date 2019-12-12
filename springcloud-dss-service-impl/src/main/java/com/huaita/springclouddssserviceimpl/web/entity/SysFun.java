package com.huaita.springclouddssserviceimpl.web.entity;


import java.io.Serializable;

public class SysFun  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String funCode;// 功能编码
    private String menuCode;// 菜单编码
    private String funName;// 功能名称
    private String funOrder;// 功能排序
    private String funMethods;// 功能方法
    private boolean checked;

    public String getFunCode() {
        return this.funCode;
    }

    public void setFunCode(String funCode) {
        this.funCode = funCode;
    }

    public String getMenuCode() {
        return this.menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getFunName() {
        return this.funName;
    }

    public void setFunName(String funName) {
        this.funName = funName;
    }

    public String getFunOrder() {
        return this.funOrder;
    }

    public void setFunOrder(String funOrder) {
        this.funOrder = funOrder;
    }

    public String getFunMethods() {
        return this.funMethods;
    }

    public void setFunMethods(String funMethods) {
        this.funMethods = funMethods;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
