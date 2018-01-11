package com.lsq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    // @Autowired
    // private UserHystrixCommand command;
    @RequestMapping("/")
    public String home(HttpServletRequest request, HttpServletResponse response) {
        // return command.execute();
        return "success";
    }

}
