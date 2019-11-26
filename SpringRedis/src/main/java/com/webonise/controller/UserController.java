package com.webonise.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.webonise.model.User;
import com.webonise.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
    @Autowired
    private UserService userService;
	
    @PostMapping("/")
    public User add(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/")
    public int update(@RequestBody User user) {
    	return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") String id) {
        return userService.deleteById(id);
    }

    @GetMapping("/")
    public List<User> get() {
        return userService.findAll();
    }	
}
