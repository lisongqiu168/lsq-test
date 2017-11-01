package com.lsq.service.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;

public class ParamService {

	public static void main(String[] args) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		User user = new User();

		Method[] method = user.getClass().getDeclaredMethods();
		for (Method m : method) {
			Param p = m.getAnnotation(Param.class);
			if (p != null) {
				String s = (String) m.invoke(user);
				if (StringUtils.isEmpty(s)) {
					System.out.println(p.desc() + "不能为空");
				}
			}
		}
	}
}
