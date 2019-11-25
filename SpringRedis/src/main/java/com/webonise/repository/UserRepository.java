package com.webonise.repository;

import java.util.Map;
import com.webonise.model.User;

public interface UserRepository {
	
	/**
	 * This method will return all the record from redis-cache.
	 * @return Map<String, User>
	 */
	public Map<String, User> findAll();
	
	/**
	 * This method will put the given user into redis-cache.
	 * @param user
	 * @return User
	 */
	public User save(User user);
}
