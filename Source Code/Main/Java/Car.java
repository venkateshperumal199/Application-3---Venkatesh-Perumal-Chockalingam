import java.util.Date;

public class Car {

	private String carNumber;
	private String carModel;
	private double cost;
	private String pickUpStreet;
	private String pickUpCity;
	private String dropOffStreet;
	private String dropOffCity;
	private Date pickUpDate;
	private Date dropOffDate;
	private String cityServiced;
	
	private Car(){}
	
	public Car(String carNumber, String carModel, double cost, String cityServiced){
		this.carNumber=carNumber;
		this.carModel=carModel;
		this.cost=cost;
		this.cityServiced=cityServiced;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getPickUpStreet() {
		return pickUpStreet;
	}

	public void setPickUpStreet(String pickUpStreet) {
		this.pickUpStreet = pickUpStreet;
	}

	public String getPickUpCity() {
		return pickUpCity;
	}

	public void setPickUpCity(String pickUpCity) {
		this.pickUpCity = pickUpCity;
	}

	public String getDropOffStreet() {
		return dropOffStreet;
	}

	public void setDropOffStreet(String dropOffStreet) {
		this.dropOffStreet = dropOffStreet;
	}

	public String getDropOffCity() {
		return dropOffCity;
	}

	public void setDropOffCity(String dropOffCity) {
		this.dropOffCity = dropOffCity;
	}

	public Date getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	public Date getDropOffDate() {
		return dropOffDate;
	}

	public void setDropOffDate(Date dropOffDate) {
		this.dropOffDate = dropOffDate;
	}

	public String getCityServiced() {
		return cityServiced;
	}

	public void setCityServiced(String cityServiced) {
		this.cityServiced = cityServiced;
	}
}
