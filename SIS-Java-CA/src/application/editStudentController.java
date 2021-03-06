package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;

import javafx.scene.control.TextField;

import java.time.LocalDate;

import javafx.event.ActionEvent;

import javafx.scene.control.RadioButton;

import javafx.scene.control.DatePicker;

public class editStudentController {
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
	private TextField idField;
	@FXML
	private Button submitButton;
	@FXML
	private Button resetButton;

	private Student student;
	
	private StudentAccessor studentDB;
	
	public editStudentController(Student s)
	{
		student = s;
		studentDB = new StudentAccessor();
	}
	@FXML 
	void initialize()
	{
		
		firstNameField.setText(student.getFirstName());
		lastNameField.setText(student.getLastName());
		String gender = student.getGender();
		if (gender.equals("Male"))
		{
			mButton.setSelected(true);
			mButton.requestFocus();
		}
		else if (gender.equals("Female"))
		{
			fButton.setSelected(true);
			fButton.requestFocus();
		}
		addressField.setText(student.getAddress());
		zipField.setText(student.getZipCode());
		
		phoneField.setText(student.getPhoneNumber());
		emailField.setText(student.getEmail());
		String bday = student.getBirthDate();
		LocalDate date = LocalDate.parse(bday);
		bdate.setValue(date);
		idField.setText(Integer.toString(student.getStudentID()));
		
		
		
	}
	
	@FXML
	public void handleSubmit(ActionEvent event) {
		Student student = null;
		String firstName, lastName, address, zip, phone,
		email, bd, gender;
		
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
		int id = Integer.parseInt(idField.getText());
		
		student = new Student(firstName, lastName, gender, address, phone, zip, bd, email, id);
		studentDB.updateStudent(student);
		
		submitButton.getScene().getWindow().hide();
	}
	// Event Listener on Button[#resetButton].onAction
	@FXML
	public void handleReset(ActionEvent event) {
		// TODO Autogenerated
	}
}
