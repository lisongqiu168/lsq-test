package com.lsq.service.current;

import java.util.concurrent.Exchanger;

public class ExchangerService {

	public static void main(String[] args) {

		final Exchanger<String> e = new Exchanger<String>();

		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				try {
					String result = e.exchange(null);
					System.out.println(result);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				try {
					String result = e.exchange("test==========");
					System.out.println(result+"===");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread t2 = new Thread(r2);
		t2.start();
	}
}
