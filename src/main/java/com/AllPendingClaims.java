package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AllPendingClaims
 */
public class AllPendingClaims extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllPendingClaims() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper om = new ObjectMapper();
//		final StringBuilder responseText = new StringBuilder();
		String responseText = "";
		EmployeeServiceImpl ep = new EmployeeServiceImpl();
		List<ReimbursementRequest> list = ep.displayAllPendingClaims();
		responseText = om.writeValueAsString(list);
//		list.stream()
//			.forEach(e -> responseText.append(e.toString() + "\n"));
//		
		response.setContentType("application/json");
		response.setStatus(200);
		response.getWriter().write(responseText.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
