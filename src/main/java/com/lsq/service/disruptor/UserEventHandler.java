package com.lsq.service.disruptor;

import com.lmax.disruptor.EventHandler;

public class UserEventHandler implements EventHandler<UserEvent> {

	@Override
	public void onEvent(UserEvent arg0, long arg1, boolean arg2)
			throws Exception {
		System.out.println(arg0.getData());
		System.out.println(arg1);
		System.out.println(arg2);
	}

}
