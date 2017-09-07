package com.lsq.service.hystrix;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import rx.functions.Action1;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

@Service
public class UserHystrixCommand extends HystrixCommand<String> {

	public UserHystrixCommand() {
		super(setter());
	}

	private static Setter setter() {
		// 配置组
		HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory
				.asKey("UserHystrixCommand");

		// 配置属性
		HystrixCommandProperties.Setter properties = HystrixCommandProperties
				.Setter()
				.withExecutionIsolationThreadTimeoutInMilliseconds(500);// 配置依赖超时时间,500毫秒

		HystrixCommand.Setter setter = HystrixCommand.Setter.withGroupKey(
				groupKey).andCommandPropertiesDefaults(properties);
		return setter;
	}

	@Override
	protected String run() throws Exception {
		System.out.println("服务处理逻辑");
		TimeUnit.MILLISECONDS.sleep(1000);
		return "服务返回值";
	}

	@Override
	protected String getFallback() {
		System.out.println("降级后处理逻辑");
		return "降级返回逻辑";
	}

	// 服务降级
	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		UserHystrixCommand c = new UserHystrixCommand();
		// 异步注册回调
		c.observe().subscribe(new Action1<String>() {
			@Override
			public void call(String arg0) {
				System.out.println(arg0);
			}
		});
		// 同步调用
		// String result = c.execute();
		// System.out.println(result);
		// 异步future调用
		// String r2 = c.queue().get();
		// System.out.println(r2);

	}
}
