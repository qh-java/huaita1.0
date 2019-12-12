package com.huaita.springcloudssoserver.ds.constants;

/**
 * 接口响应返回的描述以及状态码的枚举类
 * 
 * @author lufan
 *	@date 2019-03-27
 */
public enum ResultMenu {
	SUCCESS_CODE("操作成功", 10000), 
	ERROR_CODE("操作失败", 99999),
	REQUEST_ERROR("请求异常，请联系管理员", 99998),
	NO_LOGIN("尚未登录", 20001), 
	PARAM_ERROR("请求参数有误", 20002),  
	ROLE_ERROR("当前请求无权限", 20003),
	LOGIN_PARAM_ERROR("用户名或密码错误", 20004),
	LOGIN_FREEZE_ERROR("该用户已被冻结", 20005),
	LOGIN_FAIL("登录失败", 20006),
	SHORT_MSG_SUCCESS("发送成功",10000),
    SHORT_MSG_ERROR("发送失败",99999);
	
    // 成员变量  
    private String msg;  
    private int code; 
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	// 构造方法  
    private ResultMenu(String msg, int code) {  
        this.msg = msg;  
        this.code = code;  
    }  
    //覆盖方法  
    @Override  
    public String toString() {  
        return this.msg+"_"+this.code;  
    } 
    
}
