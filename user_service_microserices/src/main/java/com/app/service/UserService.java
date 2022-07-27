package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.VO.Department;
import com.app.VO.ResponseTemplateVO;
import com.app.entity.User;
import com.app.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		log.info("Inside saveUser method of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long uid) {
		// TODO Auto-generated method stub
		log.info("Inside getUserWithDepartment method of UserService");
		ResponseTemplateVO vo =new ResponseTemplateVO();
		User user = userRepository.findByUserId(uid);
		
		Department department =
				restTemplate.getForObject("http://localhost:8080/departments/" +user.getDeptId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}
	

}
