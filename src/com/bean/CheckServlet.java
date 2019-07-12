package com.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name=request.getParameter("t1");
		String pwd=request.getParameter("t2");
		PrintWriter out=response.getWriter();
		VerifyJavaBean jd=new VerifyJavaBean();
		System.out.println("ENTERED CHECK SEVLET");
		if(jd.check(name,pwd)==true)
		{
			System.out.println("ENTERED corect info");
			RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");
			rd.forward(request, response);
		}
		else
		{
			out.println("<h1>sorry invalid credentials</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("Invalid.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}