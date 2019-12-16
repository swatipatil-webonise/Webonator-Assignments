package com.webonise.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import com.webonise.graphql.entity.Vehicle;
import com.webonise.graphql.repository.VehicleRedisRepository;
import com.webonise.graphql.repository.impl.VehicleRedisRepositoryImpl;

@SpringBootApplication
@EnableCaching
public class Application extends SpringBootServletInitializer {
	
	@Autowired
	private RedisTemplate< Integer, Vehicle> redisTemplate;
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<Integer, Vehicle> redisTemplate() {
		RedisTemplate<Integer, Vehicle> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
 	}
	
	@Bean
	VehicleRedisRepository vehicleRedisRepository() {
		return new VehicleRedisRepositoryImpl(redisTemplate);
	}
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
