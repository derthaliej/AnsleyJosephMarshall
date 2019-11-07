package com.revature.bean;

public class Supervise {
	
	private int empID; 
	private int supEmp_ID;
	
	public Supervise() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Supervise(int empID, int supEmp_ID) {
		super();
		this.empID = empID;
		this.supEmp_ID = supEmp_ID;
	}


	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public int getSupEmp_ID() {
		return supEmp_ID;
	}

	public void setSupEmp_ID(int supEmp_ID) {
		this.supEmp_ID = supEmp_ID;
	}

	@Override
	public String toString() {
		return "Supervise [empID=" + empID + ", supEmp_ID=" + supEmp_ID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empID;
		result = prime * result + supEmp_ID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supervise other = (Supervise) obj;
		if (empID != other.empID)
			return false;
		if (supEmp_ID != other.supEmp_ID)
			return false;
		return true;
	}
	
	
	
	

}
