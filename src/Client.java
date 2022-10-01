

public class Client {
private int Id , DriverLic , Tel ;
private String Name , Surname , Email , Address ;

	Client (int Id , int DriverLic , int Tel , String Name , String Surname , String Email , String Address){
		this.setId(Id);
		this.setDriverLic(DriverLic);
		this.setTel(Tel);
		this.setName(Name);
		this.setSurname(Surname);
		this.setEmail(Email);
		this.setAddress(Address);
	}






public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public int getDriverLic() {
	return DriverLic;
}
public void setDriverLic(int driverLic) {
	DriverLic = driverLic;
}
public int getTel() {
	return Tel;
}
public void setTel(int tel) {
	Tel = tel;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getSurname() {
	return Surname;
}
public void setSurname(String surname) {
	Surname = surname;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}




}
