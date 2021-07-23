package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateClaim
 */
public class CreateClaim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClaim() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setContentType("text/html");
		
		int empNo = Integer.parseInt(request.getParameter("empno"));
		request.setAttribute("empNo", empNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/createClaim.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		EmployeeServiceImpl ep = new EmployeeServiceImpl();
		int empNo = Integer.parseInt(request.getParameter("empno"));
		int remAmount = Integer.parseInt(request.getParameter("remamount"));
		String remActivity = request.getParameter("remactivity");
		System.out.println(empNo + " " + remAmount + " " + remActivity);
		ep.createReimbursementClaim(empNo, remAmount, remActivity);
		ArrayList<ReimbursementRequest> pendingClaims = ep.getPendingClaimByEmpNo(empNo);
		request.setAttribute("pendingClaims", pendingClaims);
		ArrayList<ReimbursementRequest> resolvedClaims = ep.getResolvedClaimByEmpNo(empNo);
		request.setAttribute("resolvedClaims", resolvedClaims);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/reimbursement.jsp");
		rd.forward(request, response);
	}

}
