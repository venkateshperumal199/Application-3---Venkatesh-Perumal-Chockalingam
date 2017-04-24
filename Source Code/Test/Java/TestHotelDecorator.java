import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestHotelDecorator {
	
	@Mock
    private VacationPackage packageTour;
	
	private Hotel hotel = new Hotel("230 Barton Dr", "Charlotte", 100d);
	
	@InjectMocks
    private VacationPackage hotelDecorator = new HotelDecorator(packageTour, hotel);
	
	@Before
	public void setup() {
		hotel.setNoOfRooms(1);
	}
	
	@Test
	public void testGetCost(){
		Mockito.when(packageTour.getCost()).thenReturn(300d);
		assertEquals(400d, hotelDecorator.getCost(), 0d);
	}

}
