import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightValidate {
	
	private String origin;
	private String destination;
	private Date departureDate;
	private	Date returnDate;
	private int noOfAdults;
	private int noOfChildren;
	private static List<Flight> flightsServiced = new ArrayList<>();
	static{
		try {
				//Create list of flightsServiced
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Flight flight1 = new Flight("140A", "Charlotte", "Chicago", sdf.parse("05/05/2017 14:30:44"), sdf.parse("05/05/2017 16:30:44"), 250d, 100d);
				Flight flight2 = new Flight("150B", "Chicago", "Charlotte", sdf.parse("05/09/2017 23:30:26"), sdf.parse("05/10/2017 05:00:10"), 280d, 130d);
				Flight flight3 = new Flight("158A", "Charlotte", "Chicago", sdf.parse("05/05/2017 22:30:30"), sdf.parse("05/06/2017 04:15:35"), 250d, 100d);
				Flight flight4 = new Flight("165C", "Chicago", "Charlotte", sdf.parse("05/15/2017 23:30:56"), sdf.parse("05/16/2017 05:00:50"), 250d, 100d);
				Flight flight5 = new Flight("175D", "Charlotte", "New York", sdf.parse("05/05/2017 23:45:50"), sdf.parse("05/06/2017 03:30:50"), 250d, 100d);
				Flight flight6 = new Flight("137D", "New York", "Charlotte", sdf.parse("05/07/2017 23:15:10"), sdf.parse("05/08/2017 04:00:10"), 250d, 100d);
				flightsServiced.add(flight1);
				flightsServiced.add(flight2);
				flightsServiced.add(flight3);
				flightsServiced.add(flight4);
				flightsServiced.add(flight5);
				flightsServiced.add(flight6);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}
	
	//private FlightValidate(){}
	
	public FlightValidate(String origin, String destination, Date departureDate,
			Date returnDate, int noOfAdults, int noOfChildren){
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
	}
			
	public Map <String,List<Flight>> searchFlights(){
		Map <String,List<Flight>> flights = new HashMap<>();
		if(!validate())
			return null;
		else{
			List<Flight> onwardFlights = new ArrayList<>();
			List<Flight> returnFlights = new ArrayList<>();
			//Get flights that starts from origin and goes to destination on depDate selected by User
			for(Flight f : flightsServiced){
				if(f.getOriginCity().equalsIgnoreCase(this.origin) 
						&& f.getDestinationCity().equalsIgnoreCase(this.destination)
						&& f.getDepartureDate().compareTo(this.departureDate)>=0){
					onwardFlights.add(f);
				}
			}
			//Get flights that starts from destination and goes to origin on returnDate selected by User
			for(Flight f : flightsServiced){
				if(f.getOriginCity().equalsIgnoreCase(this.destination) 
						&& f.getDestinationCity().equalsIgnoreCase(this.origin)
						&& f.getDepartureDate().compareTo(this.returnDate)>=0){
					returnFlights.add(f);
				}
			}
			flights.put("Onward Flights", onwardFlights);
			flights.put("Return Flights", returnFlights);
		}
		return flights;
	}
	
	public boolean validate(){
		boolean validationResult = true;
		if(!validateOriginDestination())
			validationResult = false;
		if(!validateDepartureDate())
			validationResult = false;
		if(!validateReturnDate())
			validationResult = false;
		if(!validateAdultPassangers())
			validationResult = false;
		return validationResult;
	}
	
	private boolean validateOriginDestination(){
		if(this.origin.equals(this.destination))
			return false;
		else
			return true;
	}
	
	private boolean validateDepartureDate(){
		boolean result = false;
		Date date = new Date();
		try{
		if(date.before(this.departureDate))
			result = true;
		else
			result = false;
		}catch(Exception e){
			System.out.println(e);
		}
		return result;
	}
	
	private boolean validateReturnDate(){
		boolean validReturndate = false;
		for(Flight f : flightsServiced){
			if(f.getOriginCity().equalsIgnoreCase(this.origin) 
					&& f.getDestinationCity().equalsIgnoreCase(this.destination)){
				if(this.returnDate.after(f.getArrivalDate())){
					validReturndate = true;
					break;
				}
			}
		}
		return validReturndate;
	}
	
	private boolean validateAdultPassangers(){
		if(this.noOfAdults > 0)
			return true;
		else
			return false;
	}

}
