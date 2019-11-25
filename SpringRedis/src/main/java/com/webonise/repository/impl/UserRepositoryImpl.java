package com.webonise.repository.impl;

import java.util.Map;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.webonise.model.User;
import com.webonise.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	private RedisTemplate<String, User> redisTemplate;
	
	private HashOperations hashOperations;
		
	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public Map<String, User> findAll() {
		return hashOperations.entries("USER-1");
	}

	@Override
	public User save(User user) {
		hashOperations.put("USER-1", user.getId(), user);
		return user;
	}
}
