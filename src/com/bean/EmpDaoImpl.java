package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao{
	

	@Override
	public boolean insertEmp(EmpBean eb) {
		// TODO Auto-generated method stub
		
    
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Sapient123");
	     
		PreparedStatement stmt=con.prepareStatement("insert into emp values(?,?,?,?,?,?)");
		stmt.setInt(1,eb.getId());//1 specifies the first parameter in the query 
		stmt.setString(2,eb.getName()); 
		stmt.setString(3,eb.getPwd()); 
		stmt.setInt(4,eb.getAge()); 
		stmt.setString(5,eb.getRole()); 
		
		stmt.setString(6,(eb.getPh_num())); 
		stmt.execute();
		return true;
		}
		catch(Exception e) {
		
			return false;
			}
	}

	@Override
	public List display() {
		// TODO Auto-generated method stub
		List<EmpBean> l=new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Sapient123");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select* from emp");
			while(rs.next())
			{
				EmpBean eb=new EmpBean();
			int id=rs.getInt(1);
			eb.setId(id);
			String name=rs.getString(2);
			eb.setName(name);
			int age=rs.getInt(4);
			eb.setAge(age);
			String role=rs.getString(5);
			eb.setRole(role);
			String phno=rs.getString(6);
			eb.setPh_num(phno);
		  l.add(eb);
			
		}
			return l;
		}
		catch(Exception e) {
				System.out.println(e);
			}
		return l;
	}
		

	

	@Override
	public boolean delete(EmpBean eb) {
		// TODO Auto-generated method stub
		try {
			
			int id1=eb.getId();
		
			Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Sapient123");
				Statement stmt=con.createStatement();
				PreparedStatement stmt1;
				ResultSet rs=stmt.executeQuery("select* from emp");
				while(rs.next())
				{
					int id=rs.getInt(1);
					if(id==id1)
					{
						stmt1=con.prepareStatement("delete from emp  where id=?");
					
					    stmt1.setInt(1,id1);
					    stmt1.execute();				
					    return true;
					}
				}
			
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		return false;
	}

	@Override
	public boolean update(EmpBean eb) {
		// TODO Auto-generated method stub
	

			try {
				
			int id1=eb.getId();
			int age1=eb.getAge();
			String phno1=String.valueOf(eb.getPh_num());
			Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Sapient123");
				Statement stmt=con.createStatement();
				PreparedStatement stmt1;
				ResultSet rs=stmt.executeQuery("select* from emp");
				while(rs.next())
				{
					int id=rs.getInt(1);
					if(id==id1)
					{
						stmt1=con.prepareStatement("update emp SET  age= ?  where id=?");
						stmt1.setInt(1, age1);
						stmt1.setInt(2, id1);
						stmt1.execute();
						stmt1=con.prepareStatement("update emp SET  phno= ?  where id=?");
						stmt1.setString(1, phno1);
						stmt1.setInt(2, id1);
						stmt1.execute();
						return true;
					}
				}
			
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return false;
		}
	
	

}
