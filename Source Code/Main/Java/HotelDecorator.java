
public class HotelDecorator extends Decorator{
	
	private Package packageTour;
	private Hotel hotel;
	
	private HotelDecorator(){}
	
	public HotelDecorator(Package packageTour, Hotel hotel){
		this.packageTour = packageTour;
		this.hotel = hotel;
	}
	
	@Override
	public double getCost() {
		double hotelCost = this.hotel.getNoOfRooms()*this.hotel.getCostPerRoom();
		double cost = this.packageTour.getCost() + hotelCost;
		return cost;
	}

}
