package application;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentAccessor {
	
	private Connection connection;

	public StudentAccessor() {
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
	
	public void writeStudent(Student s) throws SQLException
	{
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO studenttable (firstName, lastName, gender, address, phone, zip, bdate, email ) "
			+ "VALUES ('"+s.getFirstName()+"', '"+s.getLastName()+"', '"+s.getGender()+"', '"+s.getAddress()+"', '"+s.getPhoneNumber()+"', "
					+ " '"+s.getZipCode()+"', '"+s.getBirthDate()+"','"+s.getEmail()+"')");
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
	
	
	
	
	
	public void deleteStudent(Student s)
	{
		Statement stmnt;
		try {
			stmnt = connection.createStatement();
			String sql = "DELETE FROM studenttable WHERE idStudentTable = '"+s.getStudentID()+"'";
			stmnt.execute(sql);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public ObservableList<Student> getStudentList() throws SQLException {
        try (
            Statement stmnt = connection.createStatement();
            ResultSet result = stmnt.executeQuery("SELECT * FROM studenttable");
        ){
            ObservableList<Student> studentList = FXCollections.observableArrayList();
            while (result.next()) {
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String gender = result.getString("gender");
                String address=  result.getString("address");
                String phone=  result.getString("phone");
                String zip=  result.getString("zip");
                String bd =  result.getString("bdate");
                String email = result.getString("email");
                int id = result.getInt("idStudentTable");
                Student student = new Student(firstName, lastName, gender, address, phone, zip,
                		bd, email, id);
                studentList.add(student);
                
            }
            return studentList;
        } 
    }
	
	public void updateStudent(Student s)
	{
		try 
		{
		String query = ( "UPDATE studenttable"
				+ " SET firstName = '"+s.getFirstName()+"', lastName = '"+s.getLastName()+"',"
						+ "gender = '"+s.getGender()+"', address = '"+s.getAddress()+"', "
								+ "phone = '"+s.getPhoneNumber()+"', zip = '"+s.getZipCode()+"',"
										+ "bdate = '"+s.getBirthDate()+"', email = '"+s.getEmail()+"'"
												+ "WHERE idStudentTable = '"+s.getStudentID()+"'");
		
			Statement stmnt = connection.createStatement();
			stmnt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	

}
