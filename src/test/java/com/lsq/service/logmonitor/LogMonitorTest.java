package com.lsq.service.logmonitor;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

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
    public void testMongoDBFinid() {
        Query query = new Query();
        query.addCriteria(Criteria.where("exeTime").is(104));
        List<LogInfo> list = mongoTemplate.find(query, LogInfo.class);
        for (LogInfo logInfo : list) {
            System.out.println(logInfo.getExeTime());
        }
    }

    @Test
    public void testKafka() {
        // kafka
        ListenableFuture<SendResult<String, String>> r = kafkaTemplate.send("test_topic", "test_key", "test_value");
       
    }
}
