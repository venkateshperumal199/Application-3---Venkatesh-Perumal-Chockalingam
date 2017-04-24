
public class CarDecorator extends Decorator{
	
	private Package packageTour;
	private Car car;
	
    private CarDecorator(){}
	
	public CarDecorator(Package packageTour, Car car){
		this.packageTour = packageTour;
		this.car = car;
	}
	
	@Override
	public double getCost() {
		return this.packageTour.getCost()+this.car.getCost();
	}

}
