package application;
import javafx.beans.property.*;
/*Creates a student inheriting from Person*/
//214 Bytes total
public class Student extends Person{

	private SimpleIntegerProperty studentID;
	public Student(String fn, String ln, String g, String addr, String pNum, String z, String bDate, String em)
	{
		super(fn, ln, g, addr, pNum, z, bDate, em);
	}
	
	public Student(String fn, String ln, String g, String addr, String pNum, String z, String bDate, String em, int ID)
	{
		super(fn, ln, g, addr, pNum, z, bDate, em);
		this.studentID = new SimpleIntegerProperty(ID);
	}
	
	public void setStudentID(int id)
	{
		studentID.set(id);;
		if (id < 0)
		{
			throw new IllegalArgumentException("Invalid ID. Must be greater than zero");
		}
	}
	
	public Integer getStudentID()
	{
		return (Integer) studentID.get();
	}
	
	@Override
	public String toString()
	{
		String message;
		message = String.format("%s\nStudent ID: %d", super.toString(), studentID);
		return message;
	}
}
