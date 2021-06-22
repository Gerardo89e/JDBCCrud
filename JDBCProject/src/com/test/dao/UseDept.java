package com.test.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import jdbcTest.ConnectionUtil;

public class UseDept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice =0;
		EmployeeDAOImplOracle imp= new EmployeeDAOImplOracle();
		do {
			System.out.println("Choose an Option");
			System.out.println("1. List a deprtment");
			System.out.println("2. Add a deprtment");
			System.out.println("3. Update a deprtment");
			System.out.println("4. Delete a deprtment");
			System.out.println("5. Insert using StoredProcedure");
			
			Scanner sc=new Scanner(System.in);
			choice = sc.nextInt();
		switch (choice) {
		case 1:
		{  
			Scanner scan=new Scanner(System.in);
			System.out.println("Please insert the Employee Number: "); 
			int deptId = scan.nextInt();
			imp.selectDept(deptId);
			break;
		}case 2: 
		{
			Scanner scan=new Scanner(System.in);
			/*System.out.println("Please insert the Employee Number: "); 
			int deptId = scan.nextInt();
			String deptSector = scan.nextLine();
			String deptStuff = scan.nextLine();
			String QUERY = "insert into dept values(?, ?, ?)";
			*/
			/*String QUERY = "insert into dept values(80, 'Marketing', 'Reston')";
			System.out.println("Please insert the info: ");
			Scanner scan=new Scanner(System.in);
			int deptId = scan.nextInt();
			String deptSector = scan.nextLine();
			String deptStuff = scan.nextLine();
			 */
			//signleton to get the private constructor
			Employee st= Employee.st.getInstance();

			System.out.println("Enter New Department No.:");
	          st.setDeptID(Integer.parseInt(scan.nextLine()));
	          System.out.println("Enter New Department Name:");
	          st.setDeptName(scan.nextLine());
	          System.out.println("Enter New Department Location:");
	          st.setDeptloc(scan.nextLine());
			imp.addEmployee(st);
			break;
		}case 3:
		{
			Scanner scan=new Scanner(System.in);

			System.out.println("Enter The Department No. to update:");
	          Employee sg=Employee.st.getInstance();
	          System.out.println("Enter New Department Name:");
	          String str;
	          if (!(str = scan.nextLine()).equals("")) {
	            sg.setDeptName(str);
	          }
	          System.out.println("Enter New Department Location:");
	          if (!(str = scan.nextLine()).equals("")) {
	            sg.setDeptloc(str);
	          }
	         /* if (EmployeeDAOImplOracle.updateEmployeeById(Integer.parseInt(scan.nextLine())) == Integer.parseInt(scan.nextLine())) {
	            System.out.println("Update has been successful");
	          }	*/
	          imp.updateEmployeeById(Integer.parseInt(scan.nextLine()));

		//int n= imp.updateEmployeeById(Integer.parseInt(scan.nextLine());
		System.out.println("Row updated");
		break;
	}
	case 4: 
	{
		Scanner scan=new Scanner(System.in);

		 System.out.println("Enter the Department No. to delete:");
         int deptNo = Integer.parseInt(scan.nextLine());
		 imp.deleteEmployeeById(deptNo);
		// System.out.println("Row deleted : "+n);
		break;
	}
	/*case 5: 
	{
		imp.useStoredProcedure();
		 System.out.println("Row inserted using procedure");
		break;
	}	*/
		
	}
		}while(choice !=6);
	}
	}


