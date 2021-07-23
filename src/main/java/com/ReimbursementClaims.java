package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReimbursementClaims
 */
public class ReimbursementClaims extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementClaims() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//Grab and list all claims
		
		EmployeeServiceImpl ep = new EmployeeServiceImpl();
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		request.setAttribute("empNo", empNo);
		ArrayList<ReimbursementRequest> pendingClaims = ep.getPendingClaimByEmpNo(empNo);
		request.setAttribute("pendingClaims", pendingClaims);
		ArrayList<ReimbursementRequest> resolvedClaims = ep.getResolvedClaimByEmpNo(empNo);
		request.setAttribute("resolvedClaims", resolvedClaims);
		System.out.println(ep.getPendingClaimByEmpNo(empNo));
		System.out.println(ep.getResolvedClaimByEmpNo(empNo));

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/reimbursement.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		
	}

}
