
import java.util.Scanner;
import java.util.regex.Pattern;
 //εγινε η εισαγωγη αυτης της βιβλιοθηκης για τον ελεγχο των εισαγωμενων απο τον χρηστη strings
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.event.*;
import javafx.geometry.Pos;

import java.util.ArrayList;



public class Main extends Application {
private static int citynum , storenum , vehnum , cubic , cost , seatsnum , doorsnum , id , driverlic , tel, rentalcode , totalcost;
private static String cityname , storename , storetown , model , fuel , type, storesystem , name , surname , email , address, vehrent , clientrent , storerent , storereturn , StorereturnAp;
static int MaxCode = 0 ;
private static double heightseat , daterent , timerent , datereturn , timereturn ;
static Stage mainStage;
static Scene mainScene,citiesScene,storesScene,vehiclesScene,clientsScene,rentalScene;


public void start(Stage primaryStage) {
	mainStage = primaryStage;
	SceneCreator mainSceneCreator = new MainSceneCreator( 800,500);
	SceneCreator citiesSceneCreator = new CitiesSceneCreator(800,500);
	SceneCreator storesSceneCreator = new StoresSceneCreator(800,500);
	SceneCreator vehiclesSceneCreator = new VehicleSceneCreator(800,500);
	SceneCreator clientsSceneCreator = new ClientsSceneCreator(800,500);
	SceneCreator rentalSceneCreator = new RentalSceneCreator(1000,500);
	
	mainScene = mainSceneCreator.createScene();
	citiesScene = citiesSceneCreator.createScene();
	storesScene = storesSceneCreator.createScene();
	vehiclesScene = vehiclesSceneCreator.createScene();
	clientsScene = clientsSceneCreator.createScene();
	rentalScene = rentalSceneCreator.createScene();
	
	primaryStage.setTitle("Rental System");
	primaryStage.setScene(mainScene);
	primaryStage.show();
	
	
	
	
	
		
}
public static void main(String[] args) {
		launch(args);}
}
		/*
Scanner input = new Scanner(System.in);
	System.out.println("Give the city name:");	
		cityname = input.next();
		while (!Pattern.matches("[a-zA-Z]+",cityname))  {
			 //ελεγχος για το αν δωθηκε string για ονομα πολης
			  System.out.println("Give again:");
			  cityname = input.next();
		}
	
	System.out.println("Give the city number:");
	//ελεγχος για το αν δωθηκε interger
	while(!input.hasNextInt()) {
        input.next ();
		System.out.println("Give the number again:");			   
	}		
	citynum = input.nextInt();
	MaxCode = MaxCode + 1 ;
	
	
	

	City city1 = new City(citynum,cityname);
	
	 ArrayList<City> city=new ArrayList<City>();
	city.add(city1);
	
	System.out.println("Give the Store name:");	
		storename = input.next();
		while (!Pattern.matches("[a-zA-Z]+",storename))  {
			 
			  System.out.println("Give again:");
			  storename = input.next();
		}

		
		System.out.println("Give the town the store is located:");	
			storetown = input.next();
			while (!Pattern.matches("[a-zA-Z]+",storetown))  {
				 
				  System.out.println("Give again:");
				  storetown = input.next();
			}
	
	
	
			System.out.println("Give the store number:");
			
			while (!input.hasNextInt()) {
				System.out.println("Give the number again:");
				input.next();
			}
			storenum = input.nextInt();
			MaxCode = MaxCode + 1 ;
	
			
			
	 Store store1 = new Store( storenum ,storename , storetown);
	 
	 ArrayList<Store> store =new ArrayList<Store>();
		store.add(store1);
	
	
		System.out.println("Give the vehicle model:");	
		model = input.next();
		while (!Pattern.matches("[a-zA-Z]+",model))  {
			 
			  System.out.println("Give again:");
			  model = input.next();
		}
	
	System.out.println("Give the fuel type : Petrol or Diesel:");
	// ελεγχος για το εαν δωθηκε σωστα το καυσιμο
	fuel = input.next();
	while (!fuel.equals("Petrol") && !fuel.equals("Diesel")  ) {
		System.out.println("Type again:");
		input.hasNext();
		fuel = input.next();
	}
	

	System.out.println("Give vehicles type: ");	
	type = input.next();
	while (!Pattern.matches("[a-zA-Z]+",type))  {
		 
		  System.out.println("Give again:");
		  type = input.next();
	}
	
	System.out.println("Give the vehicle number:");
	
	while (!input.hasNextInt()) {
		System.out.println("Give the number again:");
		input.next();
			}
	vehnum = input.nextInt();
	
	
	
	
	
	System.out.println("Give the cubic of the vehicle:");

	while (!input.hasNextInt()) {
		System.out.println("Give the number again:");
		input.next();	
	}
	cubic = input.nextInt();
	
	
	System.out.println("Give the vehicle's cost:");
	while (!input.hasNextInt()) {
		System.out.println("Give the cost again:");
		input.next();
			}
	cost = input.nextInt();
	
	
	
	Vehicle veh1 = new Vehicle( model ,fuel , type , vehnum ,cubic ,cost);
	
	ArrayList<Vehicle> veh=new ArrayList<Vehicle>();
		veh.add(veh1);
	
	System.out.println("Give the store system: ");	
	storesystem = input.next();
	while (!Pattern.matches("[a-zA-Z]+",storesystem))  {
		
		  System.out.println("Give again:");
		  storesystem = input.next();
	}
	
	
	
	
	System.out.println("Give the seat's height:");
	//ελεγχος για το αν δωθηκε double
	while (!input.hasNextDouble()) {
		System.out.println("Give the seat's height again:");
		input.next();
		}
	heightseat = input.nextDouble();
	
	
	TwoWheeled twowheeled1 = new TwoWheeled( model , fuel, type, vehnum ,cubic, cost,heightseat, storesystem);
	
	 ArrayList<Vehicle> twowhe=new ArrayList<Vehicle>();
		twowhe.add(twowheeled1);
	
	
	System.out.println("Give the number of the seats:");
	while (!input.hasNextInt()) {
		System.out.println("Give the number again:");
		input.next();
			}
	seatsnum = input.nextInt();
	
	
	System.out.println("Give the number of the doors:");
	while (!input.hasNextInt()) {
		System.out.println("Give the number again:");
		input.next();
			}
	doorsnum = input.nextInt();
	


	Car car1 = new Car (model , fuel , type , vehnum ,cubic , cost , seatsnum , doorsnum);
	
	 ArrayList<Vehicle> car =new ArrayList<Vehicle>();
		car.add(car1);

	System.out.println("Give the id of the driver:");
	while (!input.hasNextInt()) {
		System.out.println("Give the number again:");
		input.next();
		}
	id = input.nextInt();

	System.out.println("Give the driver's license number:");
	while (!input.hasNextInt()) {
		System.out.println("Give the number again:");
		input.next();
		}
	driverlic = input.nextInt();



	System.out.println("Give the telephone of the driver:");
	while (!input.hasNextInt()) {
		System.out.println("Give the number again:");
		input.next();
	
	}
	tel = input.nextInt();


	System.out.println("Give the driver's name:");	
	name = input.next();
	while (!Pattern.matches("[a-zA-Z]+",name))  {
		 
		  System.out.println("Give again:");
		  name = input.next();
	}

	System.out.println("Give the driver's surname:");	
	surname = input.next();
	while (!Pattern.matches("[a-zA-Z]+",surname))  {
		 
		  System.out.println("Give again:");
		  surname = input.next();
	}



	System.out.println("Give the driver's email:");	
	email = input.next();
	while (!Pattern.matches("[a-zA-Z]+",email))  {
		 
		  System.out.println("Give again:");
		  email = input.next();
	}



	System.out.println("Give the driver's address:");	
	address = input.next();
	while (!Pattern.matches("[a-zA-Z]+",address))  {
		 
		  System.out.println("Give again:");
		  address = input.next();
	}


	Client client1 = new Client (id , driverlic , tel,name , surname , email , address);
	
	ArrayList<Client> client =new ArrayList<Client>();
		client.add(client1);

	System.out.println("Give the rental code:");
	while (!input.hasNextInt()) {
		System.out.println("Give the number again:");
		input.next();
	
	}
	rentalcode = input.nextInt();

	System.out.println("Give the total cost:");
	while (!input.hasNextInt()) {
		System.out.println("Give the number again:");
		input.next();
	}
	totalcost = input.nextInt();

	
	
	System.out.println("Give the vehicle that rented:");	
	vehrent = input.next();
	while (!Pattern.matches("[a-zA-Z]+",vehrent))  {
		 
		  System.out.println("Give again:");
		  vehrent = input.next();
	MaxCode = MaxCode + 1 ;
	}



	System.out.println("Give the client that rented:");	
	clientrent = input.next();
	while (!Pattern.matches("[a-zA-Z]+",clientrent))  {
		 
		  System.out.println("Give again:");
		  clientrent = input.next();
	}




	System.out.println("Give the store that made the rental:");	
	storerent = input.next();
	while (!Pattern.matches("[a-zA-Z]+",storerent))  {
		 
		  System.out.println("Give again:");
		  storerent = input.next();
	}

System.out.println("Is the car going to be returned at the same store?");
StorereturnAp = input.next();

if(!StorereturnAp.equals("Yes") || !StorereturnAp.contentEquals("yes")) {
	//εαν η απαντηση ειναι οχι ρωταμε να μθουμε σε ποιο καταστημα θα επιστραφει το αυτοκινητο
	System.out.println("Give the store that the car is going to be returned to :");	
	storetown = input.next();
	while (!Pattern.matches("[a-zA-Z]+",storetown))  {
		 
		  System.out.println("Give again:");
		  storetown = input.next();
	}
} else {
	// εαν το καταστημα ειναι ιδιο εκχωρουμε κενο στην μεταβλητη ωστε στην εμφανιση να μην υπαρχει τιποτα καταχωρημενο στην μεταβλητη
	storereturn = "";
}


System.out.println("Give the date of the rent:");

while (!input.hasNextDouble()) {
	System.out.println("Give the date again:");
	input.next();
} 
daterent = input.nextDouble();

System.out.println("Give the time of the rent:");

while (!input.hasNextDouble()) {
	System.out.println("Give the time again:");
	input.next();



}
timerent = input.nextDouble();

System.out.println("Give the date of return:");

while (!input.hasNextDouble()) {
	System.out.println("Give the date again:");
	input.next();



}
datereturn = input.nextDouble();


System.out.println("Give the time of return:");

while (!input.hasNextDouble()) {
	System.out.println("Give the time again:");
	input.next();
}
timereturn = input.nextDouble();


Rental rent1 = new Rental (rentalcode , totalcost,vehrent , clientrent , storerent , storereturn  , daterent , timerent , datereturn , timereturn);

ArrayList<Rental> rental =new ArrayList<Rental>();
rental.add(rent1);

input.close();

}
	

}*/
		
	
	
	
	
	
