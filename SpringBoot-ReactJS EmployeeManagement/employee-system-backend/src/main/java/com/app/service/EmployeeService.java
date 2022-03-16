package com.app.service;



import java.util.List;

import com.app.model.Employee;


public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

}
