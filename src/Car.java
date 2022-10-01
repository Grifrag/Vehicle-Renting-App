

public class Car extends Vehicle {
private int SeatsNum , DoorsNum ;


Car (String model , int vehnum , String fuel , String type , int cubic , int cost ,int SeatsNum , int DoorsNum){
	super (model ,vehnum, fuel , type ,cubic , cost);
	this.setSeatsNum(SeatsNum);
	this.setDoorsNum(DoorsNum);
}









public int getSeatsNum() {
	return SeatsNum;
}

public void setSeatsNum(int seatsNum) {
	SeatsNum = seatsNum;
}

public int getDoorsNum() {
	return DoorsNum;
}

public void setDoorsNum(int doorsNum) {
	DoorsNum = doorsNum;
}




}
