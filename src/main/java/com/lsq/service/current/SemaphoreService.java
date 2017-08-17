package com.lsq.service.current;

import java.util.concurrent.Semaphore;

public class SemaphoreService {
	public static void main(String[] args) {

		final Semaphore s = new Semaphore(1);

		for (int i = 0; i < 2; i++) {
			Runnable r = new Runnable() {
				@Override
				public void run() {
					try {
						s.acquire();
						
						System.out.println(Thread.currentThread().getId()+",s.getQueueLength():"+s.getQueueLength());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						s.release();
					}
				}
			};
			Thread t = new Thread(r);
			t.start();

		}
	}
}
