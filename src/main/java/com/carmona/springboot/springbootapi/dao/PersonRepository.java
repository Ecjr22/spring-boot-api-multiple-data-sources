package com.carmona.springboot.springbootapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carmona.springboot.springbootapi.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
