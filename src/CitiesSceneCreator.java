



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


public class CitiesSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	//list of Cities
	
	//Flow pane
	FlowPane buttonFlowPane;
	//Grid Panes
	GridPane rootGridPane,inputFieldsPane;
	//second scene buttons
	Button newCityBtn,updateCityBtn,deleteCityBtn,backBtn;
	//second scene labels
	Label numberLbl,nameLbl;
	//second scene textfields
	TextField numberField,nameField;
	//TableView
	TableView<City> cityTableView;
	public CitiesSceneCreator(double width , double height) {
		super(width,height);
		
		citylist = new ArrayList<>();
		rootGridPane = new GridPane();
		buttonFlowPane = new FlowPane();
		numberLbl = new Label("Number: ");
		nameLbl = new Label("Name: ");
		numberField = new TextField();
		nameField = new TextField();
		newCityBtn = new Button("New City");
		updateCityBtn = new Button("Update");
		deleteCityBtn = new Button("Delete");
		backBtn = new Button("Go Back");
		inputFieldsPane = new GridPane();
		cityTableView = new TableView<>();
		
		//attack events
		backBtn.setOnMouseClicked(this);
		newCityBtn.setOnMouseClicked(this);
		updateCityBtn.setOnMouseClicked(this);
		deleteCityBtn.setOnMouseClicked(this);
		
		
		//Customize flowpane
		buttonFlowPane.setHgap(10);
		buttonFlowPane.getChildren().add(newCityBtn);
		buttonFlowPane.getChildren().add(updateCityBtn);
		buttonFlowPane.getChildren().add(deleteCityBtn);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		//Customize gridPane
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		inputFieldsPane.add(nameLbl,0,1);
		inputFieldsPane.add(nameField,1,1);
		//inputFieldsPane.add(numberLbl,0,0);
		//inputFieldsPane.add(numberField,1,0);
		//Customize rootScene2
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(cityTableView, 0, 0);
		rootGridPane.add(buttonFlowPane, 0, 2);
		rootGridPane.add(backBtn, 1, 2);
		//Customize tablewView
		TableColumn<City,String> numberColumn = new TableColumn<>("Number");
		numberColumn.setCellValueFactory(new PropertyValueFactory<>("cityNum"));
		cityTableView.getColumns().add(numberColumn);
		TableColumn<City,String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));
		cityTableView.getColumns().add(nameColumn);
		
		
		
	}
	public Scene createScene() {
		return new Scene(rootGridPane,width,height);
	}
	public void handle(MouseEvent event) {
		if (event.getSource() == backBtn) {
			Main.mainStage.setTitle("Rental System");
			Main.mainStage.setScene(Main.mainScene);
	}
		if (event.getSource() == newCityBtn) {
			String name = nameField.getText();
			//dinoume ton monadiko kodiko kai auxanetai
			//elegxos oti tha dwthei onoma polhs 
			if(Pattern.matches("[a-zA-Z]+",name)) {
				
			
			int number = Main.MaxCode;
			
			Main.MaxCode++;
			createCity(number,name);
			tableSync();
			clearTextFields();
			}
			else {
				AlertBox.display("Error", name);
			}
	}
		if(event.getSource()==updateCityBtn) {
			City indexes = cityTableView.getSelectionModel().getSelectedItem();
			String name = nameField.getText();
			if(Pattern.matches("[a-zA-Z]+",name)) {
			//String number = numberField.getText();
			updateCity(name,indexes);
			tableSync();
			clearTextFields();
			}
			else {
				AlertBox.display("Error", name);
			}
		}
		if(event.getSource()==deleteCityBtn) {
			
			City indexes = cityTableView.getSelectionModel().getSelectedItem();
			cityTableView.getItems().remove(indexes);
			
			deleteCity(indexes);
			
			tableSync();
			clearTextFields();
			
		}
		if(event.getSource()==cityTableView) {
			City selectedCity = cityTableView.getSelectionModel().getSelectedItem();
			if(selectedCity != null) {
				nameField.setText(selectedCity.getCityName());
				numberField.setText(Integer.toString(selectedCity.getCityNum()));
			}
		}
		
		

}
	public void createCity(int number,String name) {
		City city = new City(number,name);
		citylist.add(city);
	}
	
	public void updateCity(String name,City indexes) {
		for (City city:citylist) {
			if((city.getCityNum()==indexes.getCityNum())){
				city.setCityName(name);
				
				
			}
		}
	}
	public void deleteCity(City indexes) {
		for(int i=0;i<citylist.size();i++) {
			if(citylist.get(i).getCityNum()==indexes.getCityNum()) {
				citylist.remove(i);
				break;
			}
		}
	}
	public void tableSync() {
		List<City> items = cityTableView.getItems();
		items.clear();
		for(City city: citylist) {
			if(city instanceof City) {
				items.add((City)city);
			}
		}
		
	}
	public void clearTextFields() {
		numberField.setText("");
		nameField.setText("");
	}
	
	
}
