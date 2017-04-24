import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelValidate {
	
	private RoundTripFlight roundTripDetails;
	private String city;
	private Date checkinDate;
	private Date checkoutDate;
	private	int noOfRooms;
	private int noOfAdultsPerRoom;
	private int noOfChildrenPerRoom;
	private static List<Hotel> hotelsAvailable = new ArrayList<>();
	
	static{
		Hotel h1 = new Hotel("110 City Dr", "Charlotte", 110d);
		Hotel h2 = new Hotel("215 Craver Rd", "Chicago", 235d);
		Hotel h3 = new Hotel("352 Mallard Dr", "Charlotte", 70d);
		Hotel h4 = new Hotel("109 Church Dr", "New York", 230d);
		Hotel h5 = new Hotel("76 University Dr", "Chicago", 205d);
		hotelsAvailable.add(h1); hotelsAvailable.add(h2);
		hotelsAvailable.add(h3); hotelsAvailable.add(h4);hotelsAvailable.add(h5);
	}
	
	private HotelValidate(){}
	
	public HotelValidate(String city, Date checkinDate, Date checkoutDate,
			int noOfRooms, int noOfAdultsPerRoom, int noOfChildrenPerRoom, RoundTripFlight roundTrip){
		this.city = city;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.noOfRooms = noOfRooms;
		this.noOfAdultsPerRoom = noOfAdultsPerRoom;
		this.noOfChildrenPerRoom = noOfChildrenPerRoom;
		this.roundTripDetails = roundTrip;
	}
	
	public List<Hotel> searchHotels(){
		List<Hotel> hotels = null;
		if(!validate())
			return null;
		else{
			hotels = new ArrayList<>();
			for(Hotel h: hotelsAvailable){
				if(this.city.equalsIgnoreCase(h.getCity()))
					hotels.add(h);
			}
		}
		return hotels;
	}
	
	public boolean validate(){
		boolean validationResult = true;
		if(!validateCity())
			validationResult = false;
		if(!validateCheckinDate())
			validationResult = false;
		if(!validateCheckoutDate())
			validationResult = false;
		if(!validateNoOfRooms())
			validationResult = false;
		if(!validateNoOfAdultsPerRoom())
			validationResult = false;
		return validationResult;
	}
	
	private boolean validateCity(){
		if(this.city.equalsIgnoreCase(this.roundTripDetails.getDestination()))
			return true;
		else
			return false;
	}
	
	private boolean validateCheckinDate(){
		if(this.checkinDate.before(this.roundTripDetails.getOnwardFlight().getArrivalDate()))
			return false;
		else
			return true;
	}
	
	
	private boolean validateCheckoutDate(){
		if(this.checkoutDate.after(this.roundTripDetails.getReturnDate()))
			return false;
		else
			return true;
	}
	
	private boolean validateNoOfRooms(){
		if(this.noOfRooms>0)
			return true;
		else
			return false;
	}
	
	private boolean validateNoOfAdultsPerRoom(){
		if(this.noOfAdultsPerRoom>0)
			return true;
		else
			return false;
	}

}
