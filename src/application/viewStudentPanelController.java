package application;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class viewStudentPanelController {

	@FXML
	private TableView<Student> studentTable;
	@FXML
	private TableColumn<Student, String> firstNameCol;
	@FXML
	private TableColumn<Student, String> lastNameCol;
	@FXML
	private TableColumn<Student, String> genderCol;
	@FXML
	private TableColumn<Student, String> addressCol;
	@FXML
	private TableColumn<Student, String> phoneCol;
	@FXML
	private TableColumn<Student, String> zipCol;
	@FXML
	private TableColumn<Student, String> emailCol;
	@FXML
	private TableColumn<Student, String> bdayCol;
	@FXML
	private TableColumn<Student, Integer> IDCol;
    @FXML
    private TextField filterField;
	
	@FXML
	private Button editButton;
	@FXML
	private Button deleteButton;
	private StudentAccessor studentDB;
	private ObservableList<Student> studentList;
	
	public viewStudentPanelController(StudentAccessor db)
	{
		studentDB = db;
		
		try {
			studentList = db.getStudentList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void initialize()
	{
		  firstNameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
		  lastNameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
		  genderCol.setCellValueFactory(new PropertyValueFactory<Student, String>("gender"));
		  addressCol.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));
		  zipCol.setCellValueFactory(new PropertyValueFactory<Student, String>("zipCode"));
		  phoneCol.setCellValueFactory(new PropertyValueFactory<Student, String>("phoneNumber"));
		  emailCol.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
		  bdayCol.setCellValueFactory(new PropertyValueFactory<Student, String>("birthDate"));
		  IDCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("studentID"));
		  

		
		  
		  
		  editButton.setOnAction(ev -> {
			  try {
			  Student student = studentTable.getSelectionModel().getSelectedItem();
			  FXMLLoader loader = new FXMLLoader(getClass().getResource("editStudent.fxml"));
			  editStudentController controller = new editStudentController(student);
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
			  Student s = studentTable.getSelectionModel().getSelectedItem();
			  studentDB.deleteStudent(s);
			  
			  try {
					studentList = studentDB.getStudentList();
				} catch (SQLException ev) {
					ev.printStackTrace();
				}
			  FilteredList<Student> filteredData = new FilteredList<>(studentList, p-> true);
			  
			  filterField.textProperty().addListener((observable, oldValue, newValue) -> {
				  filteredData.setPredicate( student -> {
				  if (newValue == null || newValue.isEmpty())
				  {
					  return true;
				  }
				  String lowerCaseFilter = newValue.toLowerCase();
				  
				  if (student.getFirstName().toLowerCase().contains(lowerCaseFilter))
				  {
					  return true;
				  }
				  else if (student.getLastName().toLowerCase().contains(lowerCaseFilter))
				  {
					  return true;
				  }
				  return false;
			  });
				  
		});
			  SortedList<Student> sortedData = new SortedList<>(filteredData);
			  sortedData.comparatorProperty().bind(studentTable.comparatorProperty());
			  
			  studentTable.setItems(sortedData);
		  });
		  
		  FilteredList<Student> filteredData = new FilteredList<>(studentList, p-> true);
		  
		  filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			  filteredData.setPredicate( student -> {
			  if (newValue == null || newValue.isEmpty())
			  {
				  return true;
			  }
			  String lowerCaseFilter = newValue.toLowerCase();
			  
			  if (student.getFirstName().toLowerCase().contains(lowerCaseFilter))
			  {
				  return true;
			  }
			  else if (student.getLastName().toLowerCase().contains(lowerCaseFilter))
			  {
				  return true;
			  }
			  return false;
		  });
			  
	});
		  SortedList<Student> sortedData = new SortedList<>(filteredData);
		  sortedData.comparatorProperty().bind(studentTable.comparatorProperty());
		  
		  studentTable.setItems(sortedData);
}
}
