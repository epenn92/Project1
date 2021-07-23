package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateEmployeeLoginServlet
 */
public class CheckEmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmployeeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		
		String name = request.getParameter("Username");
		String password = request.getParameter("Password");
		System.out.println(name + " " + password);
		EmployeeServiceImpl ep = new EmployeeServiceImpl();
		if (ep.passwordCheck(name, password) != 0) {
//			System.out.println("Works");
			int empNo = ep.passwordCheck(name, password);
			Employee emp = ep.findByEmployeeNo(empNo);
			System.out.println(emp);
			request.setAttribute("emp", emp);
			if (ep.managerCheck(empNo)) {
				Manager mag = ep.findManagerInfo(empNo);
				request.setAttribute("mag", mag);
				System.out.println(mag);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ManagerHomepage.html");
				rd.forward(request, response);
				
			}
			else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
			rd.forward(request, response);
			}
		} else {
			response.sendRedirect(request.getContextPath() + "");
//			RequestDispatcher rd = request.getRequestDispatcher("index.html");
//			rd.include(request, response);
			System.out.println("Incorrect username/password");
		}
		
		
		pw.close();
		
//		response.setContentType("text/html");//setting the content type  
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/employeeLoginCreation.html");
//		rd.include(request, response);
//		
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
////		String name = request.getParameter("Username");
////		String password = request.getParameter("Password");
////		System.out.println(name + " " + password);
////	
//////		EmployeeServiceImpl ep = new EmployeeServiceImpl();
//////		ep.passwordCheck(request.getParameter("Username"), request.getParameter("Password"));
//		
//	}

}
