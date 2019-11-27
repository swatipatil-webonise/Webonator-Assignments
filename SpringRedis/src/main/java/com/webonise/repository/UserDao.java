package com.webonise.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.webonise.model.User;

@Repository
public interface UserDao extends JpaRepository<User, String>{

	@Modifying
	@Transactional
	@Query("delete from User where id = :id")
	public int deleteUserById(@Param("id") String id);
	
	@Modifying
	@Transactional
	@Query("update User user set user.name = :name, user.age = :age where user.id = :id")
	public int update(@Param("id") String id, @Param("name") String name, @Param("age") long age);	
}
