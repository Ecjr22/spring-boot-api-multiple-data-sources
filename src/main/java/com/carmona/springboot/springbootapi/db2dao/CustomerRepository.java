package com.carmona.springboot.springbootapi.db2dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carmona.springboot.springbootapi.db2entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
