package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface HomeRepository extends CrudRepository<Employee,Integer> {
	
	
	public Optional<Employee> findByEname(String ename);

}
