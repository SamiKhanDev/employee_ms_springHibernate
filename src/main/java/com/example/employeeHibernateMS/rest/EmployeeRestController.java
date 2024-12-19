package com.example.employeeHibernateMS.rest;


import com.example.employeeHibernateMS.entity.Address;
import com.example.employeeHibernateMS.entity.Employee;
import com.example.employeeHibernateMS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;



    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @PostMapping("/{employeeId}")
    public ResponseEntity<Address> addAddress(@PathVariable int employeeId, @RequestBody Address address) {
        address.setEmployee(new Employee()); // Set employee object
        address.getEmployee().setId(employeeId); // Set employee ID
        Address savedAddress = employeeService.saveAddress(address);
        return ResponseEntity.ok(savedAddress);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}