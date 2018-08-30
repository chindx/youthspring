package com.chindx.youth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.chindx.youth.dao.UserRepository;
import com.chindx.youth.entity.User;
import com.chindx.youth.service.RedisTestService;

public class RedisTestServiceImpl implements RedisTestService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);	
	/**
	 * @update 08-29添加缓存配置@CacheEvict
	 * delete后清除缓存@CacheEvict
	 * */
	@CacheEvict(value = "user", key = "\"user\".concat(#id)")
	@Override
	public User deleteUser(Long id) {		
		log.info("【删除用户】" + id);
		return null;		
	}
	/**
	 * @update 08-29添加缓存配置@Cacheable|改变方法名为getUser(之前为findById)
	 * delete后清除缓存@CacheEvict
	 * */
	@Cacheable(value = "user", key = "\"user\".concat(#id)")
	@Override
	public User getUser(Long id) {
		log.info("【获取用户？ID=】" + id);
		User user = new User();
		user.setId(id);
		user.setName("香菇");
		user.setAge(18);
		return user;
	}

}
