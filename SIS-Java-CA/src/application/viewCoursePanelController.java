package application;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class viewCoursePanelController {
	@FXML
	private TableView<Course> courseTable;
	@FXML
	private TableColumn<Course, String> courseNameCol;
	@FXML
	private TableColumn<Course, String>  courseNumCol;
	@FXML
	private TableColumn<Course, String>  semesterCol;
	@FXML
	private TextField filterField;
	@FXML TableColumn<Course, String>  yearCol;
	@FXML
	private TableColumn<Course, String> instructorCol;
	@FXML
	private TableColumn<Course, String> deptCol;
	@FXML
	private TableColumn<Course, Integer> sIDCol;
	@FXML
	private TableColumn<Course, String> descriptionCol;
	@FXML 
	private Button deleteButton;
	private CourseAccessor db;
	private ObservableList<Course> courseList;

	public viewCoursePanelController()
	{
		db = new CourseAccessor();
		try {
		courseList = db.getCourseList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML 
	void initialize()
	{
		courseNameCol.setCellValueFactory(new PropertyValueFactory
				<Course, String>("CourseName"));
		courseNumCol.setCellValueFactory(new PropertyValueFactory
				<Course, String>("CourseNum"));
		semesterCol.setCellValueFactory(new PropertyValueFactory
				<Course, String>("semester"));
		yearCol.setCellValueFactory(new PropertyValueFactory
				<Course, String>("year"));
		instructorCol.setCellValueFactory(new PropertyValueFactory
				<Course, String>("InstructorLastName"));
		descriptionCol.setCellValueFactory(new PropertyValueFactory
				<Course, String>("CourseDescription"));	
		sIDCol.setCellValueFactory(new PropertyValueFactory
				<Course, Integer>("SectionID"));	
		deptCol.setCellValueFactory(new PropertyValueFactory
				<Course, String>("Department"));	
	
		
		deleteButton.setOnAction(e -> {
			  Course c = courseTable.getSelectionModel().getSelectedItem();
			  db.deleteCourse(c);
			  
			  try {
					courseList = db.getCourseList();
					} catch (SQLException ev) {
						ev.printStackTrace();
					}
			  
			  FilteredList<Course> filteredData = new FilteredList<>(courseList, p-> true);
			  
				filterField.textProperty().addListener((observable, oldValue, newValue) -> {
					  filteredData.setPredicate( course -> {
					  if (newValue == null || newValue.isEmpty())
					  {
						  return true;
					  }
					  String lowerCaseFilter = newValue.toLowerCase();
					  
					  if (course.getCourseName().toLowerCase().contains(lowerCaseFilter))
					  {
						  return true;
					  }
					  else if (course.getInstructorLastName().toLowerCase().contains(lowerCaseFilter))
					  {
						  return true;
					  }
					  else if (course.getCourseNum().toString().contains(lowerCaseFilter))
					  {
						  return true;
					  }
					  return false;
				  });
					  
			});
				  SortedList<Course> sortedData = new SortedList<>(filteredData);
				  sortedData.comparatorProperty().bind(courseTable.comparatorProperty());
				  
				  courseTable.setItems(sortedData);
			  
		});
		FilteredList<Course> filteredData = new FilteredList<>(courseList, p-> true);
		  
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			  filteredData.setPredicate( course -> {
			  if (newValue == null || newValue.isEmpty())
			  {
				  return true;
			  }
			  String lowerCaseFilter = newValue.toLowerCase();
			  
			  if (course.getCourseName().toLowerCase().contains(lowerCaseFilter))
			  {
				  return true;
			  }
			  else if (course.getInstructorLastName().toLowerCase().contains(lowerCaseFilter))
			  {
				  return true;
			  }
			  else if (course.getCourseNum().toString().contains(lowerCaseFilter))
			  {
				  return true;
			  }
			  return false;
		  });
			  
	});
		  SortedList<Course> sortedData = new SortedList<>(filteredData);
		  sortedData.comparatorProperty().bind(courseTable.comparatorProperty());
		  
		  courseTable.setItems(sortedData);
		  
	}
	
}
