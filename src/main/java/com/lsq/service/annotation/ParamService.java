package com.lsq.service.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.StringUtils;

public class ParamService {

	public static void main(String[] args) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		User user = new User();

		Field[] fields = user.getClass().getDeclaredFields();
		for (Field f : fields) {
			Param p = f.getAnnotation(Param.class);
			if (p != null) {
				f.setAccessible(true);
				String s = (String) f.get(user);
				if (StringUtils.isEmpty(s)) {
					System.out.println(p.desc() + "不能为空");
				}
			}
		}
	}
}
