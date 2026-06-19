/*
 * Name: Juliana Bruno
 * Project: 2
 * Title: Seat.java
 * Summary: outline of a plane seat
 * Date: 3/23/25
 */

public class Seat {

	//instance variables
	private String passengerName;
	private boolean available;
	enum SeatType {STANDARD, EXTRA_LEGROOM};
	private String type;
	
	//default constructor
	public Seat() {
		passengerName = "";
		available = true;
		type = "STANDARD";
	}
	
	//overloaded constructor
	public Seat(String p, boolean b, String s) {
		passengerName = p;
		available = b;
		type = s;
	}
	
	//get and set methods
	public void setPassengerName(String p) {
		passengerName = p;
	}
	
	public String getPassengerName() {
		return passengerName;
	}
	
	public void setAvailable(boolean b) {
		available = b;
	}
	
	public boolean getAvailable() {
		return available;
	}
	
	public void setType(String s) {
		type = s;
	}
	
	public String getType() {
		return type;
	}
	
	public String toString() {
		if (available == true) {
			return "Available " + type;
		} else {
			return "Passenger Name: " + passengerName + "\nSeat Type: " + type;
		}
	}
	
	
	
	
	
}
