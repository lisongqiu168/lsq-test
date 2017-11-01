package com.lsq.service.annotation;

public class User {

	private String name = "张三";
	private Integer age;

	@Param(desc = "姓名")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Param(desc = "年龄")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
