package com.lsq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	// @Autowired
	// private UserHystrixCommand command;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping("/info")
	public String info(HttpServletRequest request, HttpServletResponse response,
			UserParam user) {
		// kafka
		ListenableFuture<SendResult<String, String>> r = kafkaTemplate
				.sendDefault("test_value");
//		String s = com.alibaba.fastjson.JSON.toJSONString(user);
//		mongoTemplate.insert(
//				com.alibaba.fastjson.JSON.parseObject(s, UserParam.class));
		// List<UserParam> list = mongoTemplate.findAll(UserParam.class);
		// for (UserParam userParam : list) {
		// System.out.println(userParam.getUserId());
		// }
		return "success";
	}

}
