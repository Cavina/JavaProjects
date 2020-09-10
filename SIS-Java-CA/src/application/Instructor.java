package application;
/*Instructor object inherits from Person Object
 */

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/*
 * Instructor has three constructors.
 * Holds data for an Instructor object
 */
public class Instructor extends Person{

	private SimpleIntegerProperty instructorID, deptID;
	private SimpleStringProperty deptName;
	
	
	/*Constructor accepts all the parameters for creating a full Instructor object
	 * including ID.  Passes appropriate data to Person object. 
	 *
	 */
	/**
	 * @param fn String for first name
	 * @param ln String for last name
	 * @param g String for gender
	 * @param addr String for street address
	 * @param pNum String for phone number
	 * @param z String for zip code
	 * @param bDate String for birthdate
	 * @param em String for email
	 * @param id int for Instructor ID
	 * @param dept String for assigned Department
	 */
	public Instructor(String fn, String ln, String g, String addr, String pNum, String z, 
			String bDate, String em, int id, String dept, int dID)
	{
		super(fn, ln, g, addr, pNum, z, bDate, em);
		this.instructorID = new SimpleIntegerProperty(id);
		this.deptName= new SimpleStringProperty(dept);
		this.deptID = new SimpleIntegerProperty(dID);
	}
	
	public Instructor(String fn, String ln, String g, String addr, String pNum, String z, 
			String bDate, String em, int id, String dept)
	{
		super(fn, ln, g, addr, pNum, z, bDate, em);
		this.instructorID = new SimpleIntegerProperty(id);
		this.deptName= new SimpleStringProperty(dept);
		
	}
	
	
	public Instructor(String fn, String ln, String g, String addr, String pNum, String z, 
			String bDate, String em,  String dept, int dID)
	{
		super(fn, ln, g, addr, pNum, z, bDate, em);
		
		this.deptName= new SimpleStringProperty(dept);
		this.deptID = new SimpleIntegerProperty(dID);
	}
	
	/*
	 * This constructor creates an Instructor object, not including the ID and department
	 */
	/**
	 * 
	 * @param fn String for first name
	 * @param ln String for last name
	 * @param g String for gender
	 * @param addr String for street address
	 * @param pNum String for phone number
	 * @param z String for zip code
	 * @param bDate String for birthdate
	 * @param em String for email
	 */
	public Instructor(String fn, String ln, String g, String addr, String pNum, String z, String bDate, String em)
	{
		super(fn, ln, g, addr, pNum, z, bDate, em);
	}
	public Instructor(String fn, String ln, String g, String addr, String pNum, String z, String bDate, String em,
			int id)
	{
		super(fn, ln, g, addr, pNum, z, bDate, em);
	}
	
	
	/*
	 * This constructor creates and Instructor object not including the ID
	 */
	/**
	 * 
	 * @param fn String for first name
	 * @param ln String for last name
	 * @param g String for gender
	 * @param addr String for address
	 * @param pNum String for phone number
	 * @param z String for zip code
	 * @param bDate String for birthdate
	 * @param em String for email
	 * @param dept String for department
	 */
	public Instructor(String fn, String ln, String g, String addr, String pNum, 
			String z, String bDate, String em, String dept)
	{
		super(fn, ln, g, addr, pNum, z, bDate, em);
		this.deptName = new SimpleStringProperty(dept);
	}
	
	
	/*
	 * Sets this objects instructor ID
	 */
	/**
	 * 
	 * @param id int for ID
	 */
	public void setInstructorID(int id)
	{
		if (id < 0)
		{
			throw new IllegalArgumentException("Invalid ID. Must be greater than zero");
		}
		this.instructorID.set(id);
	}
	
	public Integer getDeptID()
	{
		return (Integer) deptID.get();
	}
	
	/**
	 * 
	 * @return int for Instructor ID
	 */
	public Integer getInstructorID()
	{
		return (Integer) instructorID.get();
	}
	
	/* Set Instructor Department */
	/**
	 * 
	 * @param d String for department
	 */
	public void setInstructorDepartment(String d)
	{
		if(d.isEmpty())
		{
			throw new IllegalArgumentException("Department cannot be empty");
		}
		this.deptName.set(d);
	}
	
	/**
	 * 
	 * @return String for Department name
	 */
	public String getInstructorDepartment()
	{
		return deptName.get();
	}
	
	
	/**
	 * Returns String with all information 
	 */
	@Override
	public String toString()
	{
		String message;
		message = String.format("%s\nInstructor Department: %s\nInstructor ID: %d", super.toString(), deptName, instructorID);
		return message;
	}

}
