package cn.byau.util;

import java.util.Map;
import java.util.UUID;



/**
 * 小小工具
 * 
 * @author
 *
 */
public class CommonUtils {

	// 管理员的权限值为01
	public static final String ADMIN_ROLE = "1";

	// 用户的权限值为02
	public static final String USER_ROlE = "2";
	
	public static boolean isContains(String containers, 
    		String[] regx) {
        for (int i = 0; i < regx.length; i++) {
            if (containers.contains(regx[i])) {
                return true;
            }
        }
        return false;
    }
	/**
	 * 返回一个不重复的字符串
	 * 
	 * @return
	 */

	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	/**
	 * 把map转换成对象
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 * 
	 * 		把Map转换成指定类型
	 */
//	@SuppressWarnings("rawtypes")
//	public static <T> T toBean(Map map, Class<T> clazz) {
//		try {
//			/*
//			 * 1. 通过参数clazz创建实例 2. 使用BeanUtils.populate把map的数据封闭到bean中
//			 */
//			T bean = clazz.newInstance();
//			ConvertUtils.register(new DateConverter(), java.util.Date.class);
//			BeanUtils.populate(bean, map);
//			return bean;
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
	//}
}
