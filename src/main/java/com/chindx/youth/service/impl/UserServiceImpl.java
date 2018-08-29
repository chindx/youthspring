package com.chindx.youth.service.impl;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.chindx.youth.dao.UserRepository;
import com.chindx.youth.entity.User;
import com.chindx.youth.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userDao;
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	@Override
	public User insertByUser(User user) {
		log.info("【新增用户】" + user.toString());
		return userDao.save(user);
	}

	@Override
	public User update(User user) {
		log.info("【更新用户】" + user.toString());
		return userDao.save(user);
	}
	/**
	 * @update 08-29添加缓存配置@CacheEvict
	 * delete后清除缓存@CacheEvict
	 * */
	@CacheEvict(value = "user", key = "\"user\".concat(#id)")
	@Override
	public User delete(Long id) {
		User user = userDao.findById(id).get();
		userDao.delete(user);
		log.info("【删除用户】" + user.toString());
		return user;		
	}
	/**
	 * @update 08-29添加缓存配置@Cacheable|改变方法名为getUser(之前为findById)
	 * delete后清除缓存@CacheEvict
	 * */
	@Cacheable(value = "user", key = "\"user\".concat(#id)")
	@Override
	public User getUser(Long id) {
		log.info("【获取用户？ID=】" + id);
		return userDao.findById(id).get();
	}
	@Override
	public Page<User> findByPage(Pageable pageable) {
		log.info("\n 【分页查询用户】"
				+ " PageNumber = " + pageable.getPageNumber()
				+ " PageSize = " + pageable.getPageSize());		
		return userDao.findAll(pageable);
	}
}
