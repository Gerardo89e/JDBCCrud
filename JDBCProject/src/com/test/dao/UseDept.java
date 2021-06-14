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
		DepartmentDAOImple imp= new DepartmentDAOImple();
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
			imp.selectDept();
			break;
		}case 2: 
		{
			String QUERY = "insert into dept values(80, 'Marketing', 'Reston')";
			System.out.println("Please insert the info: ");
			Scanner scan=new Scanner(System.in);
			int deptId = scan.nextInt();
			String deptSector = scan.nextLine();
			String deptStuff = scan.nextLine();

			imp.insertNewDept(choice);
			break;
		}case 3:
		{	int n= imp.udpateDept(null);
		System.out.println("Row updated");
		break;
	}
	case 4: 
	{
		int n=imp.deleteDept(null);
		 System.out.println("Row deleted : "+n);
		break;
	}
	case 5: 
	{
		imp.useStoredProcedure();
		 System.out.println("Row inserted using procedure");
		break;
	}	
		
	}
		}while(choice !=6);
	}
	}


