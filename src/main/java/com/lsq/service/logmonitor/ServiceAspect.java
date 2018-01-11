package com.lsq.service.logmonitor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Around("execution(* com.lsq.service.logmonitor.*.*(..))")
    public Object intercepetService(ProceedingJoinPoint jp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = jp.proceed();
        MethodSignature signature = (MethodSignature) jp.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        long endTime = System.currentTimeMillis();
        this.printExecTime(methodName, startTime, endTime);
        return obj;
    }

    private void printExecTime(String methodName, long startTime, long endTime) {
        long exeTime = endTime - startTime;
        // mongodb
        System.out.println("-----" + methodName + " 方法执行耗时：" + exeTime + " ms");
        LogInfo logInfo = new LogInfo();
        logInfo.setMethodName(methodName);
        logInfo.setStartTime(new Date(startTime));
        logInfo.setEndTime(new Date(endTime));
        logInfo.setExeTime(exeTime);
        mongoTemplate.insert(logInfo);
        List<LogInfo> list = mongoTemplate.findAll(LogInfo.class);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");
        for (LogInfo logInfo2 : list) {
            System.out.println(logInfo2.getMethodName() + "=" + fmt.format(logInfo2.getStartTime()) + "=" + fmt.format(logInfo2.getEndTime()) + "="
                    + logInfo2.getExeTime());
        }

    }
}
