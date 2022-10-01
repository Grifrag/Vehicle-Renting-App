



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


public class ClientsSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	//list of Cities
	
	//Flow pane
	FlowPane buttonFlowPane;
	//Grid Panes
	GridPane rootGridPane,inputFieldsPane;
	//second scene buttons
	Button newClientBtn,updateClientBtn,deleteClientBtn,backBtn,searchClientBtn;
	//second scene labels
	Label idLbl,licenseLbl,telLbl,nameLbl,surnameLbl,emailLbl,addressLbl;
	//second scene textfields
	TextField idField,licenseField,telField,nameField,surnameField,emailField,addressField;
	//TableView
	TableView<Client> clientTableView;
	public ClientsSceneCreator(double width , double height) {
		super(width,height);
		
		clientlist = new ArrayList<>();
		rootGridPane = new GridPane();
		buttonFlowPane = new FlowPane();
		idLbl = new Label("Id: ");
		licenseLbl = new Label("Driver Lisence: ");
		telLbl = new Label("Tel: ");
		nameLbl = new Label("Name: ");
		surnameLbl = new Label("Surname: ");
		emailLbl = new Label("Email: ");
		addressLbl = new Label("Address: ");
		
		idField = new TextField();
		licenseField = new TextField();
		telField = new TextField();
		nameField = new TextField();
		surnameField = new TextField();
		emailField = new TextField();
		addressField = new TextField();
		
		
		newClientBtn = new Button("New Client");
		searchClientBtn = new Button("Search Client");
		updateClientBtn = new Button("Update Client");
		deleteClientBtn = new Button("Client");
		backBtn = new Button("Go Back");
		inputFieldsPane = new GridPane();
		clientTableView = new TableView<>();
		
		//attack events
		backBtn.setOnMouseClicked(this);
		newClientBtn.setOnMouseClicked(this);
		updateClientBtn.setOnMouseClicked(this);
		deleteClientBtn.setOnMouseClicked(this);
		searchClientBtn.setOnMouseClicked(this);
		//Customize flowpane
		buttonFlowPane.setHgap(10);
		buttonFlowPane.getChildren().add(newClientBtn);
		//buttonFlowPane.getChildren().add(searchClientBtn);
		buttonFlowPane.getChildren().add(updateClientBtn);
	    buttonFlowPane.getChildren().add(deleteClientBtn);
		buttonFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		//Customize gridPane
		inputFieldsPane.setAlignment(Pos.TOP_RIGHT);
		inputFieldsPane.setVgap(10);
		inputFieldsPane.setHgap(10);
		inputFieldsPane.add(idLbl,0,0);
		inputFieldsPane.add(idField,1,0);
		inputFieldsPane.add(licenseLbl,0,1);
		inputFieldsPane.add(licenseField,1,1);
		inputFieldsPane.add(telLbl,0,2);
		inputFieldsPane.add(telField,1,2);
		inputFieldsPane.add(nameLbl,0,3);
		inputFieldsPane.add(nameField,1,3);
		inputFieldsPane.add(surnameLbl,0,4);
		inputFieldsPane.add(surnameField,1,4);
		inputFieldsPane.add(emailLbl,0,5);
		inputFieldsPane.add(emailField,1,5);
		inputFieldsPane.add(addressLbl,0,6);
		inputFieldsPane.add(addressField,1,6);
		
		
		//Customize rootScene2
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputFieldsPane, 1, 0);
		rootGridPane.add(clientTableView, 0, 0);
		rootGridPane.add(buttonFlowPane, 0, 2);
		rootGridPane.add(backBtn, 1, 2);
		//Customize tablewView
		TableColumn<Client,String> idColumn = new TableColumn<>("Id");
		idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
		clientTableView.getColumns().add(idColumn);
		TableColumn<Client,String> licenseColumn = new TableColumn<>("License");
		licenseColumn.setCellValueFactory(new PropertyValueFactory<>("DriverLic"));
		clientTableView.getColumns().add(licenseColumn);
		TableColumn<Client,String> telColumn = new TableColumn<>("Tel");
		telColumn.setCellValueFactory(new PropertyValueFactory<>("Tel"));
		clientTableView.getColumns().add(telColumn);
		TableColumn<Client,String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
		clientTableView.getColumns().add(nameColumn);
		TableColumn<Client,String> surnameColumn = new TableColumn<>("Surname");
		surnameColumn.setCellValueFactory(new PropertyValueFactory<>("Surname"));
		clientTableView.getColumns().add(surnameColumn);
		TableColumn<Client,String> emailColumn = new TableColumn<>("Email");
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
		clientTableView.getColumns().add(emailColumn);
		TableColumn<Client,String> addressColumn = new TableColumn<>("Address");
		addressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
		clientTableView.getColumns().add(addressColumn);
		
		
	}
	public Scene createScene() {
		return new Scene(rootGridPane,width,height);
	}
	public void handle(MouseEvent event) {
		if (event.getSource() == backBtn) {
			Main.mainStage.setTitle("Rental System");
			Main.mainStage.setScene(Main.mainScene);
	}
		if (event.getSource() == newClientBtn) {
			
			String test_id = idField.getText();
			if(test_id.matches("[0-9]+")) {
				int id = Integer.parseInt(idField.getText());
			
				
			String test_license = licenseField.getText();	
			if(test_license.matches("[0-9]+")) {
				int license = Integer.parseInt(licenseField.getText());

			String test_tel = telField.getText();
			if(test_tel.matches("[0-9]+")) {
				int tel = Integer.parseInt(telField.getText());
			
			String name = nameField.getText();
			if(Pattern.matches("[a-zA-Z]+",name)) {
			String surname = surnameField.getText();
			if(Pattern.matches("[a-zA-Z]+",surname)) {
			String email = emailField.getText();
			if(Pattern.matches("[a-zA-Z]+",email)) {
			String address = addressField.getText();
			if(Pattern.matches("[a-zA-Z]+",address)) {
			
			
			createClient(id,license,tel,name,surname,email,address);
			tableSync();
			clearTextFields();
			}
			else {
				AlertBox.display("Error", address);
			}
			}
			else {
				AlertBox.display("Error", email);
			}
			}
			else {
				AlertBox.display("Error", surname);
			}
			}
			else {
				AlertBox.display("Error", name);
			}
			}
			else {
				AlertBox.display("Error",test_tel);
			}
			}
			else {
				AlertBox.display("Error",test_license);
			}
			}
			else {
				AlertBox.display("Error",test_id);
			}
	}
		if(event.getSource()==updateClientBtn) {
			//String id = idField.getText();
			//String license = licenseField.getText();
			Client indexes = clientTableView.getSelectionModel().getSelectedItem();
			String test_tel = telField.getText();
			if(test_tel.matches("[0-9]+")) {
				int tel = Integer.parseInt(telField.getText());
			
			String name = nameField.getText();
			if(Pattern.matches("[a-zA-Z]+",name)) {
			String surname = surnameField.getText();
			if(Pattern.matches("[a-zA-Z]+",surname)) {
			String email = emailField.getText();
			if(Pattern.matches("[a-zA-Z]+",email)) {
			String address = addressField.getText();
			if(Pattern.matches("[a-zA-Z]+",address)) {
			
				updateClient(tel,name,surname,email,address,indexes);
				tableSync();
				clearTextFields();
			
			
			
			}
			else {
				AlertBox.display("Error", address);
			}
			}
			else {
				AlertBox.display("Error", email);
			}
			}
			else {
				AlertBox.display("Error", surname);
			}
			}
			else {
				AlertBox.display("Error", name);
			}
			}
			else {
				AlertBox.display("Error",test_tel);
			}
			
		
		}
		if(event.getSource()==deleteClientBtn) {
			Client indexes = clientTableView.getSelectionModel().getSelectedItem();
			clientTableView.getItems().remove(indexes);
			deleteClient(indexes);
			tableSync();
			clearTextFields();
		}
		if(event.getSource()==clientTableView) {
			Client selectedClient = clientTableView.getSelectionModel().getSelectedItem();
			if(selectedClient != null) {
				idField.setText(Integer.toString(selectedClient.getId()));
				licenseField.setText(Integer.toString(selectedClient.getDriverLic()));
				telField.setText(Integer.toString(selectedClient.getTel()));
			    nameField.setText(selectedClient.getName());
			    surnameField.setText(selectedClient.getSurname());
			    emailField.setText(selectedClient.getEmail());
			    addressField.setText(selectedClient.getAddress());
			}
		}
		
		

}
	public void createClient(int id,int license,int tel,String name,String surname,String email,String address) {
		Client client = new Client(id,license,tel,name,surname,email,address);
		clientlist.add(client);
	}
	
	public void updateClient(int tel,String name,String surname,String email,String address,Client indexes) {
		for (Client client:clientlist) {
			if((client.getId()==indexes.getId())){
				
				client.setTel(tel);
				client.setName(name);
				client.setSurname(surname);
				client.setEmail(email);
				client.setAddress(address);
				
			}
		}
	}
	public void deleteClient(Client indexes) {
		for(int i=0;i<clientlist.size();i++) {
			if(clientlist.get(i).getId()==indexes.getId()) {
				clientlist.remove(i);
				break;
			}
		}
	}
	public void tableSync() {
		List<Client> items = clientTableView.getItems();
		items.clear();
		for(Client client: clientlist) {
			if(client instanceof Client) {
				items.add((Client)client);
			}
		}
		
	}
	public void clearTextFields() {
		idField.setText("");
		licenseField.setText("");
		telField.setText("");
		nameField.setText("");
		surnameField.setText("");
		emailField.setText("");
		addressField.setText("");
	}
	
}
