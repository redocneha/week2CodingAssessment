package com.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class checkSearchServlet
 */
public class checkSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public checkSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("t3"));
		
		PrintWriter out=response.getWriter();
		VerifyJavaBean1 jd=new VerifyJavaBean1();
		EmpBean eb=jd.check(id);
		out.println(eb);
	     
			RequestDispatcher rd=request.getRequestDispatcher("Update1.html");
			rd.include(request, response);
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
