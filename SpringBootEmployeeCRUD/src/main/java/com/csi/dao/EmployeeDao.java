package com.csi.dao;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeDao {

	public List<Employee> getData();
	
	public void saveData(Employee employee);
	
	public void updateData(int empId, Employee employee);
	
	public void deleteData(int empId);
	
}
