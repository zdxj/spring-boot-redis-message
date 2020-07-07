package com.zdxj.service.impl;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Component;

import com.zdxj.service.MessageConsumer;

@Component
public class LikeBothMessageConsumer implements MessageConsumer{

	@Override
	public Topic getTopic() {
		//PatternTopic对应redis的pattern
		return PatternTopic.of("like-*");
	}

	@Override
	public MessageListener getMessageListener() {
		return new LikeBothMessageListener();
	}

	public class LikeBothMessageListener implements MessageListener {
		@Override
		public void onMessage(Message message, byte[] pattern) {
			System.out.println("body:"+new String(message.getBody())+",channel="+new String(message.getChannel())+",pattern="+(pattern==null?null:new String(pattern)));
		}
	}
}
