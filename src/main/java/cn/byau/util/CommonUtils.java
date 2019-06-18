package cn.byau.util;

import java.util.UUID;



/**
 * 小小工具
 * 
 * @author
 *
 */
public class CommonUtils {

	// 管理员的权限值为1
	public static final String ADMIN_ROLE = "1";

	// 用户的权限值为2
	public static final String USER_ROlE = "2";
	
	
	/**
	 * 返回一个不重复的字符串
	 * 
	 * @return
	 */

	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	
}
