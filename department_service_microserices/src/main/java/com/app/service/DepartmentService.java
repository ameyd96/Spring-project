package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Department;
import com.app.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired(required = true)
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		log.info("inside saveDepartment method of DepartmentService");
		return departmentRepository.save(department);
	}

//	public Department findDepartmentById(Long deptId) {
//		// TODO Auto-generated method stub
//		log.info("inside findDepartmentById method of DepartmentService");
//		return departmentRepository.findByDepartmentId(deptId);
//	}

	public List<Department> fetchAllDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}
	
	

	

}
