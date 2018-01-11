package com.lsq.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kafka.utils.Json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsq.service.logmonitor.LogInfo;

@RestController
@RequestMapping("/user")
public class UserController {

    // @Autowired
    // private UserHystrixCommand command;

    @RequestMapping("/")
    public String home(HttpServletRequest request, HttpServletResponse response) {

        return "success";
    }

}
