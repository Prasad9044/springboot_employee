package com.qsp.springbootemployee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootemployee.dto.Employee;
import com.qsp.springbootemployee.service.EmployeeService;
import com.qsp.springbootemployee.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeController {
	/*
	 * @Autowired private EmployeeDao dao;
	 */
	@Autowired
	private EmployeeService employeeService;

	@ApiOperation(value = "Save Employee", notes = "This Api is used to save the employee data in database")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved") })
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(@Valid @RequestParam int id) {
		return employeeService.findEmployee(id);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<List<Employee>>> findAllEmployee() {
		return employeeService.findAllEmployee();
	}

	@ApiOperation(value = "Delete Employee", notes = "Api is used to delete employee using employee_id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "Id not found") })
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@Valid @PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}

	@ApiOperation(value = "Update Employee", notes = "Api is used to update Employee using employee_id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Id not found") })
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@Valid @RequestParam int id,
			@RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}

	@PatchMapping("/updateEmail")
	public ResponseEntity<ResponseStructure<Employee>> updateEmail(@Valid @RequestParam int id,
			@RequestParam String email) {
		return employeeService.updateEmail(id, email);
	}

	@PatchMapping("/updatePhone")
	public ResponseEntity<ResponseStructure<Employee>> updatePhone(@Valid @RequestParam int id,
			@RequestParam long phone) {
		return employeeService.updatePhone(id, phone);
	}

	@PatchMapping("/updateSalary")
	public ResponseEntity<ResponseStructure<Employee>> updateSalary(@Valid @RequestParam int id,
			@RequestParam double salary) {
		return employeeService.updateSalary(id, salary);
	}

	@GetMapping("/fetchByEmail")
	public ResponseEntity<ResponseStructure<Employee>> findEmpByEmail(@Valid @RequestParam String email) {
		return employeeService.findEmpByEmail(email);
	}

	@GetMapping("/fetchByPhone/{phone}")
	public ResponseEntity<ResponseStructure<Employee>> findEmpByPhone(@Valid @PathVariable long phone) {
		return employeeService.findEmpByPhone(phone);
	}

	@GetMapping("/salGreaterThan/{salary}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeBySalaryGreaterThan(
			@Valid @PathVariable double salary) {
		return employeeService.findEmployeeBySalaryGreaterThan(salary);
	}

	@GetMapping("/salaryLessThan/{salary}")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeBySalarylessThan(
			@Valid @PathVariable double salary) {
		return employeeService.findEmployeeBySalaryLessThan(salary);
	}
}
