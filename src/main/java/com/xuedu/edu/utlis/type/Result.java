package com.xuedu.edu.utlis.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回码key-value
 * @author dwen
 * 2018年5月21日下午2:52:20
 */
public enum Result {

	/**请求成功*/
	OK("200", "请求成功"),
	/** 服务器异常*/
	ERVER_ERROR("500", "服务器异常"),
	/** 操作失败*/
	OP_ERROR("501", "操作失败"),
	TOKEN_ERROR("502", "token失败"),
	/** 参数列表错误 */
	PARAMS_ERROR("400", "参数列表错误"),
	/** 参数列表错误 */
	NO_FOUND_PAGE("404", "找不到页面"),
	
	/** 用户账户或密码错误 */
	ADMINS_ERROR("1000", "请输入正确的账号和密码"),
	
	/** 手机号不合法 */
	PHONE_ERROR("1001", "手机号不合法"),
	
	/** 参数列表错误 */
	PWD_NO_SAME_ERROR("1002", "重复密码不一致");

	public String key;

	public String value;

	private Result(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return super.toString() + "(" + key + "," + value + ")";
	}

	public static Map<String, String> getMap() {
		Map<String, String> commonEnumMap = new HashMap<String, String>();
		for (Result s : Result.values()) {
			commonEnumMap.put(s.key, s.value);
		}
		return commonEnumMap;
	}

}
