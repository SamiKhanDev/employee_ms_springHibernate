package com.example.employeeHibernateMS.service;


import com.example.employeeHibernateMS.entity.Address;
import com.example.employeeHibernateMS.entity.Employee;
import com.example.employeeHibernateMS.repository.AddressRepository;
import com.example.employeeHibernateMS.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;

    public EmployeeService(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Address saveAddress(Address address) {

        return addressRepository.save(address);
    }

    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    public void deleteEmployee(int id) {

        employeeRepository.deleteById(id);
    }
}
