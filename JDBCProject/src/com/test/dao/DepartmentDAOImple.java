package com.test.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.Dept;

import jdbcTest.ConnectionUtil;

public class DepartmentDAOImple implements DeptDAO{
	public static void main(String[] args) {
		List<Dept> list1 = new ArrayList<Dept>();
	}

	@Override
	public void selectDept() {
		// TODO Auto-generated method stub
		String QUERY = "select deptno,dname,loc from dept";
		try(Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY)) //Try with Resources
		    {	
				while(rs.next()){
				int no = rs.getInt("deptno");
				String name = rs.getString("dname");
				String location = rs.getString("loc");
				System.out.println("Connection");
				System.out.println(no + "," +name+ "," +location );
			}//try
		} catch (SQLException e) {e.printStackTrace(); }
	}


	@Override
	public void insertNewDept(int Id) {
		// TODO Auto-generated method stub
		String QUERY = "insert into dept values(80, 'Marketing', 'Reston')";
		try(Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement())
			{ int result = stmt.executeUpdate(QUERY);
			System.out.println(" Result is :"+result);
		     if (result==1) 
		    	System.out.println(" Data Inserted");
		     else
		    	 System.out.println(" Issue in data insertion ");
		    } catch (SQLException e) {e.printStackTrace(); }
	}


	@Override
	public int udpateDept(Dept dept) {
		// TODO Auto-generated method stub
		int row=0;
		String QUERY = "UPDATE dept SET dname='ITS80' WHERE deptno=?";
		 try (Connection conn = ConnectionUtil.getConnection();
	             java.sql.PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) 
	     {	preparedStatement.setInt(1, 80);
	        row = preparedStatement.executeUpdate();
	         // rows affected
	         System.out.println(row);
	    	 
	     }catch( SQLException e)
	     {
	    	 System.out.println(" Row cannot be updated");
	     }
		   return row;
	}


	@Override
	public int deleteDept(Dept dept) {
		// TODO Auto-generated method stub
		int row=0;
		String QUERY = "Delete from dept where deptno = ?";
	     try (Connection conn = ConnectionUtil.getConnection();
	             java.sql.PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) 
	     {		
	    	 preparedStatement.setInt(1, 80);
	        row = preparedStatement.executeUpdate();
	         // rows affected
	         System.out.println(row);
	    	 
	     }catch( SQLException e)
	     {
	    	 System.out.println(" Row cannot be deleted");
	     }
		   return row; 
	}


	@Override
	public void useStoredProcedure() {
		// TODO Auto-generated method stub
		 try (Connection conn = ConnectionUtil.getConnection();
				 CallableStatement stmt=conn.prepareCall("{call INSERTROWS(?,?,?)}"))
			     {	 stmt.setInt(1,77);  
					 stmt.setString(2,"dept77");  
					 stmt.setString(3,"loc77");
					 stmt.execute();
			     } catch (SQLException e) {
					e.printStackTrace();
				}
	}
}
