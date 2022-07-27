package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Department;
import com.app.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	
	@Autowired(required = true)
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment( @RequestBody Department department) {
		log.info("inside saveDepartment method of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	
//	@GetMapping("/{deptId}")
//	public Department findDepartmentById(@PathVariable("deptId") Long deptId) {
//		log.info("inside findDepartmentById method of DepartmentService");
//		return departmentService.findDepartmentById(deptId);
//
//		
//	}
	
	@GetMapping("/departments")
	public List<Department> fetchAllDepartments() {
		log.info("inside fetchAllDepartments method of DepartmentService");
		return departmentService.fetchAllDepartment();
		
	}

}
