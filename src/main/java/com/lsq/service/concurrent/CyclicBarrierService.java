package com.lsq.service.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierService {

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		final CyclicBarrier cb = new CyclicBarrier(2,new Runnable() {
			
			@Override
			public void run() {
				System.out.println("barrierAction");
			}
		});
		
		for (int i = 0; i < 2; i++) {
			Runnable r = new Runnable() {
				@Override
				public void run() {
					try {
						cb.await();
						System.out.println("getNumberWaiting:"+cb.getNumberWaiting());
						System.out.println("getParties:"+cb.getParties());
						System.out.println(Thread.currentThread().getId());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
	}
}
