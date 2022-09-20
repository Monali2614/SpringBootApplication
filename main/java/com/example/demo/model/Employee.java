package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	
	@Id
	private int eid;
	private String ename;
	private String eaddr;
	private long emob;
	private double esal;
	private String edomain;
	
	
	
	
	
	public String getEdomain() {
		return edomain;
	}
	public void setEdomain(String edomain) {
		this.edomain = edomain;
	}
	public double getEsal() {
		return esal;
	}
	public void setEsal(double esal) {
		this.esal = esal;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
	public long getEmob() {
		return emob;
	}
	public void setEmob(long emob) {
		this.emob = emob;
	}
	
	
	
	

}
