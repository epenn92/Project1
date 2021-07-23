package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public Employee findByEmployeeNo(int empNo) {
		// TODO Auto-generated method stub
		Employee emp = new Employee(empNo, null, null, null, null);

		String QUERY = "SELECT * FROM pemployee WHERE empNo = ?";
		try(Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		
		{
			ps.setInt(1, empNo);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp.setEmpNo(rs.getInt("empno"));
				emp.setEmpFirstName(rs.getString("firstname"));
				emp.setEmpLastName(rs.getString("lastname"));
				emp.setEmpEmail(rs.getString("email"));
				emp.setEmpPhoneNumber(rs.getString("phonenumber"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public int passwordCheck(String username, String password) {
		// TODO Auto-generated method stub
//		boolean test = false;
		int empNo = 0;
		String QUERY = "SELECT * FROM pemployee WHERE username = ? AND password = ?";
		try(Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		{
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
//			test = rs.next();
			while (rs.next()) {
				empNo = rs.getInt("empNo");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empNo;
	}

	@Override
	public List<Employee> displayAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> result = new ArrayList<>();

		String QUERY = "SELECT * FROM pemployee";
		try(Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		
		{
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpNo(rs.getInt("empno"));
				emp.setEmpFirstName(rs.getString("firstname"));
				emp.setEmpLastName(rs.getString("lastname"));
				emp.setEmpEmail(rs.getString("email"));
				emp.setEmpPhoneNumber(rs.getString("phonenumber"));
				
				result.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public void updateEmployee(int empNo, String firstname, String lastname, String email, String phonenumber) {

		String QUERY = "UPDATE pemployee SET firstname = ?, lastname = ?, email = ?, phonenumber = ? WHERE empno = ?";
		try(Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		
//				Integer empNo1 = Integer.parseInt(empNo);
		{
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, phonenumber);
			ps.setInt(5, empNo);
			
			ps.executeQuery();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void createReimbursementClaim(int empNo, int remAmount, String remActivity) {
		// TODO Auto-generated method stub
		String QUERY = "INSERT INTO premclaim VALUES(?, ?, ?, ?, ?, ?)";
		try (Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		
		{
			ps.setNull(1, Types.NULL);
			ps.setInt(2, empNo);
			ps.setString(3, remActivity);
			ps.setString(4, "pending");
			ps.setInt(5, remAmount);
			ps.setString(6, "Jim");
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<ReimbursementRequest> getPendingClaimByEmpNo(int empNo) {
		// TODO Auto-generated method stub
		ArrayList<ReimbursementRequest> result = new ArrayList<>();

		String QUERY = "SELECT * FROM premclaim WHERE empNo = ? AND remstatus = ?";
		try(Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		
//				Integer empNo1 = Integer.parseInt(empNo);
		{
			ps.setInt(1, empNo);
			ps.setString(2,  "pending");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReimbursementRequest rc = new ReimbursementRequest();
				rc.setRemNo(rs.getInt("remno"));
				rc.setEmpNo(rs.getInt("empno"));
				rc.setRemActivity(rs.getString("remactivity"));
				rc.setRemAmount(rs.getInt("remamount"));
				rc.setRemManager(rs.getString("remmanager"));
				rc.setRemStatus(rs.getString("remstatus"));
				
				result.add(rc);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	@Override
	public ArrayList<ReimbursementRequest> getResolvedClaimByEmpNo(int empNo) {
		// TODO Auto-generated method stub
		ArrayList<ReimbursementRequest> result = new ArrayList<>();

		String QUERY = "SELECT * FROM premclaim WHERE empNo = ? AND remstatus = ?";
		try(Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		
//				Integer empNo1 = Integer.parseInt(empNo);
		{
			ps.setInt(1, empNo);
			ps.setString(2, "resolved");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ReimbursementRequest rc = new ReimbursementRequest();
				rc.setRemNo(rs.getInt("remno"));
				rc.setEmpNo(rs.getInt("empno"));
				rc.setRemActivity(rs.getString("remactivity"));
				rc.setRemAmount(rs.getInt("remamount"));
				rc.setRemManager(rs.getString("remmanager"));
				rc.setRemStatus(rs.getString("remstatus"));
				
				result.add(rc);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean managerCheck(int empNo) {
		// TODO Auto-generated method stub
		
		boolean isManager = false;
		String QUERY = "SELECT * FROM manager WHERE managerno = ? AND isManager = ?";
		try(Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		
		{
			ps.setInt(1, empNo);
			ps.setString(2, "true");
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				isManager = true;
				return isManager;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isManager;
	}

	@Override
	public Manager findManagerInfo(int empNo) {
		// TODO Auto-generated method stub
		Manager mag = new Manager(empNo, true, null, null);

		String QUERY = "SELECT * FROM manager WHERE managerno = ?";
		try(Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		
//				Integer empNo1 = Integer.parseInt(empNo);
		{
			ps.setInt(1, empNo);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mag.setManagerNo(rs.getInt("managerno"));
				mag.setisManager(rs.getBoolean("ismanager"));
				mag.setManagerDepartment(rs.getString("managerdepartment"));
				mag.setManagerLocation(rs.getString("managerlocation"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mag;
	}

	@Override
	public List<ReimbursementRequest> displayAllPendingClaims() {
		// TODO Auto-generated method stub
		List<ReimbursementRequest> result = new ArrayList<>();
		
		String QUERY = "SELECT * FROM premclaim WHERE remstatus = ?";
		try(Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		
		{
			ps.setString(1,  "pending");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ReimbursementRequest rc = new ReimbursementRequest();
				rc.setRemNo(rs.getInt("remno"));
				rc.setEmpNo(rs.getInt("empno"));
				rc.setRemActivity(rs.getString("remactivity"));
				rc.setRemAmount(rs.getInt("remamount"));
				rc.setRemManager(rs.getString("remmanager"));
				rc.setRemStatus(rs.getString("remstatus"));
				
				result.add(rc);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<ReimbursementRequest> displayAllApprovedClaims() {
		// TODO Auto-generated method stub
		List<ReimbursementRequest> result = new ArrayList<>();
		
		String QUERY = "SELECT * FROM premclaim WHERE remstatus = ?";
		try(Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		
		{
			ps.setString(1, "approved");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ReimbursementRequest rc = new ReimbursementRequest();
				rc.setRemNo(rs.getInt("remno"));
				rc.setEmpNo(rs.getInt("empno"));
				rc.setRemActivity(rs.getString("remactivity"));
				rc.setRemAmount(rs.getInt("remamount"));
				rc.setRemManager(rs.getString("remmanager"));
				rc.setRemStatus(rs.getString("remstatus"));
				
				result.add(rc);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<ReimbursementRequest> findClaimsByEmployeeNo(int empNo) {
		// TODO Auto-generated method stub
		List<ReimbursementRequest> result = new ArrayList<>();
		
		String QUERY = "SELECT * FROM premclaim WHERE empNo = ?";
		try(Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		
		{
			ps.setInt(1, empNo);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ReimbursementRequest rc = new ReimbursementRequest();
				rc.setRemNo(rs.getInt("remno"));
				rc.setEmpNo(rs.getInt("empno"));
				rc.setRemActivity(rs.getString("remactivity"));
				rc.setRemAmount(rs.getInt("remamount"));
				rc.setRemManager(rs.getString("remmanager"));
				rc.setRemStatus(rs.getString("remstatus"));
				
				result.add(rc);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void approveClaimByNo(int remNo) {
		// TODO Auto-generated method stub
		String QUERY = "UPDATE premclaim SET remstatus = ? WHERE remNo = ?";
		try(Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		
		{
			ps.setString(1, "approved");
			ps.setInt(2, remNo);
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void denyClaimByNo(int remNo) {
		// TODO Auto-generated method stub
		String QUERY = "UPDATE premclaim SET remstatus = ? WHERE remNo = ?";
		try(Connection con = ConnectionUtil.getConnection();
				java.sql.PreparedStatement ps = con.prepareStatement(QUERY))
		
		{
			ps.setString(1, "denied");
			ps.setInt(2, remNo);
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
