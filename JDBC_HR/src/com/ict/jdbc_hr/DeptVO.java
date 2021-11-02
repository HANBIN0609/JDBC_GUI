package com.ict.jdbc_hr;
//Dept테이블을 Object화 해서 VO(Value Object)로 만듬

public class DeptVO {

	private int deptno;
	private String dname;
	private String loc;
	
	public DeptVO() {
		this(0, "", "");
	}

	public DeptVO(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	

}
