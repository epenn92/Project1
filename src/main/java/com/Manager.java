package com;

//public class Manager extends Employee {
public class Manager {
	
	int managerNo;
	boolean isManager;
	String managerDepartment;
	String managerLocation;
	
//	public Manager(int empNo, String empFirstName, String empLastName, String empEmail, String empPhoneNumber) {
//		super(empNo, empFirstName, empLastName, empEmail, empPhoneNumber);
		// TODO Auto-generated constructor stub
	public Manager(int managerNo, boolean isManager, String managerDepartment, String managerLocation) {
		
	}

	public boolean isManager() {
		return isManager;
	}

	public void setisManager(boolean isManager) {
		this.isManager = isManager;
	}

	public String getManagerDepartment() {
		return managerDepartment;
	}
	public void setManagerDepartment(String managerDepartment) {
		this.managerDepartment = managerDepartment;
	}
	public String getManagerLocation() {
		return managerLocation;
	}
	public int getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}

	public void setManagerLocation(String managerLocation) {
		this.managerLocation = managerLocation;
	}
	
	@Override
	public String toString() {
		return "Manager [managerNo=" + managerNo + ", isManager=" + isManager + ", managerDepartment="
				+ managerDepartment + ", managerLocation=" + managerLocation + "]";
	}
	
	
	
}


