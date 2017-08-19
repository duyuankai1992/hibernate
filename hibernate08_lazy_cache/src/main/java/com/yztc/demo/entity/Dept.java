package com.yztc.demo.entity;

import java.util.Set;

public class Dept {
	
	private Integer deptNo;
	private String dname;
	private String loc;
	
	
	
	public Dept() {
	}

	public Dept(Integer deptNo, String dname) {
		super();
		this.deptNo = deptNo;
		this.dname = dname;
	}

	private Set<Emp> emps;

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
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

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	
	
}
