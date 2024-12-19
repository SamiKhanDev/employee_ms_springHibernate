package com.example.employeeHibernateMS.repository;

import com.example.employeeHibernateMS.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
