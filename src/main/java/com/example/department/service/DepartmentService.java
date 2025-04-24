package com.example.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.department.entity.Department;
import com.example.department.exception.NotFoundException;
import com.example.department.repository.DepartmentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department savedDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	public Department getDepartmentById(Long id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id).orElseThrow(() -> new NotFoundException("No data found with this id "+ id));
	}

}
