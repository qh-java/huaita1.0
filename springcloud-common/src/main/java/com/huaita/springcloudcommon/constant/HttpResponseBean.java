package com.huaita.springcloudcommon.constant;

import java.io.Serializable;

public class HttpResponseBean implements Serializable{

	private static final long serialVersionUID = -7390874139958657637L;
	
	private String resFlag;	// 状态表示 Y:成功	N：失败
	private int resCode;	// 状态码
	private String resMsg;	// 状态描述
	private Object data;	// 返回数据
	public String getResFlag() {
		return resFlag;
	}
	public void setResFlag(String resFlag) {
		this.resFlag = resFlag;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getResCode() {
		return resCode;
	}
	public void setResCode(int resCode) {
		this.resCode = resCode;
	}
	
}
