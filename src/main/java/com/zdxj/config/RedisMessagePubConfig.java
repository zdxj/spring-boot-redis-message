package com.zdxj.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import com.zdxj.service.MessageConsumer;

@Configuration
public class RedisMessagePubConfig {

	@Autowired
	protected List<MessageConsumer> messageConsumers ;
	
	/**
	 * RedisMessageListenerContainer相当于一个代理，就是它负责接收redis的消息，并分发给MessageListener
	 * @param redisConnectionFactory
	 * @return
	 */
	@Bean
	public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
		
		RedisMessageListenerContainer tmlc = new RedisMessageListenerContainer();
		tmlc.setConnectionFactory(redisConnectionFactory);
		for(MessageConsumer mc:messageConsumers) {
			tmlc.addMessageListener(mc.getMessageListener(), mc.getTopic());
		}
		return tmlc;
	}
}
