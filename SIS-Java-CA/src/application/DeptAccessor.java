package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DeptAccessor{

	private Connection connection;

	public DeptAccessor() {
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

	public void writeDepartment(Department d)
	{
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO departments (name, head, description) "
			+ "VALUES ('"+d.getName()+"', '"+d.getDeptHead()+"', '"+d.getDescr()+"')");
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
	
	
	public void deleteDepartment(Department d)
	{
		Statement stmnt;
		try {
			stmnt = connection.createStatement();
			String sql = "DELETE FROM departments WHERE deptID = '"+d.getDeptID()+"'";
			stmnt.execute(sql);
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Sorry, but you cannot delete a Department until all courses are removed.");
			//e.printStackTrace();
		}
	}
	
	
	
	public ObservableList<Department> getDepartmentList() throws SQLException {
        try (
            Statement stmnt = connection.createStatement();
            ResultSet result = stmnt.executeQuery("SELECT * FROM departments");
        ){
            ObservableList<Department> departmentList = FXCollections.observableArrayList();
            while (result.next()) {
                String deptName = result.getString("name");
                String deptHead = result.getString("head");
                int id = result.getInt("deptID");
                System.out.println(id);
                String dsc = result.getString("description");
                
                Department department = new Department(deptName, deptHead, dsc, id);
                System.out.println(department.getDeptID());
                departmentList.add(department);
                
            }
            return departmentList;
        } 
    }
	
	
	public void updateDepartment(Department d)
	{
		Statement stmnt = null;
		try 
		{
		String query = ( "UPDATE depts"
				+ " SET name = '"+d.getName()+"', head = '"+d.getDeptHead()+"',"
						+ "description = '"+d.getDescr()+"' "
						+ "WHERE ID = '"+d.getDeptID()+"'");
		
			stmnt = connection.createStatement();
			stmnt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				stmnt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
