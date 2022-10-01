



import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;


public class RentalSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	//list of Cities
	
	//Flow pane
	FlowPane buttonFlowPane;
	//Grid Panes
	GridPane rootGridPane,inputFieldsPane;
	//second scene buttons
	Button newRentalBtn,updateRentalBtn,deleteRentalBtn,backBtn;
	//second scene labels
	Label numberLbl,nameLbl,vehiclenumLbl,depstoreLbl,arrstoreLbl,depdateLbl,deptimeLbl,arrdateLbl,arrtimeLbl,costLbl;
	//second scene textfields
	TextField numberField,nameField,vehiclenumField,depstoreField,arrstoreField,depdateField,deptimeField,arrdateField,arrtimeField,costField;
	//TableView
	TableView<Rental> rentalTableView;
	public RentalSceneCreator(double width , double height) {
		super(width,height);
		
		rentallist = new ArrayList<>();
		rootGridPane = new GridPane();
		buttonFlowPane = new FlowPane();
		numberLbl = new Label("Number: ");
		vehiclenumLbl = new Label("VehicleNumber: ");
		nameLbl = new Label("Name: ");
		depstoreLbl = new Label("Departure Store: ");
		depdateLbl = new Label("Departure Date: ");
		deptimeLbl = new Label("Departure Time: ");
		arrdateLbl = new Label("Arrival Date: ");
		arrtimeLbl = new Label("Arrival Time: ");
		arrstoreLbl = new Label("Arrival Store: ");
		costLbl = new Label("Total Cost: ");
		numberField = new TextField();
		nameField = new TextField();
		vehiclenumField = new TextField();
		depstoreField = new TextField();
		arrstoreField = new TextField();
		depdateField = new TextField();
		deptimeField = new TextField();
		arrdateField = new TextField();
		arrtimeField = new TextField();
		costField = new TextField();
		newRentalBtn = new Button("New Rental");
		updateRentalBtn = new Button("Update");
		deleteRentalBtn = new Button("Cancel rental");
		backBtn = new Button("Go Back");
		inputFieldsPane = new GridPane();
		rentalTableView = new TableView<>();
		
		//attack events
		backBtn.setOnMouseClicked(this);
		newRentalBtn.setOnMouseClicked(this);
		updateRentalBtn.setOnMouseClicked(this);
		deleteRentalBtn.setOnMouseClicked(this);
		
		
		//Customize flowpane
		buttonFlowPane.setHgap(10);
		buttonFlowPane.getChildren().add(newRentalBtn);
		//buttonFlowPane.getChildren().add(updateCityBtn);
		buttonFlowPane.getChildren().add(deleteRentalBtn);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		//Customize gridPane
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		inputFieldsPane.add(numberLbl,0,0);
		inputFieldsPane.add(numberField,1,0);
		inputFieldsPane.add(nameLbl,0,1);
		inputFieldsPane.add(nameField,1,1);
		inputFieldsPane.add(vehiclenumLbl,0,2);
		inputFieldsPane.add(vehiclenumField,1,2);
		inputFieldsPane.add(depstoreLbl,0,3);
		inputFieldsPane.add(depstoreField,1,3);
		inputFieldsPane.add(depdateLbl,0,4);
		inputFieldsPane.add(depdateField,1,4);
		inputFieldsPane.add(deptimeLbl,0,5);
		inputFieldsPane.add(deptimeField,1,5);
		inputFieldsPane.add(arrdateLbl,0,7);
		inputFieldsPane.add(arrdateField,1,7);
		inputFieldsPane.add(arrtimeLbl,0,8);
		inputFieldsPane.add(arrtimeField,1,8);
		inputFieldsPane.add(arrstoreLbl,0,6);
		inputFieldsPane.add(arrstoreField,1,6);
		inputFieldsPane.add(costLbl,0,9);
		inputFieldsPane.add(costField,1,9);
		
		//Customize rootScene2
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(rentalTableView, 0, 0);
		rootGridPane.add(buttonFlowPane, 0, 2);
		rootGridPane.add(backBtn, 1, 2);
		//Customize tablewView
		TableColumn<Rental,String> numberColumn = new TableColumn<>("Number");
		numberColumn.setCellValueFactory(new PropertyValueFactory<>("rentalCode"));
		rentalTableView.getColumns().add(numberColumn);
		TableColumn<Rental,String> vehColumn = new TableColumn<>("Vehicle Number");
		vehColumn.setCellValueFactory(new PropertyValueFactory<>("vehRent"));
		rentalTableView.getColumns().add(vehColumn);
		TableColumn<Rental,String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("clientRent"));
		rentalTableView.getColumns().add(nameColumn);
		TableColumn<Rental,String> storerentColumn = new TableColumn<>("Store Rent");
		storerentColumn.setCellValueFactory(new PropertyValueFactory<>("storeRent"));
		rentalTableView.getColumns().add(storerentColumn);
		TableColumn<Rental,String> daterentColumn = new TableColumn<>("Date rented");
		daterentColumn.setCellValueFactory(new PropertyValueFactory<>("dateRent"));
		rentalTableView.getColumns().add(daterentColumn);
		TableColumn<Rental,String> timerentColumn = new TableColumn<>("Time rented");
		timerentColumn.setCellValueFactory(new PropertyValueFactory<>("timeRent"));
		rentalTableView.getColumns().add(timerentColumn);
		TableColumn<Rental,String> storereturnColumn = new TableColumn<>("Store Return");
		storereturnColumn.setCellValueFactory(new PropertyValueFactory<>("storeReturn"));
		rentalTableView.getColumns().add(storereturnColumn);
		TableColumn<Rental,String> datereturnColumn = new TableColumn<>("Date return");
		datereturnColumn.setCellValueFactory(new PropertyValueFactory<>("dateReturn"));
		rentalTableView.getColumns().add(datereturnColumn);
		TableColumn<Rental,String> timereturnColumn = new TableColumn<>("Time return");
		timereturnColumn.setCellValueFactory(new PropertyValueFactory<>("timeReturn"));
		rentalTableView.getColumns().add(timereturnColumn);
		TableColumn<Rental,String> costColumn = new TableColumn<>("Total Cost");
		costColumn.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
		rentalTableView.getColumns().add(costColumn);
		
		
		
	}
	public Scene createScene() {
		return new Scene(rootGridPane,width,height);
	}
	public void handle(MouseEvent event) {
		if (event.getSource() == backBtn) {
			Main.mainStage.setTitle("Rental System");
			Main.mainStage.setScene(Main.mainScene);
	}
		if (event.getSource() == newRentalBtn) {
			
			
			
			
			//dinoume ton monadiko kodiko kai auxanetai
			int number = Main.MaxCode;
			Main.MaxCode++;
			int vehiclenum = Integer.parseInt(vehiclenumField.getText());
			String name = nameField.getText();
			String depstore = depstoreField.getText();
			int depdate =Integer.parseInt(depdateField.getText());
			int deptime =Integer.parseInt(deptimeField.getText());
			String arrstore = arrstoreField.getText();
			int arrdate =Integer.parseInt(arrdateField.getText());
			int arrtime =Integer.parseInt(arrtimeField.getText());
			int cost = Integer.parseInt(costField.getText());
			createRental(number,vehiclenum,name,depstore,depdate,deptime,arrstore,arrdate,arrtime,cost);
			tableSync();
			clearTextFields();
	}
		/*if(event.getSource()==updateRentalBtn) {
			City indexes = rentalTableView.getSelectionModel().getSelectedItem();
			String name = nameField.getText();
			//String number = numberField.getText();
			updateCity(name,indexes);
			tableSync();
			clearTextFields();
		}*/
		if(event.getSource()==deleteRentalBtn) {
			
			Rental indexes = rentalTableView.getSelectionModel().getSelectedItem();
			rentalTableView.getItems().remove(indexes);
			
			deleteRental(indexes);
			
			tableSync();
			clearTextFields();
			
		}
		if(event.getSource()==rentalTableView) {
			Rental selectedRental = rentalTableView.getSelectionModel().getSelectedItem();
			if(selectedRental!= null) {
				nameField.setText(selectedRental.getClientRent());
				numberField.setText(Integer.toString(selectedRental.getRentalCode()));
			}
		}
		
		

}
	public void createRental(int number,int vehiclenum,String name,String depstore,int depdate,int deptime,String arrstore,int arrdate,int arrtime,int cost) {
		Rental rental = new Rental(number,vehiclenum,name,depstore,depdate,deptime,arrstore,arrdate,arrtime,cost);
		rentallist.add(rental);
	}
	
	
	
	public void deleteRental(Rental indexes) {
		for(int i=0;i<rentallist.size();i++) {
			if(rentallist.get(i).getRentalCode()==indexes.getRentalCode()) {
				rentallist.remove(i);
				break;
			}
		}
	}
	public void tableSync() {
		List<Rental> items = rentalTableView.getItems();
		items.clear();
		for(Rental rental: rentallist) {
			if(rental instanceof Rental) {
				items.add((Rental)rental);
			}
		}
		
	}
	public void clearTextFields() {
		numberField.setText("");
		nameField.setText("");
		 vehiclenumField.setText("");
		 depstoreField.setText("");
		 deptimeField.setText("");
		 depdateField.setText("");
		 arrstoreField.setText("");
		 arrtimeField.setText("");
		 arrdateField.setText("");
		 costField.setText("");
		 
	}
	
	
}
