package com;

public class ReimbursementRequest {

	int remNo;
	int empNo;
	String remManager;
	int remAmount;
	String remActivity;
	String remStatus;

	
	public ReimbursementRequest(int remNo, int empNo, String remManager, int remAmount, 
			String remActivity, String remStatus) {
		super();
		this.remNo = remNo;
		this.empNo = empNo;
		this.remManager = remManager;
		this.remAmount = remAmount;
		this.remActivity = remActivity;
		this.remStatus = remStatus;
	}
	
	public ReimbursementRequest() {
		
	}

	public int getRemNo() {
		return remNo;
	}

	public void setRemNo(int remNo) {
		this.remNo = remNo;
	}

	public int getEmpNo() {
		return empNo;
	}
	
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	
	public String getRemManager() {
		return remManager;
	}

	public void setRemManager(String remManager) {
		this.remManager = remManager;
	}

	public int getRemAmount() {
		return remAmount;
	}

	public String getRemActivity() {
		return remActivity;
	}

	public void setRemActivity(String remActivity) {
		this.remActivity = remActivity;
	}

	public void setRemAmount(int remAmount) {
		this.remAmount = remAmount;
	}

	public String getRemStatus() {
		return remStatus;
	}

	public void setRemStatus(String remStatus) {
		this.remStatus = remStatus;
	}

	@Override
	public String toString() {
		return "ReimbursementRequest [remNo=" + remNo + ", empNo=" + empNo + ", remManager=" + remManager
				+ ", remAmount=" + remAmount + ", remActivity=" + remActivity + ", remStatus=" + remStatus + "]";
	}


	
}
