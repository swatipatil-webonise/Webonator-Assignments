package com.webonise.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webonise.exception.EmptyFoundException;
import com.webonise.exception.FailedToUpdateDatabseException;
import com.webonise.exception.NotFoundException;
import com.webonise.model.User;
import com.webonise.repository.UserDao;
import com.webonise.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDao userDao;

	private Logger log = LoggerFactory.getLogger(UserService.class);

	public void updateRedisCache() {
		List<User> users = userDao.findAll();
		if (Optional.ofNullable(users).isPresent()) {
			for (User user : users) {
				userRepository.save(user);
			}
		} else {
			log.error("Empty user list found.");
			throw new EmptyFoundException("Empty user list found.");
		}
	}

	public User save(User user) {
		if (Optional.ofNullable(userDao.save(user)).isPresent()) {
			updateRedisCache();
			return user;
		} else {
			log.error("Failed to execute save operation of object {} on database.", user);
			throw new FailedToUpdateDatabseException("Failed to execute save operation on database.");
		}
	}

	public User update(User user) {
		final int RECORD_NOT_UPDATED = 0;
		if (userDao.existsById(user.getId())) {
			if (userDao.update(user.getId(), user.getName(), user.getAge()) != RECORD_NOT_UPDATED) {
				updateRedisCache();
				return user;
			} else {
				log.error("Failed to execute update operation of object {} on database.", user);
				throw new FailedToUpdateDatabseException("Failed to execute update operation on database.");
			}
		} else {
			return save(user);
		}
	}

	public Long deleteById(String id) {
		final Long RECORD_DELETED = 1L;
		if (userDao.deleteUserById(id) == RECORD_DELETED) {
			updateRedisCache();
			return RECORD_DELETED;
		} else {
			log.error("User with given id {} not found.", id);
			throw new NotFoundException("User not found.");
		}
	}

	public Map<String, User> findAll() {
		return userRepository.findAll();
	}
}
