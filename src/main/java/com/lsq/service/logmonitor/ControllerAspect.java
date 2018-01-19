package com.lsq.service.logmonitor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.alibaba.fastjson.JSON;

@Aspect
@Component
public class ControllerAspect {
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Around("execution(* com.lsq.controller.*.*(..))")
	public Object intercepetService(ProceedingJoinPoint jp) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj = jp.proceed();

		Object[] args = jp.getArgs();
		if (args != null) {

		}
		for (Object object : args) {
			if (object instanceof HttpServletRequest) {
				HttpServletRequest request = (HttpServletRequest) object;
				String userId = request.getParameter("userId");
				System.out.println("userId:" + userId);
			}
		}
		MethodSignature signature = (MethodSignature) jp.getSignature();
		String methodName = signature.getDeclaringTypeName() + "."
				+ signature.getName();
		long endTime = System.currentTimeMillis();
		this.printExecTime(methodName, startTime, endTime);
		return obj;
	}

	private void printExecTime(String methodName, long startTime,
			long endTime) {
		long exeTime = endTime - startTime;
		System.out.println("-----" + methodName + " 方法执行耗时：" + exeTime + " ms");
		LogInfo logInfo = new LogInfo();
		logInfo.setMethodName(methodName);
		logInfo.setStartTime(new Date(startTime));
		logInfo.setEndTime(new Date(endTime));
		logInfo.setExeTime(exeTime);
		// mongoTemplate.insert(logInfo);
		ListenableFuture<SendResult<String, String>> r = kafkaTemplate
				.sendDefault(JSON.toJSONString(logInfo));
//		List<LogInfo> list = mongoTemplate.findAll(LogInfo.class);
//		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");
//		for (LogInfo logInfo2 : list) {
//			System.out.println(logInfo2.getMethodName() + "="
//					+ fmt.format(logInfo2.getStartTime()) + "="
//					+ fmt.format(logInfo2.getEndTime()) + "="
//					+ logInfo2.getExeTime());
//		}
	}
}
