package com.app.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Department;
import com.app.error.DepartmentNotFoundException;
import com.app.service.DepartmentService;



@RestController
public class DepartmentController {
	
	@Autowired(required=true)
	private DepartmentService departmentService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartments(@Valid @RequestBody Department department) {
		LOGGER.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartments(department);
		 
		
	}
	
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		LOGGER.info("Inside fetchDepartmentList of DepartmentController");
		return departmentService.fetchDepartmentList();
		
	}
	
	
	@GetMapping("/departments/{id}")
	public Department fetchById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
		return departmentService.fetchById(id);
	}
	
	
	@DeleteMapping("/departments/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		 departmentService.deleteById(id);
		 return "Departments is deleted";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartments(@PathVariable("id") Long id,@RequestBody Department department) {
		return departmentService.updateDepartment(id,department);
	}
	
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String deptName) {
		return departmentService.fetchDepartmentByName(deptName);
	}

}
