package net.obaid.springboot.service;

import java.util.List;

import net.obaid.springboot.model.Employee;


public interface EmployeeService {
	Employee savEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updatEmployee(Employee employee,long id);
	void deleteEmployee(long id);
}

