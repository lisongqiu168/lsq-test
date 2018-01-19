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
		LOG.info("==========kafka发送数据成功（日志开始）==========");
		LOG.info("----------topic:" + topic);
		LOG.info("----------partition:" + partition);
		LOG.info("----------key:" + key);
		LOG.info("----------value:" + value);
		LOG.info("----------RecordMetadata:" + recordMetadata);
		LOG.info("~~~~~~~~~~kafka发送数据成功（日志结束）~~~~~~~~~~");

	}

	@Override
	public void onError(String topic, Integer partition, String key,
			String value, Exception exception) {
		LOG.info("==========kafka发送数据错误（日志开始）==========");
		LOG.info("----------topic:" + topic);
		LOG.info("----------partition:" + partition);
		LOG.info("----------key:" + key);
		LOG.info("----------value:" + value);
		LOG.info("----------Exception:" + exception);
		LOG.info("~~~~~~~~~~kafka发送数据错误（日志结束）~~~~~~~~~~");
		exception.printStackTrace();

	}

	@Override
	public boolean isInterestedInSuccess() {
		// TODO Auto-generated method stub
		return false;
	}

}
