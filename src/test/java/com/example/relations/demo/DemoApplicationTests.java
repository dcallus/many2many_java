package com.example.relations.demo;

import com.example.relations.demo.models.Department;
import com.example.relations.demo.models.Employee;
import com.example.relations.demo.models.Project;
import com.example.relations.demo.repositories.DepartmentRepository;
import com.example.relations.demo.repositories.EmployeeRepository;
import com.example.relations.demo.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createEmployeeAndDepartment(){
		Department department = new Department("sales");
		departmentRepository.save(department);

		Employee employee = new Employee("Mark","Rae", 1, department);
		employeeRepository.save(employee);
	}

	@Test
	void addEmployeesAndProjects(){
		Department department = new Department("Kitchen");
		departmentRepository.save(department);

		Employee employee = new Employee("Big", "John", 123, department);
		employeeRepository.save(employee);

		Project project = new Project("Big Project", 12);
		projectRepository.save(project);

		project.addEmployee(employee);
		projectRepository.save(project);
	}

}
