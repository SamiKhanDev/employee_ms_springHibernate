package com.example.employeeHibernateMS.repository;

import com.example.employeeHibernateMS.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
