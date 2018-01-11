package com.lsq.service.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ParamService {

	public static void main(String[] args) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		User user = new User();
		user.setAge(1);

		Field[] fields = user.getClass().getDeclaredFields();
		for (Field f : fields) {
			ParamValidate p = f.getAnnotation(ParamValidate.class);
			if (p == null) {
				continue;
			}
			f.setAccessible(true);
			System.out.println(f.getType().getSimpleName());
			System.out.println(f.getName());
			Object o = f.get(user);
			if (o == null) {
				System.out.println(p.desc() + p.exception());
			}
			if (o instanceof Integer) {
				Integer age = (Integer) o;
				if (age >= 100) {
					System.out.println(p.desc() + p.exception());
				}
			}
		}
	}
}
