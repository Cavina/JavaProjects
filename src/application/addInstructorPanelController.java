package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;

import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.RadioButton;

import javafx.scene.control.DatePicker;

public class addInstructorPanelController {
	@FXML
	private RadioButton mButton;
	@FXML
	private ToggleGroup radioGroup;
	@FXML
	private RadioButton fButton;
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField addressField;
	@FXML
	private TextField zipField;
	@FXML
	private TextField phoneField;
	@FXML
	private TextField emailField;
	@FXML
	private DatePicker bdate;
	@FXML
	private Button submitButton;
	@FXML
	private Button resetButton;
	@FXML 
	private ComboBox<String> deptSelect;

	private DeptAccessor db;
	private InstructorAccessor instructorDB;
	
	
	
	
	@FXML
	private void initialize()
	{
		db = new DeptAccessor();
		instructorDB = new InstructorAccessor();
		ObservableList<Department> deptList;
		try {
			deptList = db.getDepartmentList();
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
		

		
	}
	// Event Listener on Button[#submitButton].onAction
	@FXML
	public void handleSubmit(ActionEvent event) {
		Instructor instructor = null;
		String firstName, lastName, address, zip, phone,
		email, bd, gender,dept;
		int deptID;
		
		firstName = firstNameField.getText();
		lastName = lastNameField.getText();
		address = addressField.getText();
		zip = zipField.getText();
		phone = phoneField.getText();
		bd = bdate.getValue().toString();
		email = emailField.getText();
		if (mButton.isSelected())
		{
			gender = "Male";
		}
		else
		{
		gender = "Female";
		}
		dept = deptSelect.getValue();
		deptID = instructorDB.getIDByName(dept);
		
		instructor = new Instructor(firstName, lastName, gender, address, phone, zip, bd, email,  dept, deptID);
		try {
			instructorDB.writeInstructor(instructor);
			submitButton.getScene().getWindow().hide();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	// Event Listener on Button[#resetButton].onAction
	@FXML
	public void handleReset(ActionEvent event) {
		firstNameField.clear();
		lastNameField.clear();
		addressField.clear();
		zipField.clear();
		phoneField.clear();
		emailField.clear();
		bdate.getEditor().clear();
		bdate.setValue(null);
		deptSelect.getEditor().clear();
		deptSelect.setValue(null);
		
	}
}
