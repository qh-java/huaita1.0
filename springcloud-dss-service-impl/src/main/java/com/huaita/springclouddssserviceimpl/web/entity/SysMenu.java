package com.huaita.springclouddssserviceimpl.web.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMenu  {
    private String menuCode;// 菜单编码
    private String menuName;// 菜单名称
    private int menuOrder;// 菜单排序
    private String menuIcon;// 菜单图标
    private String parentMenuCode;// 父级菜单编码
    private String menuLink;// 菜单链接
    private String createUser;// 创建用户
    private Date createDate;// 创建时间
    private String parentMenuName;// 父级菜单名称
    private boolean hasViewPower;
    private String menuMethods;// 菜单方法
    private String menuDesc;// 菜单说明
    private String systemCode;// 系统编码
    private String systemName;// 子系统名称

    private List<SysMenu> rows = new ArrayList<SysMenu>();

    private List<SysFun> funs = new ArrayList<SysFun>();

    public String getMenuDesc() {
        return this.menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuMethods() {
        return this.menuMethods;
    }

    public void setMenuMethods(String menuMethods) {
        this.menuMethods = menuMethods;
    }

    public String getParentMenuName() {
        return this.parentMenuName;
    }

    public void setParentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName;
    }

    public boolean isHasViewPower() {
        return this.hasViewPower;
    }

    public void setHasViewPower(boolean hasViewPower) {
        this.hasViewPower = hasViewPower;
    }

    public String getMenuCode() {
        return this.menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuOrder() {
        return this.menuOrder;
    }

    public void setMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getMenuIcon() {
        return this.menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getParentMenuCode() {
        return this.parentMenuCode;
    }

    public void setParentMenuCode(String parentMenuCode) {
        this.parentMenuCode = parentMenuCode;
    }

    public String getMenuLink() {
        return this.menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink;
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

    public List<SysMenu> getRows() {
        return this.rows;
    }

    public void setRows(List<SysMenu> rows) {
        this.rows = rows;
    }

    public List<SysFun> getFuns() {
        return this.funs;
    }

    public void setFuns(List<SysFun> funs) {
        this.funs = funs;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public String toString() {
        return "SysMenu [menuCode=" + menuCode + ", menuName=" + menuName + ", menuOrder=" + menuOrder + ", menuIcon=" + menuIcon + ", parentMenuCode=" + parentMenuCode + ", menuLink=" + menuLink
                + ", createUser=" + createUser + ", createDate=" + createDate + ", parentMenuName=" + parentMenuName + ", hasViewPower=" + hasViewPower + ", menuMethods=" + menuMethods + ", menuDesc="
                + menuDesc + ", systemCode=" + systemCode + ", rows=" + rows + ", funs=" + funs + "]";
    }

}
