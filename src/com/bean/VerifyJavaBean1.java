package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VerifyJavaBean1 {
	static EmpBean check(int id) {
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Sapient123");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select* from emp");
		while(rs.next())
		{
		
		int nam1=rs.getInt(1);
		
		if(nam1==id) {

			EmpBean eb=new EmpBean();
			eb.setAge(rs.getInt(4));
			eb.setId(id);
			eb.setName(rs.getString(2));
			
			eb.setRole(rs.getString(5));
			return eb;
		
			
		}
		
		}
		
		}
		catch(Exception e)
		{
		System.out.println(e);
		return null;
	}
		return null;
	}
}

