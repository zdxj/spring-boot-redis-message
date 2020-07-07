package com.zdxj.service;

import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.Topic;

public interface MessageConsumer {

	/**
	 * 表示一个订阅对象
	 * @return
	 */
	Topic getTopic();
	
	/**
	 * 回调接口，通过它来执行业务代码
	 * @return
	 */
	MessageListener getMessageListener();
}
