package com.chindx.youth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chindx.youth.entity.User;
import com.chindx.youth.service.UserService;

/**
 * update 08-29 
 * {@RedisConfig}
 * {@UserServiceImpl}
 * */
@Controller
public class RedisTest {
	@Autowired
	private StringRedisTemplate template;
	@Autowired
	private UserService userService;
	@ResponseBody
	@RequestMapping(value="/setValue")
	public String setValue() {
		if(!template.hasKey("shabao2")) {
			template.opsForValue().append("shabao2", "傻宝");
			return "使用Redis保存缓存数据成功";
		}else {
			template.delete("shabao2");
			return "Key已存在";
		}
	}
	@ResponseBody
	@RequestMapping(value = "/getValue")
	public String getValue() {
		if(!template.hasKey("shabao2")) {
			return "Key不存在,请先保存数据";
		}else {
			String shabao = template.opsForValue().get("shabao2");
			return "【获取到缓存中的数据】shabao2 = " + shabao;
		}
	}
	@ResponseBody
	@RequestMapping(value = "/getUser/{id}")
	public User getUser(@PathVariable Long id) {
		User user = userService.getUser(id);
		return user;
	}
	@ResponseBody
	@RequestMapping(value = "/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return "【执行了删除】";
	}
}
