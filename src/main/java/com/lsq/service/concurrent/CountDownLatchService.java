package com.lsq.service.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchService {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch cdl = new CountDownLatch(2);

		cdl.countDown();
		//System.out.println(cdl.getCount());
		//cdl.countDown();
		
		//cdl.await();
		
		cdl.await();
		

		System.out.println("end");
	}
}
