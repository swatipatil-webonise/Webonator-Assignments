package com.webonise.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.webonise.model.User;
import com.webonise.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Value("${object.key}")
	private String OBJECT_KEY;
	
	private RedisTemplate<String, User> redisTemplate;
	
	private HashOperations hashOperations;
	
	private Logger log = LoggerFactory.getLogger(UserRepositoryImpl.class);
	
	private final Long USER_DELETED = 1l, USER_NOT_DELETED = 0l;
		
	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>(hashOperations.entries(OBJECT_KEY).values());
		if (Optional.ofNullable(users).isPresent()) {
			return users;
		} else {
			log.error("Empty redis cache found.");
			return users;
		}
	}

	@Override
	public boolean save(User user) {
		return hashOperations.putIfAbsent(OBJECT_KEY, user.getId(), user);
	}

	@Override
	public Long delete(String id) {
		if (hashOperations.delete(OBJECT_KEY, id) == USER_DELETED) {
			return USER_DELETED;
		} else {
			log.error("User with given id {} not found.", id);
			return USER_NOT_DELETED;
		}
	}	
}
