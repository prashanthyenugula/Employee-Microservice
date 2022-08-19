package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.emp.entity.Employee;
import com.emp.service.IEmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("{eId}")
	public Employee geteEmployee(@PathVariable("eId") Long eId) {
		Employee employee = this.employeeService.getEmployee(eId);

		// http://localhost:8084/record/emp/1311
		List records = this.restTemplate.getForObject("http:RECORD-MICROSERVICE/record/emp/" + eId, List.class);
		employee.setRecords(records);
		return employee;

	}

}
