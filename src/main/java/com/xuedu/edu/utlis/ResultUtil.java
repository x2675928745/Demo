package com.xuedu.edu.utlis;


import com.xuedu.edu.utlis.type.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 返回结果类
 * @author dwen
 * @date 2020年3月15日上午11:14:15
 * @version v1.0
 */
public class ResultUtil {

	/**
	 * 返回json字符串
	 * 
	 * @param data
	 *            数据体
	 * @param status
	 *            状态码
	 * @param message
	 *            状态描述
	 * @return
	 */
	public static String toJSON(Object data, String status, String message) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", data);
		resultMap.put("status", status);
		resultMap.put("message", message);
		return JSONUtils.toJSONString(resultMap);
	}
	
	/**
	 * 返回json字符串
	 * @param data
	 * @param result 结果集枚举
	 * @return
	 */
	public static String toJSON(Object data, Result result){
		return toJSON(data, result.key, result.value);
	}
	
	/**
	 * 返回json字符串
	 * @param result 结果集枚举
	 * @return
	 */
	public static String toJSON(Result result){
		return toJSON(null, result.key, result.value);
	}

	public static String OK(Object data) {
		return toJSON(data, Result.OK.key, Result.OK.value);
	}

	public static String OK() {
		return toJSON(null, Result.OK.key, Result.OK.value);
	}

	public static String ERROR() {
		return toJSON(null, Result.ERVER_ERROR.key, Result.ERVER_ERROR.value);
	}
	
	public static String OP_ERROR() {
		return toJSON(null, Result.OP_ERROR.key, Result.OP_ERROR.value);
	}
	
	public static String PARAM_ERROR() {
		return toJSON(null, Result.PARAMS_ERROR.key, Result.PARAMS_ERROR.value);
	}
	
	public static String ADMINS_ERROR() {
		return toJSON(null, Result.ADMINS_ERROR.key, Result.ADMINS_ERROR.value);
	}
	
	public static String PHONE_ERROR() {
		return toJSON(null, Result.PHONE_ERROR.key, Result.PHONE_ERROR.value);
	}
	
	public static String PWD_NO_SAME_ERROR() {
		return toJSON(null, Result.PWD_NO_SAME_ERROR.key, Result.PWD_NO_SAME_ERROR.value);
	}
	
}
