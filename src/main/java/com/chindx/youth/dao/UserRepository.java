package com.chindx.youth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chindx.youth.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
