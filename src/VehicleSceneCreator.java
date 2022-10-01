



import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;


public class VehicleSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	//list of Cities
	
	//Flow pane
	FlowPane buttonFlowPane;
	//Grid Panes
	GridPane rootGridPane,inputFieldsPane;
	//second scene buttons
	Button newVehicleBtn,updateVehicleBtn,deleteVehicleBtn,backBtn,searchVehicleBtn;
	//second scene labels
	Label numberLbl,nameLbl,fuelLbl,typeLbl,cubicLbl,priceLbl,vehicleLbl,heightLbl,bagLbl,seatsLbl,doorsLbl;
	//second scene textfields
	TextField numberField,nameField,fuelField,typeField,cubicField,priceField,vehicleField,heightField,bagField,seatsField,doorsField;
	//TableView
	TableView<Vehicle> vehicleTableView;
	ComboBox<String> comboBox;
	private String choise;
	public VehicleSceneCreator(double width , double height) {
		super(width,height);
		
		vehiclelist = new ArrayList<>();
		rootGridPane = new GridPane();
		buttonFlowPane = new FlowPane();
		numberLbl = new Label("Number: ");
		nameLbl = new Label("Name: ");
		fuelLbl = new Label("Fuel: ");
		typeLbl = new Label("Type: ");
		cubicLbl = new Label("Cubic: ");
		priceLbl = new Label("Price: ");
		vehicleLbl = new Label("Vehicle: ");
		heightLbl = new Label("Seat height: ");
		bagLbl = new Label("Baggage System: ");
		seatsLbl = new Label("Amount of Seats: ");
		doorsLbl = new Label("Number of doors: ");
		numberField = new TextField();
		nameField = new TextField();
		fuelField = new TextField();
		typeField = new TextField();
		cubicField = new TextField();
		priceField = new TextField();
		vehicleField = new TextField();
		heightField = new TextField();
		bagField = new TextField();
		seatsField= new TextField();
		doorsField= new TextField();
		newVehicleBtn = new Button("New Vehicle");
		searchVehicleBtn = new Button("Search Vehicle");
		updateVehicleBtn = new Button("Update Vehicle");
		deleteVehicleBtn = new Button("Delete");
		backBtn = new Button("Go Back");
		inputFieldsPane = new GridPane();
		vehicleTableView = new TableView<>();
		comboBox = new ComboBox<>();
		
		//attack events
		backBtn.setOnMouseClicked(this);
		newVehicleBtn.setOnMouseClicked(this);
		updateVehicleBtn.setOnMouseClicked(this);
		deleteVehicleBtn.setOnMouseClicked(this);
		searchVehicleBtn.setOnMouseClicked(this);
		//Customize flowpane
		buttonFlowPane.setHgap(10);
		
		buttonFlowPane.getChildren().add(comboBox);
		buttonFlowPane.getChildren().add(newVehicleBtn);
		//buttonFlowPane.getChildren().add(searchVehicleBtn);
		buttonFlowPane.getChildren().add(updateVehicleBtn);
	    buttonFlowPane.getChildren().add(deleteVehicleBtn);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		//Combo Box
		comboBox.setPromptText("Choose type of vehicle");
		comboBox.getItems().addAll("TwoWheeled","Car");
		comboBox.setOnAction(e -> choise=comboBox.getValue());
		
		
		
		
		//Customize gridPane
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		
		inputFieldsPane.add(nameLbl,0,1);
		inputFieldsPane.add(nameField,1,1);
		inputFieldsPane.add(numberLbl,0,0);
		inputFieldsPane.add(numberField,1,0);
		
		inputFieldsPane.add(fuelLbl,0,2);
		inputFieldsPane.add(fuelField,1,2);
		inputFieldsPane.add(typeLbl,0,3);
		inputFieldsPane.add(typeField,1,3);
		inputFieldsPane.add(cubicLbl,0,4);
		inputFieldsPane.add(cubicField,1,4);
		inputFieldsPane.add(priceLbl,0,5);
		inputFieldsPane.add(priceField,1,5);
		
		
		inputFieldsPane.add(vehicleLbl, 0, 6);
		inputFieldsPane.add(vehicleField, 1, 6);
		//Two wheeled
		inputFieldsPane.add(heightLbl, 0, 7);
		inputFieldsPane.add(heightField, 1, 7);
		inputFieldsPane.add(bagLbl, 0, 8);
		inputFieldsPane.add(bagField, 1, 8);
		inputFieldsPane.add(seatsLbl, 0, 9);
		inputFieldsPane.add(seatsField, 1, 9);
		inputFieldsPane.add(doorsLbl, 0, 10);
		inputFieldsPane.add(doorsField, 1, 10);
		
		//Customize rootScene2
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(vehicleTableView, 0, 0);
		rootGridPane.add(buttonFlowPane, 0, 2);
		rootGridPane.add(backBtn, 1, 2);
		//Customize tablewView
		TableColumn<Vehicle,String> numberColumn = new TableColumn<>("Number");
		numberColumn.setCellValueFactory(new PropertyValueFactory<>("VehNum"));
		vehicleTableView.getColumns().add(numberColumn);
		TableColumn<Vehicle,String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
		vehicleTableView.getColumns().add(nameColumn);
		TableColumn<Vehicle,String> fuelColumn = new TableColumn<>("Fuel");
		fuelColumn.setCellValueFactory(new PropertyValueFactory<>("fuel"));
		vehicleTableView.getColumns().add(fuelColumn);
		TableColumn<Vehicle,String> typeColumn = new TableColumn<>("Type");
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		vehicleTableView.getColumns().add(typeColumn);
		TableColumn<Vehicle,String> cubicColumn = new TableColumn<>("Cubic");
		cubicColumn.setCellValueFactory(new PropertyValueFactory<>("cubic"));
		vehicleTableView.getColumns().add(cubicColumn);
		TableColumn<Vehicle,String> priceColumn = new TableColumn<>("Price");
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
		vehicleTableView.getColumns().add(priceColumn);
		TableColumn<Vehicle,String> vehicleColumn = new TableColumn<>("Vehicle");
		vehicleColumn.setCellValueFactory(new PropertyValueFactory<>("vehicle"));
		vehicleTableView.getColumns().add(vehicleColumn);
		TableColumn<Vehicle,String> heightColumn = new TableColumn<>("Seat height");
		heightColumn.setCellValueFactory(new PropertyValueFactory<>("HeightSeat"));
		vehicleTableView.getColumns().add(heightColumn);
		TableColumn<Vehicle,String> bagColumn = new TableColumn<>("Store System");
		bagColumn.setCellValueFactory(new PropertyValueFactory<>("StoreSystem"));
		vehicleTableView.getColumns().add(bagColumn);
		TableColumn<Vehicle,String> seatsColumn = new TableColumn<>("Number of seats");
		seatsColumn.setCellValueFactory(new PropertyValueFactory<>("SeatsNum"));
		vehicleTableView.getColumns().add(seatsColumn);
		TableColumn<Vehicle,String> doorsColumn = new TableColumn<>("Number of Doors");
		doorsColumn.setCellValueFactory(new PropertyValueFactory<>("DoorsNum"));
		vehicleTableView.getColumns().add(doorsColumn);
	}
	public Scene createScene() {
		return new Scene(rootGridPane,width,height);
	}
	public void handle(MouseEvent event) {
		if (event.getSource() == backBtn) {
			Main.mainStage.setTitle("Rental System");
			Main.mainStage.setScene(Main.mainScene);
	}
		if (event.getSource() == newVehicleBtn) {
			// name = model
			String name = nameField.getText();
			if(Pattern.matches("[a-zA-Z]+",name)) {
				
				
		     String number_test = numberField.getText();
			 if(number_test.matches("[0-9]+")) {
			    int number = Integer.parseInt(numberField.getText());
			String fuel = fuelField.getText();
			if(fuel.equals("Petrol")||fuel.equals("petrol")||fuel.equals("Diesel")||fuel.equals("diesel")) {
			String type = typeField.getText();
			if(Pattern.matches("[a-zA-Z]+",type)) {
				String cubic_test = cubicField.getText();
				if(cubic_test.matches("[0-9]+")) {
			       int cubic = Integer.parseInt(cubicField.getText());
			       String price_test =priceField.getText();
			       if(price_test.matches("[0-9]+")) {
			          int price = Integer.parseInt(priceField.getText());
			
			          String vehicle = choise;//den xreiazetai elegxo
			          String height_test=heightField.getText();
			          if(height_test.matches("[0-9]+")) {
			             int height = Integer.parseInt(heightField.getText());
			
			             String bag = bagField.getText();
			             if(Pattern.matches("[a-zA-Z]+",bag)) {
			            	 
			             
			                 String seats_test = seatsField.getText();
			            	 
			            	 if(seats_test.matches("[0-9]+")) {
			            		 int seats = Integer.parseInt(seatsField.getText());
			            	 
			            		 String doors_test = doorsField.getText();
			            		 if(doors_test.matches("[0-9]+")) {
			                         int doors = Integer.parseInt(doorsField.getText());
			
			                            createVehicle(number,name,fuel,type,cubic,price,height,bag,seats,doors);
			                             tableSync();
			                              clearTextFields();}
			            		 else {AlertBox.display("Error", doors_test);
			            		 
			            		 }}
			            	 else {AlertBox.display("Error", seats_test);}
			             }else {AlertBox.display("Error", bag);}
			          }else {AlertBox.display("Error", height_test);}
			       }else {AlertBox.display("Error", price_test);}
				}else {AlertBox.display("Error", cubic_test);}
			}else {AlertBox.display("Error", type);}
			}else {AlertBox.display("Error", fuel);}
			 }else {AlertBox.display("Error", number_test);}
			}else {AlertBox.display("Error", name);}
	}
		if(event.getSource()==updateVehicleBtn) {
			
			Vehicle indexes = vehicleTableView.getSelectionModel().getSelectedItem();
			String name = nameField.getText();
			if(Pattern.matches("[a-zA-Z]+",name)) {
				
				
		     
			String fuel = fuelField.getText();
			if(fuel.equals("Petrol")||fuel.equals("petrol")||fuel.equals("Diesel")||fuel.equals("diesel")) {
			String type = typeField.getText();
			if(Pattern.matches("[a-zA-Z]+",type)) {
				String cubic_test = cubicField.getText();
				if(cubic_test.matches("[0-9]+")) {
			       int cubic = Integer.parseInt(cubicField.getText());
			       String price_test =priceField.getText();
			       if(price_test.matches("[0-9]+")) {
			          int price = Integer.parseInt(priceField.getText());
			
			          String vehicle = choise;//den xreiazetai elegxo
			          String height_test=heightField.getText();
			          if(height_test.matches("[0-9]+")) {
			             int height = Integer.parseInt(heightField.getText());
			
			             String bag = bagField.getText();
			             if(Pattern.matches("[a-zA-Z]+",bag)) {
			            	 
			             
			                 String seats_test = seatsField.getText();
			            	 
			            	 if(seats_test.matches("[0-9]+")) {
			            		 int seats = Integer.parseInt(seatsField.getText());
			            	 
			            		 String doors_test = doorsField.getText();
			            		 if(doors_test.matches("[0-9]+")) {
			                         int doors = Integer.parseInt(doorsField.getText());
			                            if(vehicle.equals("Car")) {
			                            updateVehicle(name,fuel,type,cubic,price,height,Integer.parseInt(bag),indexes);
			                             tableSync();
			                              clearTextFields();}
			                            else if(vehicle.contentEquals("TwoWheeled")) {
			                            	updateVehicle(name,fuel,type,cubic,price,seats,doors,indexes);
			                            }
			                            	}
			            		 else {AlertBox.display("Error", doors_test);
			            		 
			            		 }}
			            	 else {AlertBox.display("Error", seats_test);}
			             }else {AlertBox.display("Error", bag);}
			          }else {AlertBox.display("Error", height_test);}
			       }else {AlertBox.display("Error", price_test);}
				}else {AlertBox.display("Error", cubic_test);}
			}else {AlertBox.display("Error", type);}
			}else {AlertBox.display("Error", fuel);}
			}else {AlertBox.display("Error", name);}}
	
		if(event.getSource()==deleteVehicleBtn) {
			Vehicle indexes = vehicleTableView.getSelectionModel().getSelectedItem();
			vehicleTableView.getItems().remove(indexes);
			deleteVehicle(indexes);
			tableSync();
			clearTextFields();
		}
		if(event.getSource()==vehicleTableView) {
			Vehicle selectedVehicle = vehicleTableView.getSelectionModel().getSelectedItem();
			if(selectedVehicle != null) {
				nameField.setText(selectedVehicle.getModel());
				
				numberField.setText(Integer.toString(selectedVehicle.getVehNum()));
				fuelField.setText(selectedVehicle.getFuel());
				typeField.setText(selectedVehicle.getType());
				cubicField.setText(Integer.toString(selectedVehicle.getCubic()));
				priceField.setText(Integer.toString(selectedVehicle.getCost()));
			}
		}
		
		

}
	public void createVehicle(int number,String name,String fuel,String type,int cubic,int cost,int veh1,String bag,int seats,int doors) {
		
			
			//Vehicle vehicle = new Car(name,number,fuel,type,cubic,cost);	
		
		Vehicle vehicle = new Car(name,number,fuel,type,cubic,cost,seats,doors);
		vehiclelist.add(vehicle);
	}
	
	public void updateVehicle(String name,String fuel,String type,int cubic,int price,int veh1,int veh2,Vehicle indexes) {
		for (Vehicle vehicle:vehiclelist) {
			if(vehicle.getVehNum()==indexes.getVehNum()){
				vehicle.setModel(name);
				vehicle.setFuel(fuel);
				vehicle.setType(type);
				vehicle.setCubic(cubic);
				vehicle.setCost(price);
				
			}
		}
	}
	public void deleteVehicle(Vehicle indexes) {
		for(int i=0;i<storelist.size();i++) {
			if(vehiclelist.get(i).getVehNum()==indexes.getVehNum()) {
				vehiclelist.remove(i);
				break;
			}
		}
	}
	public void tableSync() {
		List<Vehicle> items = vehicleTableView.getItems();
		items.clear();
		for(Vehicle vehicle: vehiclelist) {
			if(vehicle instanceof Vehicle) {
				items.add((Vehicle)vehicle);
			}
		}
		
	}
	public void clearTextFields() {
		numberField.setText("");
		nameField.setText("");
		fuelField.setText("");
		typeField.setText("");
		cubicField.setText("");
		priceField.setText("");
	}
	
}
