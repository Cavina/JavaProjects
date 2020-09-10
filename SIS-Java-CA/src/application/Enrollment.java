package application;
/*Class creates an enrollment of a student to a course.
 * 
 */

import javafx.beans.property.SimpleIntegerProperty;

public class Enrollment {

	private int  instructorID;
	private String semester, grade, courseNum, sLastName, instructorLastName, year;
	private SimpleIntegerProperty studentID, sectionNumber, enrollmentID;
	
	/**
	 * 
	 * @param s Accepts a Student object
	 * @param c Accepts a Course object
	 * @param i Accepts an Instructor object
	 */
	public Enrollment(Student s, Course c, Instructor i) {
		
		this.studentID = new SimpleIntegerProperty(s.getStudentID());
		this.sLastName = s.getLastName();
		this.sectionNumber = new SimpleIntegerProperty(c.getSectionID());
		this.semester = c.getSemester();
		this.year = c.getYear();
		this.courseNum = c.getCourseNum();
		this.instructorID = i.getInstructorID();
		this.instructorLastName = i.getLastName();
		this.grade = "NA";
	}
	
public Enrollment(int id, int sectionid) {
		
		this.studentID = new SimpleIntegerProperty(id);
		this.sectionNumber = new SimpleIntegerProperty(sectionid);
		
	}

public Enrollment(int enrollid, int studentid, int sectionid) {
	
	this.studentID = new SimpleIntegerProperty(studentid);
	this.sectionNumber = new SimpleIntegerProperty(sectionid);
	this.enrollmentID = new SimpleIntegerProperty(enrollid);
	
}
	
	/*This constructor is for rebuilding an enrollment object
	 * when a Student object, Course object, and Instructor object 
	 * is unavailable.
	 */
	/**
	 * 
	 * @param sln accepts student last name
	 * @param iln accepts instructor last name
	 * @param cnum accepts course number (cs939)
	 * @param sem accepts semester
	 * @param eid accepts enrollment id
	 * @param sid accepts student id
	 * @param cid accepts course id
	 * @param iID accepts instructor id
	 * @param y accepts year
	 */
    public Enrollment(String sln, String iln, String cnum, String sem,
	                  int eid, int sid, int cid, int iID, String y) {
		
		this.studentID = new SimpleIntegerProperty(sid);
		this.sLastName = sln;;
		this.sectionNumber = new SimpleIntegerProperty(cid);
		this.semester = sem;
		this.year = y;
		this.courseNum = cnum;
		this.instructorID = iID;
		this.instructorLastName = iln;
		this.enrollmentID = new SimpleIntegerProperty(eid);
		this.grade = "NA";
	}
	
	
    /*Allows change of an enrollment ID.
     */
    /**
     * 
     * @param id accepts a new ID number
     */
	public void setEnrollmentID(int id)
	{
		this.enrollmentID.set(id);
	}
	
	//Allows change of a grade.  Default grade is set to "NA".
	/**
	 * 
	 * @param g accepts a new Grade of [A, B, C, D, F].
	 */
	public void setGrade(String g)
	{
		this.grade = g;
	}
	
	public int getEnrollmentID(){return enrollmentID.get();}
	public int getStudentID(){return studentID.get();}
	public int getSectionNumber() {return sectionNumber.get();}
	public int getInstructorID() {return instructorID;}
	public String getYear() {return year;}
	public String getSemester() {return semester;}
	public String getGrade() {return grade;}
	public String getCourseNum() {return courseNum;}
	public String getStudentLastName() {return sLastName;}
	public String getInstructorLastName() {return instructorLastName;}
	
	public String toString()
	{
		String message = String.format("Enrollment ID: %d "
				+ "\nCourse ID: %d"
				+ "\nCourse Num: %s"
				+ "\nStudent ID: %d"
				+ "\nStudent last name: %s"
				+ "\nInstructor ID: %d"
				+ "\nInstructor last name: %s"
				+ "\nSemester: %s"
				+ "\nYear: %d", enrollmentID, sectionNumber, courseNum, studentID,
				sLastName, instructorID, instructorLastName, semester, year);
		return message;
	}

}
