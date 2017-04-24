import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestBasePackage {
	
	@Mock
    private RoundTripFlight roundTripFlight;
	
	@InjectMocks
    private BaseVacationPackage vp = new BaseVacationPackage(roundTripFlight);
	
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
	public void testGetCost(){
		Mockito.when(roundTripFlight.getOnwardFlight()).thenReturn(onwardFlight);
		Mockito.when(roundTripFlight.getReturnFlight()).thenReturn(returnFlight);
		Mockito.when(roundTripFlight.getNoOfAdults()).thenReturn(2);
		Mockito.when(roundTripFlight.getNoOfChildren()).thenReturn(1);
		assertEquals(560d, vp.getCost(), 0d);		
	}

}
