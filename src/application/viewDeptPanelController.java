package application;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class viewDeptPanelController {
	@FXML
	private TableView<Department> deptTable;
	@FXML
	private TableColumn<Department, String> deptNameCol;
	@FXML
	private TableColumn<Department, String> deptHeadCol;
	@FXML
	private TableColumn<Department, Integer> idCol;
	@FXML
	private TableColumn<Department, String> deptDescCol;
	@FXML
	private TextField filterField;
	@FXML
	private Button editButton;
	@FXML
	private Button deleteButton;
	
	private DeptAccessor db;
	private ObservableList<Department> deptList;
	
	public viewDeptPanelController()
	{
		db = new DeptAccessor();
		try {
			deptList = db.getDepartmentList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void initialize()
	{
		  deptNameCol.setCellValueFactory(new PropertyValueFactory<Department, String>("name"));
		  deptHeadCol.setCellValueFactory(new PropertyValueFactory<Department, String>("deptHead"));
		  
		  deptDescCol.setCellValueFactory(new PropertyValueFactory<Department, String>("descr"));
		  
		  idCol.setCellValueFactory(new PropertyValueFactory<Department, Integer>("DeptID"));
		 
		  
		  
		  deleteButton.setOnAction(e -> {
			  Department d = deptTable.getSelectionModel().getSelectedItem();
			  try {
			  db.deleteDepartment(d);
			  try {
					deptList = db.getDepartmentList();
				} catch (SQLException ev) {
					ev.printStackTrace();
				}
			  }catch (Exception ev)
			  {
				  JOptionPane.showMessageDialog(null, "Sorry, but you have to make sure all courses are deleted from this department before deleting!");
			  }
			  
			  FilteredList<Department> filteredData = new FilteredList<>(deptList, p-> true);
			  
			  filterField.textProperty().addListener((observable, oldValue, newValue) -> {
				  filteredData.setPredicate( department -> {
				  if (newValue == null || newValue.isEmpty())
				  {
					  return true;
				  }
				  String lowerCaseFilter = newValue.toLowerCase();
				  
				  if (department.getName().toLowerCase().contains(lowerCaseFilter))
				  {
					  return true;
				  }
				  else if (department.getDeptHead().toLowerCase().contains(lowerCaseFilter))
				  {
					  return true;
				  }
				  else if (department.getDeptID().toString().contains(lowerCaseFilter))
				  {
					  return true;
				  }
				  return false;
			  });
				  
		});
			  SortedList<Department> sortedData = new SortedList<>(filteredData);
			  sortedData.comparatorProperty().bind(deptTable.comparatorProperty());
			  
			  deptTable.setItems(sortedData);
			  
			  
		  });
          FilteredList<Department> filteredData = new FilteredList<>(deptList, p-> true);
		  
		  filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			  filteredData.setPredicate( department -> {
			  if (newValue == null || newValue.isEmpty())
			  {
				  return true;
			  }
			  String lowerCaseFilter = newValue.toLowerCase();
			  
			  if (department.getName().toLowerCase().contains(lowerCaseFilter))
			  {
				  return true;
			  }
			  else if (department.getDeptHead().toLowerCase().contains(lowerCaseFilter))
			  {
				  return true;
			  }
			  else if (department.getDeptID().toString().contains(lowerCaseFilter))
			  {
				  return true;
			  }
			  return false;
		  });
			  
	});
		  SortedList<Department> sortedData = new SortedList<>(filteredData);
		  sortedData.comparatorProperty().bind(deptTable.comparatorProperty());
		  
		  deptTable.setItems(sortedData);
		  
	}
}
