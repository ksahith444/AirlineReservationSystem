package models;


public class reservation {

	
	private int flight_number;
	public int getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}
	public String getWeekdays() {
		return weekdays;
	}
	public void setWeekdays(String weekdays) {
		this.weekdays = weekdays;
	}
	public String getDepaircode() {
		return depaircode;
	}
	public void setDepaircode(String depaircode) {
		this.depaircode = depaircode;
	}
	public String getArraircode() {
		return arraircode;
	}
	public void setArraircode(String arraircode) {
		this.arraircode = arraircode;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getSeatno() {
		return seatno;
	}
	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFare_code() {
		return fare_code;
	}
	public void setFare_code(String fare_code) {
		this.fare_code = fare_code;
	}
	public String getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getScheduled_departure_time() {
		return scheduled_departure_time;
	}
	public void setScheduled_departure_time(String scheduled_departure_time) {
		this.scheduled_departure_time = scheduled_departure_time;
	}
	public String getScheduled_arrival_time() {
		return scheduled_arrival_time;
	}
	public void setScheduled_arrival_time(String scheduled_arrival_time) {
		this.scheduled_arrival_time = scheduled_arrival_time;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getNumberofavailablesets() {
		return numberofavailablesets;
	}
	public void setNumberofavailablesets(int numberofavailablesets) {
		this.numberofavailablesets = numberofavailablesets;
	}
	
	private String weekdays;
	private String depaircode;
	private String arraircode;
	private String scheduled_departure_time;
	private String scheduled_arrival_time;
	
	private String contactNumber;
	private String customerName;
	private String phonenumber;
	
	private int numberofavailablesets;
	private String seatno;
	private String date;
	private String fare_code;
	private String restrictions;
	private int amount;
	

}
