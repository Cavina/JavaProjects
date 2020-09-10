package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class coursesPanelController {
	@FXML
	private AnchorPane subPane;
	@FXML
	private Button addDeptButton;
	@FXML
	private Button viewDeptButton;
	@FXML
	private Button addCourseButton;
	@FXML
	private Button viewCourseButton;
	@FXML
	private Button peopleButtonBar;
	@FXML
	private Button coursesButtonBar;
	@FXML
	private Button deptButtonBar;
	@FXML
	private Button enrollmentButtonBar;
	private StudentAccessor studentDB;
	
	public coursesPanelController(StudentAccessor db)
	{
		studentDB = db;
		
	}
	
	@FXML
	void initialize()
	{
		peopleButtonBar.setOnAction(ev ->{
	        try {
				System.out.println("Hello");
				peopleButtonBar.getScene().getWindow().hide();
				FXMLLoader peopleLoader = new FXMLLoader(getClass().getResource("peoplePanel.fxml"));
				peoplePanelController peopleController = new peoplePanelController(studentDB);  //TODO add peoplePanelController
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
		
		addCourseButton.setOnAction(e -> {
			try {
			System.out.println("Hello");
			
			FXMLLoader addCourseLoader = new FXMLLoader(getClass().getResource("addCoursePanel.fxml"));
			addCoursePanelController addStudentController = new addCoursePanelController(); 
		    addCourseLoader.setController(addStudentController);
			Parent root = addCourseLoader.load();
			Stage addCourseStage = new Stage();
			Scene addCourseScene = new Scene(root, 600, 400);
			addCourseScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			addCourseStage.initModality(Modality.APPLICATION_MODAL);
			addCourseStage.setScene(addCourseScene);
			addCourseStage.show();
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}});
		
		viewCourseButton.setOnAction(e -> {
			try {
			System.out.println("Hello");
			
			FXMLLoader viewCourseLoader = new FXMLLoader(getClass().getResource("viewCoursePanel.fxml"));
			viewCoursePanelController viewCoursePanelController = new viewCoursePanelController(); 
		    viewCourseLoader.setController(viewCoursePanelController);
			Parent root = viewCourseLoader.load();
			Stage viewCourseStage = new Stage();
			Scene viewCourseScene = new Scene(root, 675, 450);
			viewCourseScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			viewCourseStage.initModality(Modality.APPLICATION_MODAL);
			viewCourseStage.setScene(viewCourseScene);
			viewCourseStage.show();
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}});
		
		addDeptButton.setOnAction(e -> {
			try {
			System.out.println("Hello");
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("addDeptPanel.fxml"));
			addDeptPanelController controller = new addDeptPanelController(); 
		    loader.setController(controller);
			Parent root = loader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.show();
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}});
		
		viewDeptButton.setOnAction(e -> {
			try {
			System.out.println("Hello");
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("viewDeptPanel.fxml"));
			viewDeptPanelController controller = new viewDeptPanelController(); 
		    loader.setController(controller);
			Parent root = loader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(root, 675, 425);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.show();
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}});
		
	}

}
