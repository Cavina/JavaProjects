package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InstructorAccessor {

	private Connection connection;

	public InstructorAccessor() {
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
	
	public void writeInstructor(Instructor i) throws SQLException
	{
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO instructortable (firstName, lastName, gender, address, phone, zip, bdate, email, deptName, deptID ) "
			+ "VALUES ('"+i.getFirstName()+"', '"+i.getLastName()+"', '"+i.getGender()+"', '"+i.getAddress()+"', '"+i.getPhoneNumber()+"', "
					+ " '"+i.getZipCode()+"', '"+i.getBirthDate()+"','"+i.getEmail()+"', '"+i.getInstructorDepartment()+"', '"+i.getDeptID()+"')");
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
	
	
	
	
	
	public void deleteInstructor(Instructor i)
	{
		Statement stmnt;
		try {
			stmnt = connection.createStatement();
			String sql = "DELETE FROM instructortable WHERE idinstructorTable = '"+i.getInstructorID()+"'";
			stmnt.execute(sql);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public ObservableList<Instructor> getInstructorList() throws SQLException {
        try (
            Statement stmnt = connection.createStatement();
            ResultSet result = stmnt.executeQuery("SELECT * FROM instructortable");
        ){
            ObservableList<Instructor> instructorList = FXCollections.observableArrayList();
            while (result.next()) {
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String gender = result.getString("gender");
                String address=  result.getString("address");
                String phone=  result.getString("phone");
                String zip=  result.getString("zip");
                String bd =  result.getString("bdate");
                String email = result.getString("email");
                int id = result.getInt("idinstructorTable");
                int dID = result.getInt("deptID");
                String dName = result.getString("deptName");
                Instructor instructor = new Instructor(firstName, lastName, gender, address, phone, zip,
                		bd, email, id, dName, dID);
                instructorList.add(instructor);
                
            }
            return instructorList;
        } 
    }
	
	public int getIDByName(String s)
	{
		int id = 0;
		Statement stmnt;
		try {
			stmnt = connection.createStatement();
			ResultSet result = stmnt.executeQuery("SELECT deptID FROM departments WHERE name = '"+s+"'");
			while(result.next())
			{
			id = result.getInt("deptID");
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return id;
	}
	
	public void updateInstructor(Instructor i)
	{
		try 
		{
		String query = ( "UPDATE instructortable"
				+ " SET firstName = '"+i.getFirstName()+"', lastName = '"+i.getLastName()+"',"
						+ "gender = '"+i.getGender()+"', address = '"+i.getAddress()+"', "
								+ "phone = '"+i.getPhoneNumber()+"', zip = '"+i.getZipCode()+"',"
										+ "bdate = '"+i.getBirthDate()+"', email = '"+i.getEmail()+"',"
												+ "deptName = '"+i.getInstructorDepartment()+"'"
						
												+"WHERE idinstructorTable = '"+i.getInstructorID()+"'");
		
			Statement stmnt = connection.createStatement();
			stmnt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
