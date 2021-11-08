package com.pravin.apachekafkaproducer.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

public class Employee {
	
	@JsonProperty("date_of_birth")
	private String dOb;
	
	@JsonProperty("emp_id")
	private String empId;
	
	@JsonProperty("emp_name")
	private String empName;

	public Employee() {
		super();
	}

	public Employee(String empName, String empId, String dOb) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.dOb = dOb;
	}

	public String getdOb() {
		return dOb;
	}

	public String getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setdOb(String dOb) {
		this.dOb = dOb;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", dOb=" + dOb + "]";
	}

}
