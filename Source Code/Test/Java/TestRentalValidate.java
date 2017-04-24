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
public class TestRentalValidate {

	@Mock
    private RoundTripFlight roundTripDetails;
	
	private Flight onwardFlight;
	private Flight returnFlight;
	
	@Before
	public void setup() {
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		onwardFlight = new Flight("243A", "Charlotte", "Chicago", sdf.parse("05/04/2017 17:30:35"), sdf.parse("05/05/2017 20:25:35"), 100d, 80d);
		returnFlight = new Flight("243B", "Chicago", "Charlotte", sdf.parse("05/09/2017 20:25:20"), sdf.parse("05/10/2017 22:25:30"), 100d, 80d);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidationPositiveScenario(){
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Mockito.when(roundTripDetails.getDestination()).thenReturn("Chicago");
		Mockito.when(roundTripDetails.getOnwardFlight()).thenReturn(onwardFlight);
		Mockito.when(roundTripDetails.getReturnFlight()).thenReturn(returnFlight);
		CarRentalPlanner cp = new CarRentalPlanner("230 Barton Dr", "Chicago", "415 Manoroe Rd", 
				"Chicago", sdf.parse("05/05/2017 20:15:00"), sdf.parse("05/05/2017 22:00:00"), roundTripDetails);
		assertTrue(cp.validate());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSearchCars(){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Mockito.when(roundTripDetails.getDestination()).thenReturn("Chicago");
			Mockito.when(roundTripDetails.getOnwardFlight()).thenReturn(onwardFlight);
			Mockito.when(roundTripDetails.getReturnFlight()).thenReturn(returnFlight);
			CarRentalPlanner cp = new CarRentalPlanner("230 Barton Dr", "Chicago", "415 Manoroe Rd", 
					"Chicago", sdf.parse("05/05/2017 20:15:00"), sdf.parse("05/05/2017 22:00:00"), roundTripDetails);
			List<Car> carsFound = cp.searchCars();
			assertNotNull(carsFound);
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	@Test
	public void testValidationPickUpDropOffLocation(){
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Mockito.when(roundTripDetails.getDestination()).thenReturn("Chicago");
		Mockito.when(roundTripDetails.getOnwardFlight()).thenReturn(onwardFlight);
		Mockito.when(roundTripDetails.getReturnFlight()).thenReturn(returnFlight);
		CarRentalPlanner cp = new CarRentalPlanner("230 Barton Dr", "Charlotte", "415 Manoroe Rd", 
				"Charlotte", sdf.parse("05/05/2017 20:15:00"), sdf.parse("05/05/2017 22:00:00"), roundTripDetails);
		assertFalse(cp.validate());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidationPickUpDate(){
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Mockito.when(roundTripDetails.getDestination()).thenReturn("Chicago");
		Mockito.when(roundTripDetails.getOnwardFlight()).thenReturn(onwardFlight);
		Mockito.when(roundTripDetails.getReturnFlight()).thenReturn(returnFlight);
		CarRentalPlanner cp = new CarRentalPlanner("230 Barton Dr", "Chicago", "415 Manoroe Rd", 
				"Chicago", sdf.parse("05/05/2017 18:15:00"), sdf.parse("05/05/2017 22:00:00"), roundTripDetails);
		assertFalse(cp.validate());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidationDropOffDate(){
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Mockito.when(roundTripDetails.getDestination()).thenReturn("Chicago");
		Mockito.when(roundTripDetails.getOnwardFlight()).thenReturn(onwardFlight);
		Mockito.when(roundTripDetails.getReturnFlight()).thenReturn(returnFlight);
		CarRentalPlanner cp = new CarRentalPlanner("230 Barton Dr", "Chicago", "415 Manoroe Rd", 
				"Chicago", sdf.parse("05/05/2017 20:15:00"), sdf.parse("05/11/2017 22:00:00"), roundTripDetails);
		assertFalse(cp.validate());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
