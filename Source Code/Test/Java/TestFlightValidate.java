import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestFlightValidate {
	
	@Test
	public void testValidationPositiveScenario(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			FlightPlanner fp = new FlightPlanner("Charlotte", "Chicago", 
					sdf.parse("05/05/2017"), sdf.parse("05/09/2017"), 2, 2);
			assertTrue(fp.validate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSearchFlights(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			FlightPlanner fp = new FlightPlanner("Charlotte", "Chicago", 
					sdf.parse("05/05/2017"), sdf.parse("05/09/2017"), 2, 2);
			Map <String,List<Flight>> flights = fp.searchFlights();
			assertNotNull(flights.get("Onward Flights"));
			assertNotNull(flights.get("Return Flights"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidationSourceDestinationSame(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			FlightPlanner fp = new FlightPlanner("Charlotte", "Charlotte", 
					sdf.parse("05/05/2017"), sdf.parse("05/09/2017"), 2, 2);
			assertFalse(fp.validate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidationDepartureDatePast(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			FlightPlanner fp = new FlightPlanner("Charlotte", "Chicago", 
					sdf.parse("05/05/2016"), sdf.parse("05/09/2017"), 2, 2);
			assertFalse(fp.validate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidationReturnDateBeforeFlightArrival(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			FlightPlanner fp = new FlightPlanner("Charlotte", "Chicago", 
					sdf.parse("05/05/2016"), sdf.parse("05/05/2017"), 2, 2);
			assertFalse(fp.validate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidationAdultPassangers(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			FlightPlanner fp = new FlightPlanner("Charlotte", "Chicago", 
					sdf.parse("05/05/2017"), sdf.parse("05/09/2017"), 0, 2);
			assertFalse(fp.validate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
