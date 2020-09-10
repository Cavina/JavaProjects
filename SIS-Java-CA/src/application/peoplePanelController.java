package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class peoplePanelController {
	@FXML
	private Button peopleButtonBar;
	@FXML
	private Button coursesButtonBar;
	@FXML
	private Button deptButtonBar;
	@FXML
	private Button enrollmentButtonBar;
	@FXML
	private AnchorPane subPane;
	@FXML
	private Button addInstructorButtonPeople;
	@FXML
	private Button viewInstructorButtonPeople;
	@FXML
	private Button addStudentButtonPeople;
	@FXML
	private Button viewStudentButtonPeople;
	@FXML 
	
	private StudentAccessor studentDB;
	
	public peoplePanelController(StudentAccessor db)
	{
		studentDB = db;
	}
	
	
	@FXML
	void initialize()
	{
		/*
		peopleButtonBar.setOnAction(ev ->{
	        try {
				System.out.println("Hello");
				peopleButtonBar.getScene().getWindow().hide();
				FXMLLoader peopleLoader = new FXMLLoader(getClass().getResource("peoplePanel.fxml"));
				peoplePanelController peopleController = new peoplePanelController();  //TODO add peoplePanelController
			    peopleLoader.setController(peopleController);
				Parent root = peopleLoader.load();
				Stage peopleStage = new Stage();
				Scene peopleScene = new Scene(root, 600, 400);
				peopleScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				peopleStage.initModality(Modality.APPLICATION_MODAL);
				peopleStage.setScene(peopleScene);
				peopleStage.show();
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}}
			);
		*/
		coursesButtonBar.setOnAction(e -> {
			try {
				System.out.println("Hello");
				coursesButtonBar.getScene().getWindow().hide();
				FXMLLoader cdLoader = new FXMLLoader(getClass().getResource("coursesPanel.fxml"));
				coursesPanelController coursesPanelController = new coursesPanelController(studentDB);  //TODO add peoplePanelController
			    cdLoader.setController(coursesPanelController);
				Parent root = cdLoader.load();
				Stage cdStage = new Stage();
				Scene cdScene = new Scene(root, 600, 400);
				cdScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				cdStage.initModality(Modality.APPLICATION_MODAL);
				cdStage.setScene(cdScene);
				cdStage.show();
				
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});
		
		deptButtonBar.setOnAction(e -> {
			try {
				System.out.println("Hello");
				deptButtonBar.getScene().getWindow().hide();
				FXMLLoader cdLoader = new FXMLLoader(getClass().getResource("coursesPanel.fxml"));
				coursesPanelController coursesPanelController = new coursesPanelController(studentDB);  //TODO add peoplePanelController
			    cdLoader.setController(coursesPanelController);
				Parent root = cdLoader.load();
				Stage cdStage = new Stage();
				Scene cdScene = new Scene(root, 600, 400);
				cdScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				cdStage.initModality(Modality.APPLICATION_MODAL);
				cdStage.setScene(cdScene);
				cdStage.show();
				
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});
		
		
		enrollmentButtonBar.setOnAction(e -> {
			try {
				System.out.println("Hello");
				
				FXMLLoader enrollmentLoader = new FXMLLoader(getClass().getResource("enrollmentPanel.fxml"));
				
				enrollmentPanelController enrollmentController = new enrollmentPanelController(); //TODO add peoplePanelController
			    enrollmentLoader.setController(enrollmentController);
				Parent root = enrollmentLoader.load();
				Stage enrollmentStage = new Stage();
				Scene enrollmentScene = new Scene(root, 600, 450);
				enrollmentScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				enrollmentStage.initModality(Modality.APPLICATION_MODAL);
				enrollmentStage.setScene(enrollmentScene);
				enrollmentStage.show();
				
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});
		
		viewStudentButtonPeople.setOnAction(e -> {
			 try {
					System.out.println("Hello");
					
					FXMLLoader viewStudentLoader = new FXMLLoader(getClass().getResource("viewStudentPanel.fxml"));
					viewStudentPanelController viewStudentController = new viewStudentPanelController(studentDB); 
				    viewStudentLoader.setController(viewStudentController);
					Parent root = viewStudentLoader.load();
					Stage viewStudentStage = new Stage();
					Scene viewStudentScene = new Scene(root, 700, 450);
					viewStudentScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					viewStudentStage.initModality(Modality.APPLICATION_MODAL);
					viewStudentStage.setScene(viewStudentScene);
					viewStudentStage.show();
				} catch (Exception e1)
				{
					e1.printStackTrace();
				}});
		
		addStudentButtonPeople.setOnAction(e -> {
			try {
			System.out.println("Hello");
			
			FXMLLoader addStudentLoader = new FXMLLoader(getClass().getResource("addStudentPanel.fxml"));
			addStudentPanelController addStudentController = new addStudentPanelController(studentDB); 
		    addStudentLoader.setController(addStudentController);
			Parent root = addStudentLoader.load();
			Stage addStudentStage = new Stage();
			Scene addStudentScene = new Scene(root, 600, 400);
			addStudentScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			addStudentStage.initModality(Modality.APPLICATION_MODAL);
			addStudentStage.setScene(addStudentScene);
			addStudentStage.show();
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}});
		
		
		viewInstructorButtonPeople.setOnAction(e -> {
			 try {
					System.out.println("Hello");
					
					FXMLLoader viewInstructorLoader = new FXMLLoader(getClass().getResource("viewInstructorPanel.fxml"));
					viewInstructorPanelController viewInstructorController = new viewInstructorPanelController(); 
				    viewInstructorLoader.setController(viewInstructorController);
					Parent root = viewInstructorLoader.load();
					Stage viewInstructorStage = new Stage();
					Scene viewInstructorScene = new Scene(root, 800, 450);
					viewInstructorScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					viewInstructorStage.initModality(Modality.APPLICATION_MODAL);
					viewInstructorStage.setScene(viewInstructorScene);
					viewInstructorStage.show();
				} catch (Exception e1)
				{
					e1.printStackTrace();
				}});
		
		addInstructorButtonPeople.setOnAction(e -> {
			 try {
					System.out.println("Hello");
					
					FXMLLoader addInstructorLoader = new FXMLLoader(getClass().getResource("addInstructorPanel.fxml"));
					addInstructorPanelController addInstructorController = new addInstructorPanelController(); 
				    addInstructorLoader.setController(addInstructorController);
					Parent root = addInstructorLoader.load();
					Stage addInstructorStage = new Stage();
					Scene addInstructorScene = new Scene(root, 600, 400);
					addInstructorScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					addInstructorStage.initModality(Modality.APPLICATION_MODAL);
					addInstructorStage.setScene(addInstructorScene);
					addInstructorStage.show();
				} catch (Exception e1)
				{
					e1.printStackTrace();
				}});
		
	}
	

}

