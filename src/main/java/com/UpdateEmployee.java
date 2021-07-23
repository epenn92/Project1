package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEmployee
 */
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
//		int empNo = request.getParameterValues(empNo);
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		request.setAttribute("empNo", empNo);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/updateEmployee.jsp");
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
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phonenumber");
		ep.updateEmployee(empNo, firstName, lastName, email, phoneNumber);
		Employee emp = ep.findByEmployeeNo(empNo);
		request.setAttribute("emp",emp);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
		rd.forward(request, response);
	};

}
