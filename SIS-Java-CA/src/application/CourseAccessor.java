package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CourseAccessor {
	
	private Connection connection;
	public CourseAccessor()
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
		.getConnection("jdbc:mysql://localhost:3306/schoolsystem","root", "your-pw-here");

	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}
	
	
   }
	
	
	public void writeCourse(Course c) throws SQLException
	{
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO coursetable (coursename, coursenum, semester, year, instructor, description, department ) "
			+ "VALUES ('"+c.getCourseName()+"', '"+c.getCourseNum()+"', '"+c.getSemester()+"', '"+c.getYear()+"', '"+c.getInstructorLastName()+"', "
					+ " '"+c.getCourseDescription()+"', '"+c.getDepartment()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			statement.close();
			connection.close();
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
    
	public void deleteCourse(Course c)
	{
		Statement stmnt;
		try {
			stmnt = connection.createStatement();
			String sql = "DELETE FROM coursetable WHERE idcoursetable = '"+c.getSectionID()+"'";
			stmnt.execute(sql);
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Sorry, but you cannot delete a Course until all instructors and students are removed.");
			//e.printStackTrace();
		}
	}
	
	
	
	public ObservableList<Course> getCourseList() throws SQLException {
        try (
            Statement stmnt = connection.createStatement();
            ResultSet result = stmnt.executeQuery("SELECT * FROM coursetable");
        ){
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
    }
	

}
