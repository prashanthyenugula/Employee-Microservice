package com.emp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	
	List<Employee> list = List.of(
			new Employee(1121L, "Virat", "9949451269"),
			new Employee(1122L, "Dhoni", "9949451271"),
			new Employee(1123L, "Sachin", "9949451272"),
			new Employee(1124L, "Sehwag", "9949451273"),
			new Employee(1125L, "Rohit", "9949451274"),
			new Employee(1126L, "Yuvi", "9949451275"),
			new Employee(1127L, "Gambhir", "9949451276"),
			new Employee(1128L, "Dhavan", "9949451277")
			);
	
	@Override
	public Employee getEmployee(Long id) {
		return list.stream().filter(employee -> employee.geteId().equals(id)).findAny().orElse(null);
	}
	
	
}
