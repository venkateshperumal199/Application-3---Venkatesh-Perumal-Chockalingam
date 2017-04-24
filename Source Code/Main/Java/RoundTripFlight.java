import java.util.Date;

public class RoundTripFlight {
	
	private String origin;
	private String destination;
	private Date departureDate;
	private Date returnDate;
	private Flight onwardFlight;
	private Flight returnFlight;
	private int noOfAdults;
	private int noOfChildren;
	
	private RoundTripFlight(){}
	
	public RoundTripFlight(Flight onwardFlight, Flight returnFlight, 
			int noOfAdults, int noOfChildren){
		this.onwardFlight = onwardFlight;
		this.returnFlight = returnFlight;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		setOrigin();
		setDestination();
		setDepartureDate();
		setReturnDate();
	}
	
	private void setOrigin() {
		this.origin = this.onwardFlight.getOriginCity();
	}
	
	private void setDestination() {
		this.destination = this.onwardFlight.getDestinationCity();
	}
	
	private void setDepartureDate() {
		this.departureDate = this.onwardFlight.getDepartureDate();
	}
	
	private void setReturnDate() {
		this.returnDate = this.returnFlight.getDepartureDate();
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public Date getDepartureDate() {
		return departureDate;
	}
	
	public Date getReturnDate() {
		return returnDate;
	}

	public int getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public Flight getOnwardFlight() {
		return onwardFlight;
	}

	public void setOnwardFlight(Flight onwardFlight) {
		this.onwardFlight = onwardFlight;
	}

	public Flight getReturnFlight() {
		return returnFlight;
	}

	public void setReturnFlight(Flight returnFlight) {
		this.returnFlight = returnFlight;
	}
		
}
