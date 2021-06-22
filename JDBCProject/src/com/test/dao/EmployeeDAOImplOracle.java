package com.test.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.Employee;

import jdbcTest.ConnectionUtil;

public class EmployeeDAOImplOracle implements EmployeeDAO{
	 public List<Employee> getAllEmployees() {
		    String QUERY = "select deptno,dname,loc from dept";

		    List<Employee> list = new ArrayList<>();
		    try (Connection con = ConnectionUtil.getConnection();
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(QUERY)) {
	      while (rs.next()) {
	        Employee dept = Employee.st.getInstance();
	        dept.setDeptID(rs.getInt("deptno"));
	        dept.setDeptName(rs.getString("dname"));
	        dept.setDeptloc(rs.getString("loc"));
	        list.add(dept);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
			return list;
		  };
		  public List<Employee> getEmployeesByLocation(String location) {
		    List<Employee> list = new ArrayList<>();
		    // JDBC code here...
			return list;
		  }
		@Override
		public void updateEmployeeById(int id) {
			// TODO Auto-generated method stub
			int row=0;
		    String QUERY = "UPDATE dept SET dname=? WHERE deptno=?";
		    Employee empt=Employee.st.getInstance();
		    try (Connection conn = ConnectionUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(QUERY)) {
		        stmt.setString(1, empt.getDeptName());
		        stmt.setInt(2,empt.getDeptID());
		        row = stmt.executeUpdate();
		      } catch (SQLException e) {
		        System.out.println("Row cannot be updated");
		      }
			//String QUERY = "UPDATE dept SET dname='ITS80' WHERE deptno=?";
			 /*try (Connection conn = ConnectionUtil.getConnection();
		             java.sql.PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) 
		     {	preparedStatement.setInt(1, 80);
		        row = preparedStatement.executeUpdate();
		         // rows affected
		         System.out.println(row);
		    	 
		     }catch( SQLException e)
		     {
		    	 System.out.println(" Row cannot be updated");
		     }*/
			 //  return row;
		}
		
		@Override
		public void deleteEmployeeById(int id) {
			// TODO Auto-generated method stub
			int row=0;
		    String QUERY = "Delete from dept where deptno = ?";
		    try (Connection conn = ConnectionUtil.getConnection();
		            PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
		          preparedStatement.setInt(1,id);
		          row = preparedStatement.executeUpdate();
		        } catch (SQLException e) {
		          System.out.println("Row cannot be deleted");
		        }
			//String QUERY = "Delete from dept where deptno = ?";
		    /* 
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
		     }*/
			  // return row; 
		}
		
		@Override
		public void addEmployee(Employee e) {
			// TODO Auto-generated method stub
		    String QUERY = "insert into dept_jdbc values(?,?,?)";
			//String QUERY = "insert into dept values(80, 'Marketing', 'Reston')";
		    try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(QUERY)) {
					//Statement stmt1 = con.createStatement();
				 //int result = stmt1.executeUpdate(QUERY);
		    	 stmt.setInt(1,e.getDeptID());
		         stmt.setString(2, e.getDeptName());
		         stmt.setString(3, e.getDeptLoc());
		         int result = stmt.executeUpdate();
		         if (result == 1) {
		             System.out.println("update succesfull");
		           }
		         } catch (SQLException e1) {
		           e1.printStackTrace();
		         } catch (NumberFormatException e1) {
		           System.out.println("Number expected, please try again");
		         }
		         /*System.out.println(" Result is :"+result);
			     if (result==1) 
			    	System.out.println(" Data Inserted");
			     else
			    	 System.out.println(" Issue in data insertion ");
			    } catch (SQLException e1) {e1.printStackTrace(); }
			    */
		}

		@Override
		public void selectDept(int deptNo) {
			// TODO Auto-generated method stub
		    String QUERY = "select deptno, dname, loc from dept where deptno = ?";

			//String QUERY = "select deptno,dname,loc from dept";
		    try (Connection conn = ConnectionUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(QUERY)){
		    	//Statement stmt1=conn.createStatement();
		    	stmt.setInt(1, deptNo);
		        ResultSet rs = stmt.executeQuery();
		        if (rs.next()) {
		          //Employee dept = Employee.st.getInstance();
		          //dept.setDeptID(rs.getInt("deptNo"));
		          //dept.setDeptName(rs.getString("dname"));
		          //dept.setDeptloc(rs.getString("loc"));
		          System.out.println("Connection");
		            System.out.print("ID: " + rs.getInt(deptNo));
		            System.out.println("After : " + stmt.toString());

		          //System.out.println(dept.getDeptID() + "," +dept.getDeptName()+ "," +dept.getDeptLoc() );
		        }
		      } catch (SQLException e) {
		        System.out.println("Department cannot be found.");
		      }
		      //return dept;
		}
		    	/*	Statement stmt = con.createStatement();
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
		}*/
		

	/*@Override
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
	public int udpateDept(Employee dept) {
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
	public int deleteDept(Employee dept) {
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
	}*/
}
