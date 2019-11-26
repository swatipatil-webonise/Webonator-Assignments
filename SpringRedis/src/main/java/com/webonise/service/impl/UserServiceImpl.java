package com.webonise.service.impl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.webonise.exception.EmptyFoundException;
import com.webonise.exception.FailedToUpdateDatabseException;
import com.webonise.exception.NotFoundException;
import com.webonise.model.User;
import com.webonise.repository.UserDao;
import com.webonise.repository.UserRepository;
import com.webonise.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDao userDao;
	
	@Value("${fixed.rate}")
	private final long fixedRate = 0;

	private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public void flushRedisCache() {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			userRepository.delete(user.getId());
		}
	}

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

	@Override
	public User save(User user) {
		User savedUser = userDao.save(user);
		if (Optional.ofNullable(savedUser).isPresent()) {
			updateRedisCache();
			return savedUser;
		} else {
			log.error("Failed to execute save operation of object {} on database.", user);
			throw new FailedToUpdateDatabseException("Failed to execute save operation on database.");
		}
	}

	@Override
	public int update(User user) {
		if (userDao.existsById(user.getId())) {
			int RECORD_NOT_UPDATED = 0, RECORD_UPDATED = 0;
			if (userDao.update(user.getId(), user.getName(), user.getAge()) != RECORD_NOT_UPDATED) {
				updateRedisCache();
				return RECORD_UPDATED = 1;
			} else {
				log.error("Failed to execute update operation of object {} on database.", user);
				throw new FailedToUpdateDatabseException("Failed to update database.");
			}
		} else {
			int RECORD_INSERTED = 0;
			if (Optional.ofNullable(save(user)).isPresent()) {
				RECORD_INSERTED = 1;
				return RECORD_INSERTED;
			} else {
				log.error("Failed to update database.");
				throw new FailedToUpdateDatabseException("Failed to update database.");
			}
		}
	}

	@Override
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

	@Override
	public List<User> findAll() {
		flushAndUpdateRedisCache();
		return userRepository.findAll();
	}

	@Override
	@Scheduled(fixedRate = fixedRate)
	public void flushAndUpdateRedisCache() {
		flushRedisCache();
		updateRedisCache();
	}
}
