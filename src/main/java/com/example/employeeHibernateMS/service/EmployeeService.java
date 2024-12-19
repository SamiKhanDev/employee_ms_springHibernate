package com.example.employeeHibernateMS.service;

import com.example.employeeHibernateMS.entity.Address;
import com.example.employeeHibernateMS.entity.Department;
import com.example.employeeHibernateMS.entity.Employee;
import com.example.employeeHibernateMS.repository.AddressRepository;
import com.example.employeeHibernateMS.repository.DepartmentRepository;
import com.example.employeeHibernateMS.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, AddressRepository addressRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.departmentRepository = departmentRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));
    }

    public Employee assignDepartment(int employeeId, int departmentId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department not found"));

        employee.getDepartments().add(department);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
