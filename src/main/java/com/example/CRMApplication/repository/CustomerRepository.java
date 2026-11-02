package com.example.CRMApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CRMApplication.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

    
}
