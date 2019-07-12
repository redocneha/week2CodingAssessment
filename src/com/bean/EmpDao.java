package com.bean;

import java.util.List;

public interface EmpDao {
public boolean insertEmp(EmpBean eb);
public List display();
public boolean update(EmpBean eb);
public boolean delete(EmpBean eb);
}
