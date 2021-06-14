package com.test.dao;

public class Dept {
	private int deptno;
	private String deptname;
	private String deptloc;
	
	private Dept(){
			
	}
	private Dept(int deptno,String deptloc, String name) {
		super();
		this.deptname=name;
		this.deptno=deptno;
		this.deptloc=deptloc;
	}
	public void setDeptloc(String deptloc) {
		this.deptloc=deptloc;
	}
	public void setDeptName(String deptname) {
		this.deptname=deptname;
	}
	public void setDeptID(int deptno) {
		this.deptno=deptno;
	}
	public int getDeptID() {
		return deptno;
	}
	public String getDeptName() {
		return deptname;
	}
	public String getDeptLoc() {
		return deptloc;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", deptname=" + deptname + ", deptloc=" + deptloc + "]";
	}
}
