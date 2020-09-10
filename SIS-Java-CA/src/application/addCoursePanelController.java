package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.control.TextArea;

public class addCoursePanelController {

	@FXML
	private TextField courseNameField;
	@FXML
	private TextField courseNumField;
	@FXML
	private ComboBox<String> semesterSelect;
	@FXML
	private ComboBox<String> deptSelect;
	@FXML
	private ComboBox<String> instructorSelect;
	@FXML
	private ComboBox<String> yearSelect;
	@FXML
	private Button submitButton;
	@FXML
	private Button resetButton;
	@FXML
	private TextArea courseDescription;

	private CourseAccessor db;
	private DeptAccessor deptDB;
	private InstructorAccessor iDB;
	public addCoursePanelController()
	{
		db = new CourseAccessor();
		deptDB = new DeptAccessor();
		iDB = new InstructorAccessor();
	
	}
	
	@FXML void initialize()
	{
		
		ObservableList<Department> deptList;
		try {
			deptList = deptDB.getDepartmentList();
			ArrayList<String> nameList = new ArrayList<>();
			int len = deptList.size();
			for (int i = 0; i < len; i++)
			{
				nameList.add(deptList.get(i).getName());
			}
			deptSelect.getItems().addAll(nameList);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deptSelect.setOnAction(e -> {
			instructorSelect.getItems().clear();
			String dept = deptSelect.getValue();
			ObservableList<Instructor> instructorList;
			try {
				instructorList = iDB.getInstructorList();
				ArrayList<String> iNameList = new ArrayList<>();
				int len = instructorList.size();
				for (int i = 0; i < len; i++)
				{
					if (instructorList.get(i).getInstructorDepartment().equals(dept))
					{
					iNameList.add(instructorList.get(i).getLastName());
				    }
				    
				}
				instructorSelect.getItems().addAll(iNameList);
			     } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}});
		
		ArrayList<String> semesterList = new ArrayList<>();
		
		semesterList.add("Winter");
		semesterList.add("Spring");
		semesterList.add("Summer");
		semesterList.add("Fall");
		
		semesterSelect.getItems().addAll(semesterList);
		
		ArrayList<String> yearList = new ArrayList<>();
		
		yearList.add("2018");
		yearList.add("2019");
		
	    yearSelect.getItems().addAll(yearList);
		
		
		
		
	}
	// Event Listener on Button[#submitButton].onAction
	@FXML
	public void handleSubmit(ActionEvent event) {
		Course course = null;
		String courseName, courseNum, semester, instructorLastName, year,
		sectionID, description, dept;
		int deptID;
		
		courseName = courseNameField.getText();
		courseNum = courseNumField.getText();
		semester = semesterSelect.getValue();
		year = yearSelect.getValue();
		dept = deptSelect.getValue();
		instructorLastName = instructorSelect.getValue();
		description = courseDescription.getText();
		
		
		
		course = new Course(courseName, description, courseNum, semester, Integer.parseInt(year), instructorLastName, dept);
		try {
			db.writeCourse(course);
			submitButton.getScene().getWindow().hide();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Event Listener on Button[#resetButton].onAction
	@FXML
	public void handleReset(ActionEvent event) {
		courseNameField.clear();
		courseNumField.clear();
		yearSelect.getEditor().clear();
		yearSelect.setValue(null);
		deptSelect.getEditor().clear();
		deptSelect.setValue(null);
		instructorSelect.getEditor().clear();
		instructorSelect.setValue(null);
		semesterSelect.getEditor().clear();
		semesterSelect.setValue(null);
		courseDescription.clear();
	}
}
