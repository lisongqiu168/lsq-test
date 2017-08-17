package com.lsq.service.disruptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

public class DisruptorMain {
	public static void main(String[] args) {

		EventFactory<UserEvent> eventFactory = new UserEventFactory();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		int ringBufferSize = 1024 * 1024; // RingBuffer 大小，必须是 2 的 N 次方；

		Disruptor<UserEvent> disruptor = new Disruptor<UserEvent>(eventFactory,
				ringBufferSize, executor, ProducerType.SINGLE,
				new YieldingWaitStrategy());

		EventHandler<UserEvent> eventHandler = new UserEventHandler();
		disruptor.handleEventsWith(eventHandler);

		disruptor.start();

		// 发布事件；
		for (int i = 0; i < 5; i++) {
			RingBuffer<UserEvent> ringBuffer = disruptor.getRingBuffer();
			long sequence = ringBuffer.next();// 请求下一个事件序号；
			System.out.println("sequence:" + sequence);
			try {
				UserEvent event = ringBuffer.get(sequence);// 获取该序号对应的事件对象；
				event.setData("test");
			} finally {
				ringBuffer.publish(sequence);// 发布事件；
			}
		}

	}
}
