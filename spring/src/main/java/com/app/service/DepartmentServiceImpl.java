package com.app.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Department;
import com.app.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired(required=true)
	private DepartmentRepository departmentRepository;
	
	
	@Override
	public Department saveDepartments(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}


	@Override
	public List<Department> fetchDepartmentList() {
		
		return departmentRepository.findAll();
	}


	@Override
	public Department fetchById(Long id) {
		
		return departmentRepository.findById(id).get();
	}


	@Override
	public void deleteById(Long id) {
		
		 departmentRepository.deleteById(id);
	}


	@Override
	public Department updateDepartment(Long id, Department department) {
		Department deptDB = departmentRepository.findById(id).get();
		
		if(Objects.nonNull(department.getDeptName()) &&		
			!"".equalsIgnoreCase(department.getDeptName())) {
			deptDB.setDeptName(department.getDeptName());
		}
		
		
		if(Objects.nonNull(department.getDeptCode()) &&		
				!"".equalsIgnoreCase(department.getDeptCode())) {
				deptDB.setDeptCode(department.getDeptCode());
			}
		
		
		if(Objects.nonNull(department.getDeptAddress()) &&		
				!"".equalsIgnoreCase(department.getDeptAddress())) {
				deptDB.setDeptAddress(department.getDeptAddress());
			}
		
		return departmentRepository.save(deptDB);
	}


	@Override
	public Department fetchDepartmentByName(String deptName) {
		
		//return departmentRepository.findByDeptName(deptName);
		
		return departmentRepository.findByDeptNameIgnoreCase(deptName);
	}

}
