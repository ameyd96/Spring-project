package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.VO.ResponseTemplateVO;
import com.app.entity.User;
import com.app.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		log.info("Inside saveUser method of UserController");
		return userService.saveUser(user);
	}
	
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long uid) {
		log.info("Inside getUserWithDepartment method of UserController");
		return userService.getUserWithDepartment(uid);
	}

}
