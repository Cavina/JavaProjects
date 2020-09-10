package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class mainController {
	@FXML
	private Button peopleBarButton;
	@FXML
	private Button coursesBarButton;
	@FXML
	private Button deptBarButton;
	@FXML
	private Button enrollmentBarButton;
	@FXML
	private AnchorPane subPane;
	@FXML
	private Button peopleButton;
	@FXML
	private Button CandDButton;
	@FXML
	private Button enrollmentButton;
	
	
    private StudentAccessor studentDB;
	
	public mainController()
	{
		studentDB = new StudentAccessor();
	}

	@FXML 
	void initialize()
	{
		peopleButton.setOnAction(ev ->{
        try {
			System.out.println("Hello");
			peopleButton.getScene().getWindow().hide();
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
		
		

		peopleBarButton.setOnAction(ev ->{
        try {
			System.out.println("Hello");
			peopleBarButton.getScene().getWindow().hide();
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
		
		CandDButton.setOnAction(e -> {
			try {
				System.out.println("Hello");
				CandDButton.getScene().getWindow().hide();
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
		
		coursesBarButton.setOnAction(e -> {
			try {
				System.out.println("Hello");
				coursesBarButton.getScene().getWindow().hide();
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
		
		deptBarButton.setOnAction(e -> {
			try {
				System.out.println("Hello");
				deptBarButton.getScene().getWindow().hide();
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
		
		enrollmentButton.setOnAction(e -> {
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
		
		enrollmentBarButton.setOnAction(e -> {
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
	}
	
	
	

}
