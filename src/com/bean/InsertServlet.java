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
 * Servlet implementation class ProcessServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("t1");
		String pwd=request.getParameter("t2");
		String id=request.getParameter("t3");
		String age=request.getParameter("t4");
		String role=request.getParameter("t5");
		String phno=request.getParameter("t6");
		System.out.println(phno);
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		EmpBean eb=new EmpBean();
		eb.setAge(Integer.parseInt(age));
		eb.setId(Integer.parseInt(id));
		eb.setName(name);
		eb.setRole(role);
		eb.setPwd(pwd);
		eb.setPh_num(phno);
		EmpDao ed=(EmpDao)ctx.getBean("empimpl");
		if(ed.insertEmp(eb))
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
