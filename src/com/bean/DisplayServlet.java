package com.bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<EmpBean> l=new ArrayList<>();
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		EmpBean eb=new EmpBean();
		PrintWriter out=response.getWriter();
		EmpDao ed=(EmpDao)ctx.getBean("empimpl");
		l=ed.display();
		 ListIterator<EmpBean> 
         iterator = l.listIterator(); 

     // Printing the iterated value 
		  out.println(" Emp Id--Name--Age--Role--Phone Number");
		  out.println("<br>");

     while (iterator.hasNext()) { 
        out.println("Value is \n: "
                            + iterator.next()); 
        out.println(" <br>");
        
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
