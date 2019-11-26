package com.webonise.repository;

import java.util.List;
import com.webonise.model.User;

public interface UserRepository {
	
	/**
	 * This method will return all the record from redis-cache.
	 * @return List<User>
	 */
	public List<User> findAll();
	
	/**
	 * This method will put the given user into redis-cache.
	 * @param user
	 */
	public boolean save(User user);
	
	/**
	 * This method will delete user with given id from redis-cache.
	 * @param id
	 * @return Long
	 */
	public Long delete(String id);
}
