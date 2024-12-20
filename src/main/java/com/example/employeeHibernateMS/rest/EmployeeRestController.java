package com.example.employeeHibernateMS.rest;


import com.example.employeeHibernateMS.entity.Address;
import com.example.employeeHibernateMS.entity.Employee;
import com.example.employeeHibernateMS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @PostMapping("/{employeeId}/addresses")
    public ResponseEntity<Address> addAddress(@PathVariable int employeeId, @RequestBody Address address) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        address.setEmployee(employee);
        Address savedAddress = employeeService.saveAddress(address);
        return ResponseEntity.ok(savedAddress);
    }

    // Assign a Department to an Employee
    @PostMapping("/{employeeId}/departments/{departmentId}")
    public ResponseEntity<Employee> assignDepartment(@PathVariable int employeeId, @PathVariable int departmentId) {
        Employee updatedEmployee = employeeService.assignDepartment(employeeId, departmentId);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Getting list of all employees with address and department
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
