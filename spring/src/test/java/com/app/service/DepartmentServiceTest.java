package com.app.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.entity.Department;
import com.app.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() {
		
		
	}

	
	@Test
	@DisplayName("Get data based on valid department name")
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		
		String deptName="IT";
		Department found = departmentService.fetchDepartmentByName(deptName);
		
		assertEquals(deptName, found.getDeptName());
		
	}

}
