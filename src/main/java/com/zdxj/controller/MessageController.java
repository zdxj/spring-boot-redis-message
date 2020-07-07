package com.zdxj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zdxj.util.RedisUtils;

@RestController
@RequestMapping("message")
public class MessageController {

	@Autowired
	private RedisUtils redisUtils ;
	
	/**
	 * 发布消息
	 * @param channel 订阅者
	 * @param msg 消息
	 * @return
	 */
	@GetMapping("/publicMessage")
    public String publicMessage(@RequestParam("channel") String channel,@RequestParam("msg") String msg) {
		redisUtils.convertAndSend(channel, msg);
        return "ok";
    }
	
}
