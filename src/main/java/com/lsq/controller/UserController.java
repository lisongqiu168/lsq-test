package com.lsq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	// @Autowired
	// private UserHystrixCommand command;

	@RequestMapping("/info")
	public String info(HttpServletRequest request, HttpServletResponse response,
			UserParam user) {

		return "success";
		// return bindingResult.getFieldError().getDefaultMessage();
	}

}
