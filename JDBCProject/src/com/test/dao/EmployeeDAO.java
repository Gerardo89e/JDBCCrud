package com.test.dao;

import java.util.List;

public interface EmployeeDAO {
	 // define some CRUD operations here
	  public List<Employee> getAllEmployees();
	  public List<Employee> getEmployeesByLocation(String location);
	  public void updateEmployeeById(int id);
	  public void deleteEmployeeById(int id);
	  public void addEmployee(Employee e);
	  public void selectDept();
}
