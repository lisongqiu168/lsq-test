package com.lsq.service.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class GuavaCacheService {

	public GuavaCacheService() {
		System.out.println("GuavaCacheService");
	}

	@PostConstruct
	public void init() {
		System.out.println("GuavaCacheService init");
	}

	public static void main(String[] args) throws ExecutionException,
			InterruptedException {

		LoadingCache<Long, AtomicLong> counter = CacheBuilder.newBuilder()
				.expireAfterWrite(5, TimeUnit.SECONDS)
				.build(new CacheLoader<Long, AtomicLong>() {
					@Override
					public AtomicLong load(Long arg0) throws Exception {
						return new AtomicLong(0);
					}
				});
		while (true) {
			Thread.sleep(500);
			long currentSeconds = System.currentTimeMillis() / 5000;
			long c = counter.get(currentSeconds).incrementAndGet();
			System.out.println(c);
			// if (c > 5000000000000000000L) {
			// System.out.println(c+"限流了");
			// break;
			// }
		}
	}
}
