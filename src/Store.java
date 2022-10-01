

public class Store {
private int StoreNum;
private String StoreName , StoreTown ;
static int MaxCode = 0 ;




Store (int StoreNum ,String StoreName , String StoreTown ){
	this.setStoreNum(StoreNum);
	this.setStoreName(StoreName);
	this.setStoreTown(StoreTown);
}




public int getStoreNum() {
	return StoreNum;
}




public void setStoreNum(int storeNum) {
	StoreNum = storeNum;
}




public String getStoreName() {
	return StoreName;
}




public void setStoreName(String name) {
	StoreName = name;
}




public String getStoreTown() {
	return StoreTown;
}




public void setStoreTown(String town) {
	StoreTown = town;
}


}
