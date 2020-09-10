package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class viewInstructorPanelController {
	@FXML
	private TableView<Instructor> instructorTable;
	@FXML
	private TableColumn<Instructor, String> firstNameCol;
	@FXML
	private TableColumn<Instructor, String>  lastNameCol;
	@FXML
	private TableColumn<Instructor, String>  genderCol;
	@FXML
	private TableColumn<Instructor, String>  addressCol;
	@FXML
	private TableColumn<Instructor, String>  zipCol;
	@FXML
	private TableColumn<Instructor, String>  phoneCol;
	@FXML
	private TableColumn<Instructor, String>  bdayCol;
	@FXML
	private TableColumn<Instructor, String>  emailCol;
	@FXML
	private TableColumn<Instructor, Integer>  IDCol;
	@FXML
	private TableColumn<Instructor, String>  deptCol;
	@FXML
	private TextField filterField;
	@FXML
	private Button editButton;
	@FXML
	private Button deleteButton;
	
	
	
	private InstructorAccessor idb;
	private ObservableList<Instructor> instructorList;
	
	public viewInstructorPanelController()
	{
		idb = new InstructorAccessor();
		
		try {
			instructorList = idb.getInstructorList();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@FXML void initialize()
	{
		 
		
		  firstNameCol.setCellValueFactory(new PropertyValueFactory<Instructor, String>("firstName"));
		  lastNameCol.setCellValueFactory(new PropertyValueFactory<Instructor, String>("lastName"));
		  genderCol.setCellValueFactory(new PropertyValueFactory<Instructor, String>("gender"));
		  addressCol.setCellValueFactory(new PropertyValueFactory<Instructor, String>("address"));
		  zipCol.setCellValueFactory(new PropertyValueFactory<Instructor, String>("zipCode"));
		  phoneCol.setCellValueFactory(new PropertyValueFactory<Instructor, String>("phoneNumber"));
		  emailCol.setCellValueFactory(new PropertyValueFactory<Instructor, String>("email"));
		  bdayCol.setCellValueFactory(new PropertyValueFactory<Instructor, String>("birthDate"));
		  IDCol.setCellValueFactory(new PropertyValueFactory<Instructor, Integer>("instructorID"));
		  deptCol.setCellValueFactory(new PropertyValueFactory<Instructor, String>("InstructorDepartment"));
		
		  
		  
		  editButton.setOnAction(ev -> {
			  try {
			  Instructor instructor = instructorTable.getSelectionModel().getSelectedItem();
			  FXMLLoader loader = new FXMLLoader(getClass().getResource("editInstructorPanel.fxml"));
			  editInstructorPanelController controller = new editInstructorPanelController(instructor);
			  loader.setController(controller);
			  Parent root = loader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		  });
		  
		  
		  deleteButton.setOnAction(e ->{
			  Instructor i = instructorTable.getSelectionModel().getSelectedItem();
			  idb.deleteInstructor(i);
			  
			  
			  try {
					instructorList = idb.getInstructorList();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  FilteredList<Instructor> filteredData = new FilteredList<>(instructorList, p-> true);
			
			  filterField.textProperty().addListener((observable, oldValue, newValue) -> {
				  filteredData.setPredicate( instructor -> {
				  if (newValue == null || newValue.isEmpty())
				  {
					  return true;
				  }
				  String lowerCaseFilter = newValue.toLowerCase();
				  
				  if (instructor.getFirstName().toLowerCase().contains(lowerCaseFilter))
				  {
					  return true;
				  }
				  else if (instructor.getLastName().toLowerCase().contains(lowerCaseFilter))
				  {
					  return true;
				  }
				  return false;
			  });
				  
		});
			  SortedList<Instructor> sortedData = new SortedList<>(filteredData);
			  sortedData.comparatorProperty().bind(instructorTable.comparatorProperty());
			  
			  instructorTable.setItems(sortedData);
			  
		  });
		  
		  FilteredList<Instructor> filteredData = new FilteredList<>(instructorList, p-> true);
		  
		  filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			  filteredData.setPredicate( instructor -> {
			  if (newValue == null || newValue.isEmpty())
			  {
				  return true;
			  }
			  String lowerCaseFilter = newValue.toLowerCase();
			  
			  if (instructor.getFirstName().toLowerCase().contains(lowerCaseFilter))
			  {
				  return true;
			  }
			  else if (instructor.getLastName().toLowerCase().contains(lowerCaseFilter))
			  {
				  return true;
			  }
			  return false;
		  });
			  
	});
		  SortedList<Instructor> sortedData = new SortedList<>(filteredData);
		  sortedData.comparatorProperty().bind(instructorTable.comparatorProperty());
		  
		  instructorTable.setItems(sortedData);
		
		
	}

}
