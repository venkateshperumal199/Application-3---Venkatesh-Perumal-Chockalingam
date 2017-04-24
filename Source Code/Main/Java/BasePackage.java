
public class BasePackage implements Package{

	private RoundTripFlight roundTripFlight;
	
	private BasePackage(){}
		
	public BasePackage(RoundTripFlight roundTripFlight){
		this.roundTripFlight = roundTripFlight;
	}

	@Override
	public double getCost() {
		// Onward journey cost
		Flight onwardFlight = this.roundTripFlight.getOnwardFlight();
		Flight returnFlight = this.roundTripFlight.getReturnFlight();
		int adults = this.roundTripFlight.getNoOfAdults();
		int children = this.roundTripFlight.getNoOfChildren();
		double onwardCost = (onwardFlight.getCostPerAdult()*adults)+
				(onwardFlight.getCostPerChild()*children);
		double returnCost = (returnFlight.getCostPerAdult()*adults)+
				(returnFlight.getCostPerChild()*children);
		double totalCost = onwardCost + returnCost;
		return totalCost;
	}
}
