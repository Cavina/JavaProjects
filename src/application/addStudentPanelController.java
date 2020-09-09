package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;

import javafx.scene.control.TextField;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;

import javafx.scene.control.RadioButton;

import javafx.scene.control.DatePicker;

public class addStudentPanelController {
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

	private StudentAccessor studentDBAccess;
	
	public addStudentPanelController(StudentAccessor db)
	{
		studentDBAccess = db;
	}
	// Event Listener on Button[#submitButton].onAction
	@FXML
	public void handleSubmit(ActionEvent event) {
		Student student = null;
		String firstName, lastName, address, zip, phone,
		email, bd, gender;
		try {
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
		
		
		student = new Student(firstName, lastName, gender, address, phone, zip, bd, email);
		studentDBAccess.writeStudent(student);
		submitButton.getScene().getWindow().hide();
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Must enter all fields");
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
	}
}
