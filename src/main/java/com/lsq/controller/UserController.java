package com.lsq.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

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
		// String s = com.alibaba.fastjson.JSON.toJSONString(user);
		// mongoTemplate.insert(JSON.parse(s));
		// List<UserParam> list = mongoTemplate.findAll(UserParam.class);
		// for (UserParam userParam : list) {
		// System.out.println(userParam.getUserId());
		// }
		return "success";
	}

}
