package com.test.dao;

import java.util.List;

public interface DeptDAO {
	void selectDept();
	
	void insertNewDept(int Id);
	
	int udpateDept(Dept dept);
	
	int deleteDept(Dept dept);
	
	void useStoredProcedure();
	// define some CRUD operations here
	  public List<Dept> getAllEmployees();
	  public List<Dept> getEmployeesByLocation(String location);
	  public void updateEmployeeById(int id);
	  public void deleteEmployeeById(int id);
	  public void addEmployee(Dept e);
}
