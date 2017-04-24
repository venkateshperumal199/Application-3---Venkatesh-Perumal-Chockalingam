import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class TestRoundTripFlight {
	
	private Flight onwardFlight;
	private Flight returnFlight;
	private RoundTripFlight roundTripFlight;
	
	@Before
	public void setup() {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			onwardFlight = new Flight("243A", "Charlotte", "Chicago", sdf.parse("05/04/2017 17:30:35"), sdf.parse("05/05/2017 20:25:35"), 100d, 80d);
			returnFlight = new Flight("243B", "Chicago", "Charlotte", sdf.parse("05/09/2017 20:25:20"), sdf.parse("05/10/2017 22:25:30"), 100d, 80d);
			roundTripFlight = new RoundTripFlight(onwardFlight, returnFlight, 2, 1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetOrigin(){
		assertEquals("Charlotte", roundTripFlight.getOrigin());
	}
	
	@Test
	public void testGetDestination(){
		assertEquals("Chicago", roundTripFlight.getDestination());
	}
	
	@Test
	public void testGetDepartureDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		try {
			assertEquals(sdf.parse("05/04/2017 16:55:35"), roundTripFlight.getDepartureDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetReturnDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		try {
			assertEquals(sdf.parse("05/09/2017 20:35:40"), roundTripFlight.getReturnDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetNoOfAdults(){
		assertEquals(2,roundTripFlight.getNoOfAdults());
	}
	
	@Test
	public void testGetNoOfChildren(){
		assertEquals(1,roundTripFlight.getNoOfChildren());
	}
	
	@Test
	public void testGetOnwardFlight(){
		assertEquals(onwardFlight, roundTripFlight.getOnwardFlight());
	}
	
	@Test
	public void testGetReturnFlight(){
		assertEquals(returnFlight, roundTripFlight.getReturnFlight());
	}

}
