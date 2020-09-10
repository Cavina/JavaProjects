package application;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class enrollmentPanelController {
	
	@FXML
	private TableView<Course> enrolledTable;
	@FXML
	private TableColumn<Course, Integer> enrollIDColStudent;
	@FXML
	private TableColumn<Course, Integer> sectionIDColStudent;
	@FXML
	private TableColumn<Course, String> courseNumColStudent;
	@FXML
	private TableColumn<Course, String> courseNameColStudent;
	
	@FXML
	private TextField studentIDField;

	
	@FXML
	private TableView<Course> courseTable;
	@FXML
	private TableColumn<Course, String> courseIDColCourse;
	@FXML
	private TableColumn<Course, Integer> sectionIDColCourse;
	@FXML
	private TableColumn<Course, String> courseNameColCourse;
	@FXML
	private TableColumn<Course, String> professorNameColCourse;
	@FXML
	private TableColumn<Course, String> semesterColCourse;
	@FXML
	private TableColumn<Course, String> yearColCourse;
	@FXML
	private TableColumn<Course, String> descrColCourse;
	@FXML
	private TableColumn<Course, String> deptColCourse;
	@FXML
	private ComboBox<String> semesterBox;
	@FXML
	private ComboBox<String> yearBox;
	@FXML
	private ComboBox<String> deptBox;
	@FXML
	private Button searchButton;
	@FXML
	private Button unenrollButton;
	@FXML
	private Button enrollButton;

	
	CourseAccessor cdb;
	DeptAccessor ddb;
	enrollAccessor edb;
	
	private ObservableList<Course> courseList;
	
	public enrollmentPanelController()
	{
		cdb = new CourseAccessor();
		ddb = new DeptAccessor();
		edb = new enrollAccessor();
		try {
			courseList = cdb.getCourseList();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
	}
	
	@FXML void initialize()
	{
		courseNameColCourse.setCellValueFactory(new PropertyValueFactory
				<Course, String>("CourseName"));
		courseIDColCourse.setCellValueFactory(new PropertyValueFactory
				<Course, String>("CourseNum"));
		semesterColCourse.setCellValueFactory(new PropertyValueFactory
				<Course, String>("semester"));
		yearColCourse.setCellValueFactory(new PropertyValueFactory
				<Course, String>("year"));
		professorNameColCourse.setCellValueFactory(new PropertyValueFactory
				<Course, String>("InstructorLastName"));
		descrColCourse.setCellValueFactory(new PropertyValueFactory
				<Course, String>("CourseDescription"));	
		sectionIDColCourse.setCellValueFactory(new PropertyValueFactory
				<Course, Integer>("SectionID"));	
		deptColCourse.setCellValueFactory(new PropertyValueFactory
				<Course, String>("Department"));	
	
		ObservableList<Department> deptList;
		try {
			deptList = ddb.getDepartmentList();
			ArrayList<String> nameList = new ArrayList<>();
			int len = deptList.size();
			for (int i = 0; i < len; i++)
			{
				if (i == 0)
				{
					nameList.add("Department");
				}
				nameList.add(deptList.get(i).getName());
			}
			deptBox.getItems().addAll(nameList);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ArrayList<String> semesterList = new ArrayList<>();
		
        semesterList.add("Semester");
		semesterList.add("Winter");
		semesterList.add("Spring");
		semesterList.add("Summer");
		semesterList.add("Fall");
		
	    ArrayList<String> yearList = new ArrayList<>();
		
	    yearList.add("Year");
		yearList.add("2018");
		yearList.add("2019");
		
	    yearBox.getItems().addAll(yearList);
		//TODO add a button to handle all this to do it at once
		semesterBox.getItems().addAll(semesterList);
		
		semesterBox.setOnAction(ev -> {
			String semester = semesterBox.getValue();
			ObservableList<Course> cList = null;
			try {
				cList = edb.filterCourseList(semester, null, null);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			courseTable.setItems(cList);
			 
		});
		yearBox.setOnAction(ev -> {
			String semester = semesterBox.getValue();
			String year = yearBox.getValue();
			ObservableList<Course> cList = null;
			try {
				cList = edb.filterCourseList(semester, year, null);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			courseTable.setItems(cList);
			 
		});
		deptBox.setOnAction(ev -> {
			String semester = semesterBox.getValue();
			String year = yearBox.getValue();
			String dept = deptBox.getValue();
			ObservableList<Course> cList = null;
			try {
				cList = edb.filterCourseList(semester, year, dept);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			courseTable.setItems(cList);
			 
		});
		
		
	
	
				  
		
		
		enrollButton.setOnAction(e -> {
			int id= 0;
			Course course = courseTable.getSelectionModel().getSelectedItem();
			Enrollment enrollment= null;
			try {
			id = Integer.parseInt(studentIDField.getText());
			
			enrollment = new Enrollment(id, course.getSectionID());
			System.out.println(enrollment.getStudentID());
			edb.writeEnrollment(enrollment);
			ObservableList<Course> enrollList;
    		try {
    			enrollList = edb.getCoursesByStudentID(Integer.parseInt(studentIDField.getText()));

   
    			enrolledTable.setItems(enrollList);
    			
    			
    		 } catch (SQLException e1) {
 				
    			
    		}
			} catch (Exception ev)
			{
				JOptionPane.showMessageDialog(null, "Sorry, please enter a student ID at the top to enroll!");
			}
		});
		
		
		
		enrollIDColStudent.setCellValueFactory(new PropertyValueFactory
				<Course, Integer>("EnrollmentID"));
		sectionIDColStudent.setCellValueFactory(new PropertyValueFactory
				<Course, Integer>("SectionID"));
		courseNumColStudent.setCellValueFactory(new PropertyValueFactory
				<Course, String>("CourseNum"));
		courseNameColStudent.setCellValueFactory(new PropertyValueFactory
				<Course, String>("CourseName"));

		studentIDField.setOnKeyPressed(new EventHandler<KeyEvent>()
				{
			    @Override
			    public void handle(KeyEvent ke)
			    {
			    	if (ke.getCode().equals(KeyCode.ENTER))
			    	{
			    		enrollIDColStudent.setCellValueFactory(new PropertyValueFactory
			    				<Course, Integer>("EnrollmentID"));
			    		sectionIDColStudent.setCellValueFactory(new PropertyValueFactory
			    				<Course, Integer>("SectionID"));
			    		courseNumColStudent.setCellValueFactory(new PropertyValueFactory
			    				<Course, String>("CourseNum"));
			    		courseNameColStudent.setCellValueFactory(new PropertyValueFactory
			    				<Course, String>("CourseName"));
			    		
			    		ObservableList<Course> enrollList;
			    		try {
			    			enrollList = edb.getCoursesByStudentID(Integer.parseInt(studentIDField.getText()));
		
			   
			    			enrolledTable.setItems(enrollList);
			    			
			    			
			    		 } catch (SQLException e1) {
			 				// TODO Auto-generated catch block
			 				e1.printStackTrace();
			    			
			    		}
			    	}
			    }
				});
	
		
		unenrollButton.setOnAction(e -> {
			try {
			Course course = enrolledTable.getSelectionModel().getSelectedItem();
			edb.deleteEnrollment(course.getEnrollmentID());
			ObservableList<Course> enrollList;
			try {
    			enrollList = edb.getCoursesByStudentID(Integer.parseInt(studentIDField.getText()));

   
    			enrolledTable.setItems(enrollList);
    			
    			
    		 } catch (SQLException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
    		 }
			}catch(Exception ev)
			{
				JOptionPane.showMessageDialog(null, "Sorry! You need to make sure a valid ID is entered!");
			}
		});
		
			  
		/*
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
		  
	*/
	}
	
}
