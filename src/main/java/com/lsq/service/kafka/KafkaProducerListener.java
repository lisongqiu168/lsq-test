package com.lsq.service.kafka;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;

public class KafkaProducerListener implements ProducerListener<String, String> {

	protected final Logger LOG = LoggerFactory
			.getLogger(KafkaProducerListener.class);

	@Override
	public void onSuccess(String topic, Integer partition, String key,
			String value, RecordMetadata recordMetadata) {
		System.out.println("==========kafka发送数据成功（日志开始）==========");
		System.out.println("----------topic:" + topic);
		System.out.println("----------partition:" + partition);
		System.out.println("----------key:" + key);
		System.out.println("----------value:" + value);
		System.out.println("----------RecordMetadata:" + recordMetadata);
		System.out.println("~~~~~~~~~~kafka发送数据成功（日志结束）~~~~~~~~~~");

	}

	@Override
	public void onError(String topic, Integer partition, String key,
			String value, Exception exception) {
		System.out.println("==========kafka发送数据错误（日志开始）==========");
		System.out.println("----------topic:" + topic);
		System.out.println("----------partition:" + partition);
		System.out.println("----------key:" + key);
		System.out.println("----------value:" + value);
		System.out.println("----------Exception:" + exception);
		System.out.println("~~~~~~~~~~kafka发送数据错误（日志结束）~~~~~~~~~~");
		exception.printStackTrace();

	}

	@Override
	public boolean isInterestedInSuccess() {
		// TODO Auto-generated method stub
		return true;
	}

}
