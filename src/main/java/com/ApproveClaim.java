package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ApproveClai
 */
public class ApproveClaim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveClaim() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		ObjectMapper om = new ObjectMapper();
		String responseText = "";
		EmployeeServiceImpl ep = new EmployeeServiceImpl();
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line;
	    while ((line = reader.readLine()) != null) {
	        buffer.append(line);
	        buffer.append(System.lineSeparator());
	    }
	    String data = buffer.toString();
	    System.out.println(data);
	    data = data.trim();
		int remNo = Integer.parseInt(data);
		ep.approveClaimByNo(remNo);
		List<ReimbursementRequest> list = ep.displayAllApprovedClaims();
		responseText = om.writeValueAsString(list);
		
		response.setContentType("application/json");
		response.setStatus(200);
		response.getWriter().write(responseText.toString());
	}

}
