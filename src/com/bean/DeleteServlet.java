package com.bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("t3");
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		EmpBean eb=new EmpBean();
		eb.setId(Integer.parseInt(id));
		EmpDao ed=(EmpDao)ctx.getBean("empimpl");
		if(ed.delete(eb))
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("Last.jsp");
			rd.forward(request, response);
		}
		else
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("InvalidOp.jsp");
			rd.include(request, response);
		
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
