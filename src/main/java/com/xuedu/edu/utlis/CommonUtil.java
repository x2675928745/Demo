package com.xuedu.edu.utlis;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;


/**
 * 通用工具类
 * 
 * @author dwen
 * @date 2020年3月15日上午11:20:51
 * @version v1.0
 */
@Component
public class CommonUtil {
	
	
	/**
	 * 默认首页
	 * @param pageIndexStr
	 * @return
	 */
	public static int checkPageIndex(String pageIndexStr) {
		int pageIndex = 1;
		if (StringUtils.isNotBlank(pageIndexStr)) {
			try {
				pageIndex = Integer.parseInt(pageIndexStr);
				if (pageIndex < 1) {
					pageIndex = 1;
				}
			} catch (Exception e) {
				pageIndex = 1;
			}
		}
		return pageIndex;
	}
	
	public static int getPageOffset(int pageIndex){
		if (pageIndex<=0) {
			return 0;
		}
		return (pageIndex - 1) * Constants.PAGE_NUM;
	}
	
	
	/**
	 * 获取分页数
	 * @param pageIndex 页码数
	 * @param pageNum 每页数量
	 * @return
	 */
	public static int getPageOffset2(int pageIndex,int pageNum){
		return (pageIndex - 1) * pageNum;
	}
	
	public static int getPageOffset(int cursor,int pageIndex){
		if(pageIndex == 1){
			return 0;
		}else{
			return cursor + (pageIndex - 2) * Constants.PAGE_NUM;
		}
	}
	
	public static String generateUUIDString() {
		return UUID.randomUUID().toString();
	}

	public static String getRandomNumber(int digCount) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(digCount);
		for (int i = 0; i < digCount; i++)
			sb.append((char) ('0' + rnd.nextInt(10)));
		return sb.toString();
	}

	final static String[] PHONENUMBER_PREFIX = { "130", "131", "132", "145", "155", "156", "185", "186", "134", "135",
			"136", "137", "138", "139", "147", "150", "151", "152", "157", "158", "159", "182", "183", "187", "188",
			"133", "153", "189", "180" ,"181","177","176","172","173","175","178","179"};

	/**
	 * 匹配手机号码
	 * <p>
	 * 新联通</br> （中国联通+中国网通）手机号码开头数字 130,131,132,145,155,156,185,186</br> 新移动</br> 　（中国移动+中国铁通）手机号码开头数字</br>
	 * 134,135,136,137,138,139,147,150,151,152,157,158,159,182,183,187,188</br> 新电信</br> 　（中国电信+中国卫通）手机号码开头数字
	 * 133,153,189,180</br>
	 * </p>
	 * 
	 * @param 手机号码
	 * @return 参数为null和不合法时返回false，否则返回true
	 */
	public static boolean patternPhoneNumber(String number) {
		int len = PHONENUMBER_PREFIX.length;
		if (number != null) {
			for (int i = 0; i < len; i++) {
				Pattern p = Pattern.compile(PHONENUMBER_PREFIX[i] + "\\d{8}");
				if (p.matcher(number).matches()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 验证手机号
	 * @param mobileNo
	 * @return
	 */
	public static boolean patternPhoneNo(String mobileNo) {
		Pattern p = Pattern.compile("^1\\d{10}$");
		if (p.matcher(mobileNo).matches()) {
			return true;
		}
		return false;
	}


	/**
	 * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0
	 * @param version1
	 * @param version2
	 * @return
	 */
	public static int compareVersion(String version1, String version2) throws Exception {
	    if (version1 == null || version2 == null) {
	        throw new Exception("compareVersion error:illegal params.");
	    }
	    String[] versionArray1 = version1.split("\\.");//注意此处为正则匹配，不能用.；
	    String[] versionArray2 = version2.split("\\.");
	    int idx = 0;
	    int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值
	    int diff = 0;
	    while (idx < minLength
	            && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
	            && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符
	        ++idx;
	    }
	    //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
	    diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
	    return diff;
	}

	

	/**
	 * 取得用户的 IP 地址.
	 *
	 * @param request WEB 请求
	 * @return
	 */
	public static String getUserIP(HttpServletRequest request) {
		String ipaddress = request.getHeader("X-Real-IP");
		if (ipaddress == null) {
			ipaddress = request.getHeader("X-Forwarded-For");
		}
		if (ipaddress == null) {
			ipaddress = request.getRemoteAddr();
		} else {
			int index = ipaddress.indexOf(',');
			if (index != -1) {
				ipaddress = ipaddress.substring(0, index);
			}
		}
		return ipaddress;
	}

	public static int getVersionNumber(String version){
		if(StringUtils.isNotBlank(version)){
			String versionString = version.replace(".","");
			return Integer.parseInt(versionString);
		}else{
			return 0;
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
//			System.out.println(compareVersion("1.0.9", "1.0.8"));
			String token = CommonUtil.generateUUIDString();
			System.out.println(token);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
