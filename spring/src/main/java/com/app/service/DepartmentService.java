package com.app.service;



import java.util.List;

import com.app.entity.Department;
import com.app.error.DepartmentNotFoundException;

public interface DepartmentService {


	public Department saveDepartments(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchById(Long id) throws DepartmentNotFoundException;

	public void deleteById(Long id);

	public Department updateDepartment(Long id, Department department);

	public Department fetchDepartmentByName(String deptName);
	 
	 

}
