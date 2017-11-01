package com.lsq.service.proxy;

public class MyService implements IMyService {

	public void add() {
		System.out.println("add");
	}

	public static void main(String[] args) {
		IMyService s = new MyService();

		MyInvocationHandler h = new MyInvocationHandler(s);
		
		IMyService proxy = (IMyService)h.getProxy();
		
		proxy.add();
	}

}
