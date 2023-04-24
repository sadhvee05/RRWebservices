package com.rrWebservices.RRWebservices.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class RoomAvailabilityCheckRequest {
	
	private int stationCode;
	private String checkInTime;
	private String checkOutTime;
	private String bookingType;
	private String travelAutho;
	private String travelAuthoId;
	
	public int getStationCode() {
		return stationCode;
	}
	public void setStationCode(int stationCode) {
		this.stationCode = stationCode;
	}
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public String getBookingType() {
		return bookingType;
	}
	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}
	public String getTravelAutho() {
		return travelAutho;
	}
	public void setTravelAutho(String travelAutho) {
		this.travelAutho = travelAutho;
	}
	public String getTravelAuthoId() {
		return travelAuthoId;
	}
	public void setTravelAuthoId(String travelAuthoId) {
		this.travelAuthoId = travelAuthoId;
	}
	

}
