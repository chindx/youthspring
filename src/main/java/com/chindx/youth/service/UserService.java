package com.chindx.youth.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.chindx.youth.entity.User;

public interface UserService {
	
	List<User> findAll();
	
	User insertByUser(User user);
	
	User update(User user);
	
	User delete(Long id);
	
	User getUser(Long id);
	/**
	 * 分页
	 * */
	Page<User> findByPage(Pageable pageable);
}
