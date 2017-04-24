import java.util.Date;

public class Flight {
	
	private String flightNumber;
	private String originCity;
	private String destinationCity;
	private Date departureDate;
	private Date arrivalDate;
	private double costPerAdult;
	private double costPerChild;
	
	private Flight(){}
	
	public Flight(String flightNumber, String originCity, String destinationCity, Date departureDate, Date arrivalDate,
			double costPerAdult, double costPerChild) {
		this.flightNumber = flightNumber;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.costPerAdult = costPerAdult;
		this.costPerChild = costPerChild;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getOriginCity() {
		return originCity;
	}
	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public double getCostPerAdult() {
		return costPerAdult;
	}
	public void setCostPerAdult(double costPerAdult) {
		this.costPerAdult = costPerAdult;
	}
	public double getCostPerChild() {
		return costPerChild;
	}
	public void setCostPerChild(double costPerChild) {
		this.costPerChild = costPerChild;
	}

}
