package com;

public class Employee {

	int empNo;
	String empFirstName;
	String empLastName;
	String empEmail;
	String empPhoneNumber;
	
	

	public Employee(int empNo, String empFirstName, String empLastName, String empEmail, String empPhoneNumber) {
		this.empNo = empNo;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empEmail = empEmail;
		this.empPhoneNumber = empPhoneNumber;
	}



	public Employee() {
		// TODO Auto-generated constructor stub
	}



	public int getEmpNo() {
		return empNo;
	}



	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}



	public String getEmpFirstName() {
		return empFirstName;
	}



	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}



	public String getEmpLastName() {
		return empLastName;
	}



	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}



	public String getEmpEmail() {
		return empEmail;
	}



	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}



	public String getEmpPhoneNumber() {
		return empPhoneNumber;
	}



	public void setEmpPhoneNumber(String empPhoneNumber) {
		this.empPhoneNumber = empPhoneNumber;
	}



	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empEmail=" + empEmail + ", empPhoneNumber=" + empPhoneNumber + "]";
	}

}
