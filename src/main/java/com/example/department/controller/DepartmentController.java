package com.example.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.department.entity.Department;
import com.example.department.exception.InValidInputException;
import com.example.department.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
		if(department.getDepartmentName()== null || department.getDepartmentName().isEmpty()) {
			throw new InValidInputException("Item cannot be empty");
		}
		
		Department dep = departmentService.savedDepartment(department);
		
		return new ResponseEntity<Department>(department,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable("id") Long id){
		
		Department ddp = departmentService.getDepartmentById(id);
		return ResponseEntity.ok(ddp);
		
	}

}
