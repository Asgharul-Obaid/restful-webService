package net.obaid.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.obaid.springboot.exception.ResourceNotFoundException;
import net.obaid.springboot.model.Employee;
import net.obaid.springboot.repository.EmployeeRepository;
import net.obaid.springboot.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
    
	private EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	super();
	this.employeeRepository = employeeRepository;
}


	@Override
	public Employee savEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//	    if(employee.isPresent()) {
//	    	return employee.get();
//	    }else {
//			throw new ResourceNotFoundException("Employee","Id", id);
//		}
	return employeeRepository.findById(id).orElseThrow(()-> 
	            new ResourceNotFoundException("Employee", "Id", id));
	}


	@Override
	public Employee updatEmployee(Employee employee, long id) {
	//we need to check weather employeewith given id is exist in DB or not
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
		
	}


	@Override
	public void deleteEmployee(long id) {
		
		//check whether a employee exist in a DB or not 
		
		employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee", "Id", id));
		
		employeeRepository.deleteById(id);
		
	}

}
