import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentalValidate {
	
	private RoundTripFlight roundTripDetails;
	private String pickUpStreet;
	private String pickUpCity;
	private String dropOffStreet;
	private String dropOffCity;
	private Date pickUpDate;
	private Date dropOffDate;
	private static List<Car> carsAvailable = new ArrayList<>();
	
	static{
		Car c1 = new Car("2312NY", "Chevrolet", 315d, "Charlotte");
		Car c2 = new Car("3145AG", "Benz", 350d, "Chicago");
		Car c3 = new Car("3569SC", "Dodge", 400d, "Charlotte");
		Car c4 = new Car("4569CA", "Audi", 450d, "Chicago");
		Car c5 = new Car("1058AZ", "BMW", 250d, "New York");
		carsAvailable.add(c1);carsAvailable.add(c2);carsAvailable.add(c3);
		carsAvailable.add(c4);carsAvailable.add(c5);
	}

	private RentalValidate(){}
	
	public RentalValidate(String pickUpStreet, String pickUpCity, String dropOffStreet, String dropOffCity,
			Date pickUpDate, Date dropOffDate, RoundTripFlight roundTripDetails){
		this.pickUpStreet = pickUpStreet;
		this.pickUpCity = pickUpCity;
		this.dropOffStreet = dropOffStreet;
		this.dropOffCity = dropOffCity;
		this.pickUpDate = pickUpDate;
		this.dropOffDate = dropOffDate;
		this.roundTripDetails = roundTripDetails;
	}
	
	public List<Car> searchCars(){
		List<Car> cars = null;
		if(!validate())
			return null;
		else{
			cars = new ArrayList<>();
			for(Car c: carsAvailable){
				if(this.pickUpCity.equalsIgnoreCase(c.getCityServiced()))
					cars.add(c);
			}
		}
		return cars;
	}
	
	public boolean validate(){
		boolean validationResult = true;
		if(!validatePickUpDropOffLocation())
			validationResult = false;
		if(!validatePickUpDate())
			validationResult = false;
		if(!validateDropOffDate())
			validationResult = false;
		return validationResult;
	}
	
	private boolean validatePickUpDropOffLocation(){
		if(null != this.pickUpStreet && null != this.dropOffStreet
				&& this.pickUpCity.equalsIgnoreCase(this.roundTripDetails.getDestination())
				&& this.dropOffCity.equalsIgnoreCase(this.roundTripDetails.getDestination()))
			return true;
		else
			return false;
	}
	
	private boolean validatePickUpDate(){
		if(this.pickUpDate.after(this.roundTripDetails.getOnwardFlight().getArrivalDate()))
			return true;
		else
			return false;
	}
	
	private boolean validateDropOffDate(){
		if(this.dropOffDate.before(this.roundTripDetails.getReturnFlight().getDepartureDate()))
			return true;
		else
			return false;
	}
	
	

}
