package com.example.employeeHibernateMS.repository;


import com.example.employeeHibernateMS.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
