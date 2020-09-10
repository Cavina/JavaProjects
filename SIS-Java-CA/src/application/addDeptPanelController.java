package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class addDeptPanelController {
	@FXML
	private TextField deptName;
	@FXML
	private TextField deptHead;
	@FXML
	private Button submitButton;
	@FXML
	private Button resetButton;
	@FXML
	private TextField deptDescription;

	private DeptAccessor deptDB;

	
	
	public addDeptPanelController()
	{
		deptDB =  new DeptAccessor();
	}
	// Event Listener on Button[#submitButton].onAction
	@FXML
	public void handleSubmit(ActionEvent event) {
		Department dept = null;
		String name = deptName.getText();
		String head = deptHead.getText();
		String descr = deptDescription.getText();
		
		dept = new Department(name, head, descr);
		deptDB.writeDepartment(dept);
		
		
		
	}
	// Event Listener on Button[#resetButton].onAction
	@FXML
	public void handleReset(ActionEvent event) {
		deptName.clear();
		deptHead.clear();
		deptDescription.clear();
	}
}
