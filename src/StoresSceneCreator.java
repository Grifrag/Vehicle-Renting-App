



import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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


public class StoresSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	//list of Cities
	
	//Flow pane
	FlowPane buttonFlowPane;
	//Grid Panes
	GridPane rootGridPane,inputFieldsPane;
	//second scene buttons
	Button newStoreBtn,updateStoreBtn,deleteStoreBtn,backBtn,searchStoreBtn;
	//second scene labels
	Label numberLbl,nameLbl,townLbl;
	//second scene textfields
	TextField numberField,nameField,townField;
	//TableView
	TableView<Store> storeTableView;
	public StoresSceneCreator(double width , double height) {
		super(width,height);
		
		storelist = new ArrayList<>();
		rootGridPane = new GridPane();
		buttonFlowPane = new FlowPane();
		numberLbl = new Label("Number: ");
		nameLbl = new Label("Name: ");
		townLbl = new Label("Town: ");
		numberField = new TextField();
		nameField = new TextField();
		townField = new TextField();
		newStoreBtn = new Button("New Store");
		searchStoreBtn = new Button("Search Store");
		updateStoreBtn = new Button("Update Store");
		deleteStoreBtn = new Button("Delete");
		backBtn = new Button("Go Back");
		inputFieldsPane = new GridPane();
		storeTableView = new TableView<>();
		
		//attack events
		backBtn.setOnMouseClicked(this);
		newStoreBtn.setOnMouseClicked(this);
		updateStoreBtn.setOnMouseClicked(this);
		deleteStoreBtn.setOnMouseClicked(this);
		searchStoreBtn.setOnMouseClicked(this);
		//Customize flowpane
		buttonFlowPane.setHgap(10);
		buttonFlowPane.getChildren().add(newStoreBtn);
		//buttonFlowPane.getChildren().add(searchStoreBtn);
		buttonFlowPane.getChildren().add(updateStoreBtn);
	    buttonFlowPane.getChildren().add(deleteStoreBtn);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		//Customize gridPane
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		inputFieldsPane.add(nameLbl,0,0);
		inputFieldsPane.add(nameField,1,0);
		//inputFieldsPane.add(numberLbl,0,0);
		//inputFieldsPane.add(numberField,1,0);
		inputFieldsPane.add(townLbl,0,1);
		inputFieldsPane.add(townField,1,1);
		
		//Customize rootScene2
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(storeTableView, 0, 0);
		rootGridPane.add(buttonFlowPane, 0, 2);
		rootGridPane.add(backBtn, 1, 2);
		//Customize tablewView
		TableColumn<Store,String> numberColumn = new TableColumn<>("Number");
		numberColumn.setCellValueFactory(new PropertyValueFactory<>("StoreNum"));
		storeTableView.getColumns().add(numberColumn);
		TableColumn<Store,String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("StoreName"));
		storeTableView.getColumns().add(nameColumn);
		TableColumn<Store,String> townColumn = new TableColumn<>("Town");
		townColumn.setCellValueFactory(new PropertyValueFactory<>("StoreTown"));
		storeTableView.getColumns().add(townColumn);
		
		
		
	}
	public Scene createScene() {
		return new Scene(rootGridPane,width,height);
	}
	public void handle(MouseEvent event) {
		if (event.getSource() == backBtn) {
			Main.mainStage.setTitle("Rental System");
			Main.mainStage.setScene(Main.mainScene);
	}
		if (event.getSource() == newStoreBtn) {
			String name = nameField.getText();
			//Dinoume ton monadiko kodiko kai auxanetai
			if(Pattern.matches("[a-zA-Z]+",name)) {
				String town = townField.getText();
				if(Pattern.matches("[a-zA-Z]+",town)) {
					
			
			int number = Main.MaxCode;
			
			Main.MaxCode++;
			createStore(number,name,town);
			tableSync();
			clearTextFields();
				}
				else {
					AlertBox.display("Error", town);
				}
			}
			else {
				AlertBox.display("Error", name);
			}
	}
		if(event.getSource()==updateStoreBtn) {
			Store indexes = storeTableView.getSelectionModel().getSelectedItem();
			String name = nameField.getText();
			if(Pattern.matches("[a-zA-Z]+",name)) {
			String town = townField.getText();
			
			if(Pattern.matches("[a-zA-Z]+",town)) {
			
				updateStore(name,town,indexes);
			    tableSync();
			    clearTextFields();
			}
			else {
				AlertBox.display("Error", town);
			}
			}
			else {
				AlertBox.display("Error", name);
			}
		}
		if(event.getSource()==deleteStoreBtn) {
			Store indexes = storeTableView.getSelectionModel().getSelectedItem();
			deleteStore(indexes);
			//System.out.println(indexes);
			tableSync();
			clearTextFields();
		}
		if(event.getSource()==storeTableView) {
			Store selectedStore = storeTableView.getSelectionModel().getSelectedItem();
			if(selectedStore != null) {
				nameField.setText(selectedStore.getStoreName());
				numberField.setText(Integer.toString(selectedStore.getStoreNum()));
			    townField.setText(selectedStore.getStoreTown());
			}
		}
		
		

}
	public void createStore(int number,String name,String town) {
		Store store = new Store(number,name,town);
		storelist.add(store);
	}
	
	public void updateStore(String name,String town,Store indexes) {
		for (Store store:storelist) {
			if((store.getStoreNum())==indexes.getStoreNum()){
				store.setStoreName(name);
				store.setStoreTown(town);
				
				
			}
		}
	}
	public void deleteStore(Store indexes) {
		for(int i=0;i<storelist.size();i++) {
			if(storelist.get(i).getStoreNum()==indexes.getStoreNum()) {
				storelist.remove(i);
				
				break;
				
			}
		}
	}
	public void tableSync() {
		List<Store> items = storeTableView.getItems();
		items.clear();
		for(Store store: storelist) {
			if(store instanceof Store) {
				items.add((Store)store);
			}
		}
		
	}
	public void clearTextFields() {
		numberField.setText("");
		nameField.setText("");
		townField.setText("");
	}
	
}
