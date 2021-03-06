package com.zdxj.service.impl;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.Topic;
import org.springframework.stereotype.Component;

import com.zdxj.service.MessageConsumer;

@Component
public class LikeManMessageConsumer implements MessageConsumer {

	@Override
	public Topic getTopic() {
		//ChannelTopic对应redis的channel
		return ChannelTopic.of("like-man");
	}

	@Override
	public MessageListener getMessageListener() {
		return new LikemanMessageListener();
	}

	public class LikemanMessageListener implements MessageListener {
		@Override
		public void onMessage(Message message, byte[] pattern) {
			System.out.println("body:"+new String(message.getBody())+",channel="+new String(message.getChannel())+",pattern="+(pattern==null?null:new String(pattern)));
		}
	}

	
}
