import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestHotelValidate {
	
	@Mock
    private RoundTripFlight roundTripDetails;
	
	private Flight onwardFlight;
	
	@Before
	public void setup() {
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		onwardFlight = new Flight("132", "Charlotte", "Chicago", sdf.parse("05/04/2017"), sdf.parse("05/05/2017"), 100d, 80d);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidationPositiveScenario(){
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Mockito.when(roundTripDetails.getDestination()).thenReturn("Chicago");
		Mockito.when(roundTripDetails.getOnwardFlight()).thenReturn(onwardFlight);
		Mockito.when(roundTripDetails.getReturnDate()).thenReturn(sdf.parse("05/10/2017"));
		HotelPlanner hp = new HotelPlanner("Chicago", 
				sdf.parse("05/06/2017"), sdf.parse("05/09/2017"), 1, 2, 2, roundTripDetails);
		assertTrue(hp.validate());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSearchHotels(){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Mockito.when(roundTripDetails.getDestination()).thenReturn("Chicago");
			Mockito.when(roundTripDetails.getOnwardFlight()).thenReturn(onwardFlight);
			Mockito.when(roundTripDetails.getReturnDate()).thenReturn(sdf.parse("05/10/2017"));
			HotelPlanner hp = new HotelPlanner("Chicago", 
					sdf.parse("05/06/2017"), sdf.parse("05/09/2017"), 1, 2, 2, roundTripDetails);
			List<Hotel> hotelsMatched= hp.searchHotels();
			assertNotNull(hotelsMatched);
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	@Test
	public void testValidationCityNegativeScenario(){
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Mockito.when(roundTripDetails.getDestination()).thenReturn("Atlanta");
		Mockito.when(roundTripDetails.getOnwardFlight()).thenReturn(onwardFlight);
		Mockito.when(roundTripDetails.getReturnDate()).thenReturn(sdf.parse("05/10/2017"));
		HotelPlanner hp = new HotelPlanner("Chicago", 
				sdf.parse("05/06/2017"), sdf.parse("05/09/2017"), 1, 2, 2, roundTripDetails);
		assertFalse(hp.validate());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidationCheckinDatePrior(){
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Mockito.when(roundTripDetails.getDestination()).thenReturn("Chicago");
		Mockito.when(roundTripDetails.getOnwardFlight()).thenReturn(onwardFlight);
		Mockito.when(roundTripDetails.getReturnDate()).thenReturn(sdf.parse("05/10/2017"));
		HotelPlanner hp = new HotelPlanner("Chicago", 
				sdf.parse("05/04/2017"), sdf.parse("05/09/2017"), 1, 2, 2, roundTripDetails);
		assertFalse(hp.validate());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidationCheckoutDate(){
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Mockito.when(roundTripDetails.getDestination()).thenReturn("Chicago");
		Mockito.when(roundTripDetails.getOnwardFlight()).thenReturn(onwardFlight);
		Mockito.when(roundTripDetails.getReturnDate()).thenReturn(sdf.parse("05/10/2017"));
		HotelPlanner hp = new HotelPlanner("Chicago", 
				sdf.parse("05/06/2017"), sdf.parse("05/11/2017"), 1, 2, 2, roundTripDetails);
		assertFalse(hp.validate());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidationNoOfAdultsPerRoom(){
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Mockito.when(roundTripDetails.getDestination()).thenReturn("Chicago");
		Mockito.when(roundTripDetails.getOnwardFlight()).thenReturn(onwardFlight);
		Mockito.when(roundTripDetails.getReturnDate()).thenReturn(sdf.parse("05/10/2017"));
		HotelPlanner hp = new HotelPlanner("Chicago", 
				sdf.parse("05/06/2017"), sdf.parse("05/09/2017"), 1, 0, 2, roundTripDetails);
		assertFalse(hp.validate());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidationNoOfRooms(){
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Mockito.when(roundTripDetails.getDestination()).thenReturn("Chicago");
		Mockito.when(roundTripDetails.getOnwardFlight()).thenReturn(onwardFlight);
		Mockito.when(roundTripDetails.getReturnDate()).thenReturn(sdf.parse("05/10/2017"));
		HotelPlanner hp = new HotelPlanner("Chicago", 
				sdf.parse("05/06/2017"), sdf.parse("05/09/2017"), 0, 2, 2, roundTripDetails);
		assertFalse(hp.validate());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
