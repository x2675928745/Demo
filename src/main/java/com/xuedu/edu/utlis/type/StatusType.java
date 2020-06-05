package com.xuedu.edu.utlis.type;
/**
 * 状态类型
 * @author dwen
 *	2016年1月7日 上午10:35:03
 */
public enum StatusType {
	
	STATUS_1(1,"可用"),
	
	STATUS_2(2,"不可用");
	
	public int value;
	public String desc;
	
	private StatusType(int value, String desc){
		this.value = value;
		this.desc = desc;
	}
}
