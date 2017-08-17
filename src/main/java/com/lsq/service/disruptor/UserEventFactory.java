package com.lsq.service.disruptor;

import com.lmax.disruptor.EventFactory;

public class UserEventFactory implements EventFactory<UserEvent> {

	@Override
	public UserEvent newInstance() {
		return new UserEvent();
	}

}
