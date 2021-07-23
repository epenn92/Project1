package com;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {

	public int passwordCheck(String username, String password);
	
	public List<Employee> displayAllEmployees();
	
	public Employee findByEmployeeNo(int empNo);
	
	public void updateEmployee(int empNo, String firstname, String lastname, String email, String phonenumber);
	
	public void createReimbursementClaim(int empNo, int remAmount, String remActivity);
	
	public ArrayList<ReimbursementRequest> getPendingClaimByEmpNo(int empNo);
	
	public ArrayList<ReimbursementRequest> getResolvedClaimByEmpNo(int empNo);
	
	public boolean managerCheck(int empNo);
	
	public Manager findManagerInfo(int empNo);
	
	public List<ReimbursementRequest> displayAllPendingClaims();
	
	public List<ReimbursementRequest> displayAllApprovedClaims();
	
	public List<ReimbursementRequest> findClaimsByEmployeeNo(int empNo);
	
	public void approveClaimByNo(int remNo);
	
	public void denyClaimByNo(int remNo);
	

}
