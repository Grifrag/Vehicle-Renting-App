
public class Vehicle {

	
private int VehNum , Cubic , Cost  ;
private String Model , Fuel , Type ;




	  Vehicle (String model ,int vehnum, String fuel , String type , int cubic , int cost) {
		this.setModel(model); ; 
		this.setFuel(fuel);
		this.setType(type);
		this.setVehNum(vehnum);
		this.setCubic(cubic);
		this.setCost(cost);
	  }




	public int getVehNum() {
		return VehNum;
	}




	public void setVehNum(int vehNum) {
		VehNum = vehNum;
	}




	public int getCubic() {
		return Cubic;
	}




	public void setCubic(int cubic) {
		Cubic = cubic;
	}




	public int getCost() {
		return Cost;
	}




	public void setCost(int cost) {
		Cost = cost;
	}




	public String getModel() {
		return Model;
	}




	public void setModel(String model) {
		Model = model;
	}




	public String getFuel() {
		return Fuel;
	}




	public void setFuel(String fuel) {
		Fuel = fuel;
	}




	public String getType() {
		return Type;
	}




	public void setType(String type) {
		Type = type;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
