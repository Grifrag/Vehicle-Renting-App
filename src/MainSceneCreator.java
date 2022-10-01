

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{
	//FlowPane
		FlowPane rootFlowPane;
	    //Main scene buttons
		Button mainbutton,citiesBtn,storesBtn,clientsBtn,vehiclesBtn,vehicleRentalBtn;
	
	public MainSceneCreator(double width, double height) {
		super(width, height);
		rootFlowPane = new FlowPane();
		citiesBtn = new Button("Cities");
		storesBtn = new Button("Stores");
		clientsBtn = new Button("Clients");
		vehiclesBtn = new Button("Vehicles");
		vehicleRentalBtn = new Button("Vehicle Rental");
		
		
		//buttons attachments
		citiesBtn.setOnMouseClicked(this);
		storesBtn.setOnMouseClicked(this);
		vehiclesBtn.setOnMouseClicked(this);
		clientsBtn.setOnMouseClicked(this);
	    vehicleRentalBtn.setOnMouseClicked(this);
		//setup Flowpane
		rootFlowPane.setHgap(10);
		rootFlowPane.setAlignment(Pos.CENTER);
		//buttons
		rootFlowPane.getChildren().add(citiesBtn);
		rootFlowPane.getChildren().add(storesBtn);
		rootFlowPane.getChildren().add(clientsBtn);
		rootFlowPane.getChildren().add(vehiclesBtn);
		rootFlowPane.getChildren().add(vehicleRentalBtn);
	}
	
	public Scene createScene() {return new Scene(rootFlowPane,width,height);}
	public void handle(MouseEvent event) {
		if (event.getSource() == citiesBtn) {
			Main.mainStage.setTitle("Cities Managment");
			Main.mainStage.setScene(Main.citiesScene);
	}
		if (event.getSource() == storesBtn) {
			Main.mainStage.setTitle("Stores Managment");
			Main.mainStage.setScene(Main.storesScene);
	}
		if (event.getSource() == vehiclesBtn) {
			
			Main.mainStage.setTitle("Vehicles Managment");
			Main.mainStage.setScene(Main.vehiclesScene);
	}
		if (event.getSource() == clientsBtn) {
			Main.mainStage.setTitle("Clients Managment");
			Main.mainStage.setScene(Main.clientsScene);
	}
		if (event.getSource() == vehicleRentalBtn) {
			Main.mainStage.setTitle("Rental Managment");
			Main.mainStage.setScene(Main.rentalScene);
	}
	}
	
	

}
