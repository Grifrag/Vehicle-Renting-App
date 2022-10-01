

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;

public  abstract class SceneCreator {
	double width;
	double height;
	static ArrayList<City> citylist;
    static ArrayList<Store> storelist;
    static ArrayList<Vehicle> vehiclelist;
    static ArrayList<Client> clientlist;
    static ArrayList<Rental> rentallist;
	
	public SceneCreator(double width,double height) {
		this.width = width;
		this.height = height;
	}

	
	abstract Scene createScene();
}
