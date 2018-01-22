package com.lsq.service.kafka;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.lsq.service.logmonitor.LogInfo;

public class KafkaConsumerServer implements MessageListener<String, String> {
    protected final Logger LOG = LoggerFactory.getLogger(KafkaConsumerServer.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 监听器自动执行该方法 消费消息 自动提交offset 执行业务代码 （high level api 不提供offset管理，不能指定offset进行消费）
     */

    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.println("=============kafkaConsumer开始消费=============");
        String topic = record.topic();
        String key = record.key();
        String value = record.value();
        long offset = record.offset();
        int partition = record.partition();
       // mongoTemplate.insert(JSON.parseObject(value, LogInfo.class));
        System.out.println("-------------topic:" + topic);
        System.out.println("-------------value:" + value);
        System.out.println("-------------key:" + key);
        System.out.println("-------------offset:" + offset);
        System.out.println("-------------partition:" + partition);
        System.out.println("~~~~~~~~~~~~~kafkaConsumer消费结束~~~~~~~~~~~~~");
//        List<LogInfo> list = mongoTemplate.findAll(LogInfo.class);
//        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");
//        for (LogInfo logInfo2 : list) {
//            System.out.println(logInfo2.getMethodName() + "=" + fmt.format(logInfo2.getStartTime()) + "=" + fmt.format(logInfo2.getEndTime()) + "="
//                    + logInfo2.getExeTime());
//        }
    }
}
