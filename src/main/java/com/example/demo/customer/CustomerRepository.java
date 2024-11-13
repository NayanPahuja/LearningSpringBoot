package com.example.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //get all customers using email id {domain}.com
    @Query("SELECT c FROM Customer c WHERE c.email LIKE %:domain")
    List<Customer> findCustomerByDomain(@Param("domain") String domain);
}
