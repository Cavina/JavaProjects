package application;

import javafx.beans.property.*;


public class Department {

	private SimpleStringProperty name, descr, deptHead;
	private SimpleIntegerProperty departmentID;
	
	
	public Department(String n, String h, String d)
	{
		this.name = new SimpleStringProperty(n);
		this.deptHead = new SimpleStringProperty(h);
		this.descr = new SimpleStringProperty(d);
	}
	
	public Department(String n, String h, String d, int id)
	{
		this.name = new SimpleStringProperty(n);
		this.deptHead = new SimpleStringProperty(h);
		this.descr = new SimpleStringProperty(d);
		this.departmentID = new SimpleIntegerProperty(id);
	}
	
	public void setName(String n)
	{
		this.name.set(n);
	}
	
	public void setDeptID(int id)
	{
		departmentID.set(id);
	}
	
	public String getName()
	{
		return this.name.get();
	}
	
	public Integer getDeptID()
	{
		return (Integer) departmentID.get();
	}

	public String getDescr() {
		return descr.get();
	}

	public void setDescr(String descr) {
		this.descr.set(descr);
	}

	public String getDeptHead() {
		return deptHead.get();
	}

	public void setDeptHead(String deptHead) {
		this.deptHead.set(deptHead);
	}
	
	public String toString()
	{
		String message = String.format("Deparment Name: %s"
				+ "\nDepartment ID: %d", name, departmentID);
		return message;
				
	}
}
