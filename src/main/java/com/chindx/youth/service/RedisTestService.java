package com.chindx.youth.service;

import com.chindx.youth.entity.User;

public interface RedisTestService {
	
	User deleteUser(Long id);
	
	User getUser(Long id);
}
