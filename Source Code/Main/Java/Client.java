import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class Client {
	
	public static void main(String a[]){
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		FlightValidate planner = new FlightValidate("Charlotte", "Chicago", 
				sdf.parse("05/05/2017"), sdf.parse("05/09/2017"), 2, 2);
		Map <String,List<Flight>> flights = planner.searchFlights();
		//Assume user selects first flight from the list presented
		Flight onwardFlight = flights.get("Onward Flights").get(0);
		Flight returnFlight = flights.get("Return Flights").get(0);
		RoundTripFlight trip = new RoundTripFlight(onwardFlight, returnFlight, 2, 2);
		Package Package = new BasePackage(trip);

		HotelValidate HotelValidate = new HotelValidate("Chicago", sdf.parse("05/06/2017"), sdf.parse("05/09/2017"),
				1, 2, 2, trip);
		List<Hotel> hotelsMatched = HotelValidate.searchHotels();
		Package packageWithHotel = new HotelDecorator(Package, hotelsMatched.get(0));
		
		RentalValidate carPlanner = new RentalValidate("230 Dr", "Chicago", "35 Craver", "Chicago", 
				sdf.parse("05/06/2017"), sdf.parse("05/09/2017"), trip);
		List<Car> carsMatched = carPlanner.searchCars();
		Package packageWithCar = new CarDecorator(packageWithHotel, carsMatched.get(0));
		
		
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
