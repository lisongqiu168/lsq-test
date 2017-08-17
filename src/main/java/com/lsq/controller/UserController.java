package com.lsq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsq.service.hystrix.UserHystrixCommand;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserHystrixCommand command;
	@RequestMapping("/")
	String home() {
		return command.execute();
	}

}
