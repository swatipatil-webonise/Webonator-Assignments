package com.webonise.repository.impl;

import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.webonise.exception.EmptyFoundException;
import com.webonise.model.User;
import com.webonise.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	private RedisTemplate<String, User> redisTemplate;
	
	private HashOperations hashOperations;
	
	private Logger log = LoggerFactory.getLogger(UserRepositoryImpl.class);
		
	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public Map<String, User> findAll() {
		Map<String, User> users = hashOperations.entries("USER-1");
		if (Optional.ofNullable(users).isPresent()) {
			return users;
		} else {
			log.error("Empty redis cache found.");
			throw new EmptyFoundException("Empty redis cache found.");
		}
	}

	@Override
	public User save(User user) {
		hashOperations.put("USER-1", user.getId(), user);
		return user;
	}
}
