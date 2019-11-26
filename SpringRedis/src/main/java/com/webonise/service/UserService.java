package com.webonise.service;

import java.util.Map;
import com.webonise.model.User;

public interface UserService {

	/**
	 * This method updates redis cache.
	 */
	public void updateRedisCache();
	
	/**
	 * This method persist given user into database.
	 * @param user
	 * @return User
	 */
	public User save(User user);
	
	/**
	 * This method modifies user from database.
	 * @param user
	 * @return User
	 */
	public User update(User user);
	
	/**
	 * This method deletes the user with given id from database.
	 * @param id
	 * @return Long
	 */
	public Long deleteById(String id);
	
	/**
	 * This method gives all key-value pairs from redis cache.  
	 * @return Map
	 */
	public Map<String, User> findAll();	
}
