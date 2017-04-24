import java.util.Date;

public class Hotel {
	
	private String street;
	private String city;
	private Date checkinDate;
	private Date checkoutDate;
	private	int noOfRooms;
	private int noOfAdultsPerRoom;
	private int noOfChildrenPerRoom;
	private double costPerRoom;
	
	private Hotel(){}
	
	public Hotel(String street, String city, double costPerRoom){
		this.street = street;
		this.city = city;
		this.costPerRoom = costPerRoom;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public int getNoOfAdultsPerRoom() {
		return noOfAdultsPerRoom;
	}

	public void setNoOfAdultsPerRoom(int noOfAdultsPerRoom) {
		this.noOfAdultsPerRoom = noOfAdultsPerRoom;
	}

	public int getNoOfChildrenPerRoom() {
		return noOfChildrenPerRoom;
	}

	public void setNoOfChildrenPerRoom(int noOfChildrenPerRoom) {
		this.noOfChildrenPerRoom = noOfChildrenPerRoom;
	}

	public double getCostPerRoom() {
		return costPerRoom;
	}

	public void setCostPerRoom(double costPerRoom) {
		this.costPerRoom = costPerRoom;
	}

	
}
