package net.obaid.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.obaid.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
