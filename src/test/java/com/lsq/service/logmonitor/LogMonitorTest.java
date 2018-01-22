package com.lsq.service.logmonitor;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import com.alibaba.fastjson.JSON;
import com.lsq.controller.UserParam;
import com.lsq.service.AbstractTest;

public class LogMonitorTest extends AbstractTest {
	@Autowired
	private LogMonitorService logMonitorService;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Test
	public void testLog() {
		logMonitorService.log();
	}

	@Test
	public void testMongoDBInsert() {
		UserParam user = new UserParam();
		user.setUserId(1L);
		String s = JSON.toJSONString(user);
		mongoTemplate.insert(JSON.parseObject(s, UserParam.class));
		List<UserParam> list = mongoTemplate.findAll(UserParam.class);
		for (UserParam userParam : list) {
			System.out.println(userParam.getUserId());
		}
	}

	@Test
	public void testMongoDBFinid() {
		Query query = new Query();
		query.addCriteria(Criteria.where("exeTime").is(104));
		List<LogInfo> list = mongoTemplate.find(query, LogInfo.class);
		for (LogInfo logInfo : list) {
			System.out.println(logInfo.getExeTime());
		}
	}

	@Test
	public void testKafka() throws InterruptedException {
		// kafka
		ListenableFuture<SendResult<String, String>> r = kafkaTemplate
				.send("defaultTopic", "test_value");
		Thread.sleep(5000);

	}
}
