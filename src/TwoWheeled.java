

public class TwoWheeled extends Vehicle {

		// TODO Auto-generated constructor stub
	
private double HeightSeat ;
private String StoreSystem ;


TwoWheeled(String model, String fuel, String type, int vehnum, int cubic, int cost ,double HeightSeat , String StoreSystem) {
	super(model,vehnum, fuel, type, cubic, cost);
	this.setHeightSeat(HeightSeat);
	this.setStoreSystem(StoreSystem);
	


}


public double getHeightSeat() {
	return HeightSeat;
}


public void setHeightSeat(double heightSeat) {
	HeightSeat = heightSeat;
}


public String getStoreSystem() {
	return StoreSystem;
}


public void setStoreSystem(String storeSystem) {
	StoreSystem = storeSystem;
}


}