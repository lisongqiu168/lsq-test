package com.lsq.service.annotation;

public class User {
	@ParamValidate(desc = "姓名", exception = "不能为空")
	private String name = "张三";
	@ParamValidate(desc = "年龄", exception = "必须小于100")
	private int age = 100;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
