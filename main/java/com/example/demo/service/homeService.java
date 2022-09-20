package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Employee;

public interface homeService {

	public Iterable<Employee> getAllData();

	public void savedata(Employee emp);

	public Optional<Employee> getDataById(int eid);

	public Optional<Employee> getDataByName(String ename);

	public Employee updateData(Employee elp);

	public void deleteData(int eid);

	public Employee setDomain(int eid, Employee em);

	

	

	

}
