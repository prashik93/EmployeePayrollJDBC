package org.example;

import java.time.LocalDate;

public class EmployeePayrollData {
	public int employeeId;
	public String employeeName;
	public double employeeSalary;
	public LocalDate startDate;
	
	public EmployeePayrollData() {
	}
	
	public EmployeePayrollData(Integer id, String name, Double salary, LocalDate startDate) {
		this.employeeId = id;
		this.employeeName = name;
		this.employeeSalary = salary;
		this.startDate = startDate;
	}
	
	@Override
	public String toString() {
		
		return "EmployeeId: "+employeeId+", " +
				"EmployeeName: "+employeeName+", " +
				"EmployeeSalary: "+employeeSalary;
	}
}
