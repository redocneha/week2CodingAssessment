package com.bean;

public class EmpBean {
private  int id;
private String pwd;
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPh_num() {
	return ph_num;
}

public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

private String name;
private  int age;
private String role;
private String ph_num;
public void setPh_num(String ph_num) {
	// TODO Auto-generated method stub
	this.ph_num = ph_num;
	
}
@Override
public String toString() {
	return "EmpBean [id=" + id + ", name=" + name + ", age=" + age + ", role=" + role + ", ph_num="
			+ ph_num + "]";
}
}
