import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestCarDecorator {
	
	@Mock
    private VacationPackage packageTour;
	private Car car = new Car("2589NY", "BENZ", 260d, "Chicago");
	
	@InjectMocks
    private VacationPackage carDecorator = new CarDecorator(packageTour, car);
	
	@Test
	public void testGetCost(){
		Mockito.when(packageTour.getCost()).thenReturn(260d);
		assertEquals(500d, carDecorator.getCost(), 0d);
	}

}
