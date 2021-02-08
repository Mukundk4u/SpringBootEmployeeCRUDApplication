package com.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDaoImpl;
	
	@GetMapping("/getdata")
	public List<Employee> getData(){
		
		return employeeDaoImpl.getData();
	}
	
	@PostMapping("/savedata") 
	public String saveData(@RequestBody Employee employee) {
		
		employeeDaoImpl.saveData(employee);
		return "Employee data save successfully";
	}
	
	@PutMapping("/updatedata/{empId}")
	
	public String updateData(@PathVariable("empId") int empId, @RequestBody Employee employee)
	{
		employeeDaoImpl.updateData(empId, employee);
		return "Employee data updated successfully";
	}
	
	@DeleteMapping("/deletedata/{empId}")
	public String deleteData(@PathVariable("empId") int empId)
	{
		employeeDaoImpl.deleteData(empId);
		return "Employee data deleted successfully";
	}
}
