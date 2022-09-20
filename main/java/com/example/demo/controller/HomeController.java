package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CustomExceptionForNullObj;
import com.example.demo.model.Employee;
import com.example.demo.service.homeService;

@RestController
public class HomeController {
	
	@Autowired
	homeService hm;
	
	
	@GetMapping("/getalldata")
	public ResponseEntity<Iterable<Employee>> getAllData()
	{
		Iterable<Employee> list	=hm.getAllData();
		
		return new ResponseEntity<Iterable<Employee>>(list,HttpStatus.FOUND);	
	}
	
	@PostMapping("/savedata")
	public ResponseEntity<String> saveData(@RequestBody Employee emp)
	{
		hm.savedata(emp);
		
		return new ResponseEntity<String>("Data is Saved",HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getById/{eid}")
	public  ResponseEntity<Optional<Employee>> getById(@PathVariable("eid") int eid)
	{
		Optional<Employee> list	=hm.getDataById(eid);
		
		return new ResponseEntity<Optional<Employee>>(list,HttpStatus.FOUND);
	}
	
	@GetMapping("/getbyname/{ename}")
	public ResponseEntity<Optional<Employee>> getByName(@PathVariable("ename") String ename)
	{
		
		Optional<Employee> list1 =hm.getDataByName(ename);
		
		return new ResponseEntity<Optional<Employee>>(list1,HttpStatus.FOUND);
	}
	
	
	@PutMapping("/updateData")
	public ResponseEntity<Employee> updateData(@RequestBody Employee elp)
	{
		Employee ee	=hm.updateData(elp);
		
		if(ee==null)
		{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		else {
			
			return new ResponseEntity<Employee>(ee,HttpStatus.valueOf(201));
		}
			
	}
	
	
	@DeleteMapping("/deleteData/{eid}")
	public ResponseEntity<String> deleteData(@PathVariable("eid") int eid)
	{
		if(eid<=0)
		{
			return new ResponseEntity<String>("Employee Id is Invalid",HttpStatus.NOT_FOUND);
		}
		else {
		
		hm.deleteData(eid);
		
		return new ResponseEntity<String>("Data deleted",HttpStatus.ACCEPTED);
		
		}
		
	}
	
	
	@PutMapping("/updateDomain/{eid}")
	public ResponseEntity<Employee> autoupdateDomain(@PathVariable("eid") int eid, @RequestBody Employee em)
	{
		if(em!=null)
		{
		
		if(em.getEsal()>=32000)
		{
			String dom="Java";
			em.setEdomain(dom);
			
			Employee getdom=hm.setDomain(eid,em);
			
			return new ResponseEntity<Employee>(getdom,HttpStatus.CREATED);
		}
		else {
			
			String dom1="python";
			em.setEdomain(dom1);
			
			Employee getdom1=hm.setDomain(eid,em);
			
			return new ResponseEntity<Employee>(getdom1,HttpStatus.CREATED);	
		}
		}
		else {
			
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);	
		}
			
	}
	
}
