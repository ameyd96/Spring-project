package com.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.EmployeeEntity;
import com.app.model.Employee;
import com.app.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		BeanUtils.copyProperties(employee, employeeEntity);
		
		employeeRepository.save(employeeEntity);
		return employee;
	}

}
