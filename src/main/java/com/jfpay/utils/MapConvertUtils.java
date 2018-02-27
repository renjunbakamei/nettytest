package com.jfpay.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class MapConvertUtils {

	/**
	 * 将实体类转化为map
	 * @param obj 被转化的javabean
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> ConvertObjToMap(Object obj) throws Exception {
		Map<String, Object> reMap = new HashMap<String, Object>();
		if (obj == null) {
			throw new NullPointerException("obj不能为空");
		}
		Field[] fields = obj.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				Field f = obj.getClass().getDeclaredField(fields[i].getName());
				f.setAccessible(true);
				Object o = f.get(obj);
				if(o!=null) {
					reMap.put(fields[i].getName(), o);
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return reMap;
	}


	/**
	 * 将map转化为javabean
	 * @param map 被转化的map
	 * @param beanClass 转化后的javabean类型
	 * @return
	 * @throws Exception
	 */
	 public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		 if (map == null){
		 	throw new NullPointerException("map不能为空");
		 }
		 Object obj = beanClass.newInstance();

		 Field[] fields = obj.getClass().getDeclaredFields();
		 for (Field field : fields) {
			 int mod = field.getModifiers();
			 if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
				 continue;
			 }

			 field.setAccessible(true);
			 if(map.containsKey(field.getName())&&null!=map.get(field.getName())) {
				 field.set(obj, map.get(field.getName()));
			 }
		 }
		 return obj;
	 }
}
