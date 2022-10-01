

public class Rental {
private int RentalCode ,   TotalCost,vehRent ;
private String   ClientRent , StoreRent , StoreReturn ;
private double DateRent , TimeRent , DateReturn , TimeReturn ;
//static int MaxCode = 0 ;


public Rental(int rentalCode, int vehRent, String clientRent, String storeRent, 
		int dateRent, int timeRent,String storeReturn, int dateReturn, int timeReturn, int totalCost) {
		
		this.setRentalCode(rentalCode);
		this.setTotalCost(totalCost);
		this.setVehRent(vehRent);
		this.setClientRent(clientRent);
		this.setStoreRent(storeRent);
		this.setStoreReturn(storeReturn);
		this.setDateRent(dateRent);
		this.setTimeRent(timeRent);
		this.setDateRent(dateReturn);
		this.setTimeReturn(timeReturn);
	}

public int getRentalCode() {
	return RentalCode;
}
public void setRentalCode(int rentalCode) {
	RentalCode = rentalCode;
}
public int getTotalCost() {
	return TotalCost;
}
public void setTotalCost(int totalCost) {
	TotalCost = totalCost;
}
public int getVehRent() {
	return vehRent;
}
public void setVehRent(int vehRent) {
	this.vehRent = vehRent;
}
public String getClientRent() {
	return ClientRent;
}
public void setClientRent(String clientRent) {
	ClientRent = clientRent;
}
public String getStoreRent() {
	return StoreRent;
}
public void setStoreRent(String storeRent) {
	StoreRent = storeRent;
}
public String getStoreReturn() {
	return StoreReturn;
}
public void setStoreReturn(String storeReturn) {
	StoreReturn = storeReturn;
}
public double getDateRent() {
	return DateRent;
}
public void setDateRent(double dateRent) {
	DateRent = dateRent;
}
public double getTimeRent() {
	return TimeRent;
}
public void setTimeRent(double timeRent) {
	TimeRent = timeRent;
}
public double getDateReturn() {
	return DateReturn;
}
public void setDateReturn(double dateReturn) {
	DateReturn = dateReturn;
}
public double getTimeReturn() {
	return TimeReturn;
}
public void setTimeReturn(double timeReturn) {
	TimeReturn = timeReturn;
}







}
