package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class enrollAccessor {
	
	Connection connection;
	public enrollAccessor()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
	
		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/schoolsystem","root", "Million6901");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		
		
	}
	
	public void writeEnrollment(Enrollment enroll)
	{
		Statement statement = null;
		try {
			
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO enrollmenttable (studentid, sectionid) "
			+ "VALUES ('"+enroll.getStudentID()+"', '"+enroll.getSectionNumber()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				statement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void deleteEnrollment(int eid)
	{
		Statement stmnt;
		try {
			stmnt = connection.createStatement();
			String sql = "DELETE FROM enrollmenttable WHERE idenrollmenttable = '"+eid+"'";
			stmnt.execute(sql);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public ObservableList<Enrollment> getEnrollmentsByID(int studentid) throws SQLException
	{
	
		  try (
		            Statement stmnt = connection.createStatement();
		            ResultSet result = stmnt.executeQuery("SELECT * FROM enrollmenttable where studentid = '"+studentid+"'");
		        ){
		            ObservableList<Enrollment> enrollmentList = FXCollections.observableArrayList();
		            while (result.next()) {
		                int enrollmentid = result.getInt("enrollmenttableid");
		                int studentID = result.getInt("studentid");
		                int sectionID = result.getInt("sectionid");
		          
		                
		                Enrollment enrollment = new Enrollment(enrollmentid, studentID, sectionID);
		                
		                enrollmentList.add(enrollment);
		                
		            }
		            return enrollmentList;
		        } 
	}
	
	public ObservableList<Course> filterCourseList(String p1, String p2, String p3) throws SQLException {
		Statement stmnt;
		ResultSet result;
       
		
            stmnt = connection.createStatement();
 
        	if (p2 == null && p3 == null)
        	{
            result = stmnt.executeQuery("SELECT * FROM coursetable WHERE semester = '"+p1+"'");
        	}	
        	else if (p3 == null)
        	{
        		result = stmnt.executeQuery("SELECT * FROM coursetable WHERE semester = '"+p1+"' AND year = '"+p2+"'");
        	}
        	else
        	{
        		result = stmnt.executeQuery("SELECT * FROM coursetable WHERE semester = '"+p1+"' AND year = '"+p2+"'"
        				+ "AND department = '"+p3+"'");

        	}
            
            ObservableList<Course> courseList = FXCollections.observableArrayList();
            while (result.next()) {
                String courseName = result.getString("coursename");
                String courseNum = result.getString("coursenum");
                String semester = result.getString("semester");
                String year = result.getString("year");
                int y = Integer.parseInt(year);
                String instructor = result.getString("instructor");
                int id = result.getInt("idcoursetable");
                String dept = result.getString("department");
          
                String dsc = result.getString("description");
                
                Course course = new Course(courseName, dsc, courseNum, semester,
                		y, id, instructor, dept);
                
                courseList.add(course);
                
            }
            return courseList;
        } 
	
	
	
	public ObservableList<Course> getCoursesByStudentID(int studentid) throws SQLException
	{
	
		  try (
		            Statement stmnt = connection.createStatement();
		            ResultSet result = stmnt.executeQuery("SELECT enrollmenttable.idenrollmenttable, coursetable.coursenum,"
		            		+ "coursetable.coursename, coursetable.idcoursetable FROM enrollmenttable "
		            		+ "INNER JOIN coursetable ON enrollmenttable.sectionid = coursetable.idcoursetable WHERE enrollmenttable.studentid = '"+studentid+"'");
		        ){
		            ObservableList<Course> enrolledList = FXCollections.observableArrayList();
		            while (result.next()) {
		                int enrollmentid = result.getInt("idenrollmenttable");
		                String coursenum = result.getString("coursenum");
		                int sectionID = result.getInt("idcoursetable");
		                String name = result.getString("coursename");
		          
		                
		               Course course = new Course(name, coursenum, sectionID, enrollmentid);
		               
		                
		                enrolledList.add(course);
		                
		            }
		            return enrolledList;
		        } 
	}

}
