package com.rrWebservices.RRWebservices.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoomAvailabilityCheckRequest {
	
	
	
    @NotNull(message = "The Location Id in Not Null  and Integer Type, ")
    private int stationCode;
	@NotBlank(message = "CheckInTime is mandatory 'yyyy-MM-dd hh:mm:ss' ex: '2023-01-23 00:00:00' ")
	private String checkInTime;
	@NotBlank(message = "CheckInTime is mandatory 'yyyy-MM-dd hh:mm:ss' ex: '2023-01-23 00:00:00' ")
	private String checkOutTime;
	//@NotBlank(message = "Booking Type Not Blank Ex:'Double or etc'")
	private String bookingType;
	@NotBlank(message = "Travel Autho Refrence Ex:'PNR,UTS or etc'")
	private String travelAutho;
	@NotBlank(message = "Travel Autho Id  Ex:'1234567848' or '569875")
	private String travelAuthoId;
	@NotBlank(message = "quota Autho is mandatory")
	 private String quota;
	@NotBlank(message = "acstatus is mandatory")
	 private String acstatus;
	@NotBlank(message = "bedtype is mandatory")
	 private String bedtype;
	
	
	
	
	
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	public String getAcstatus() {
		return acstatus;
	}
	public void setAcstatus(String acstatus) {
		this.acstatus = acstatus;
	}
	public String getBedtype() {
		return bedtype;
	}
	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}
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
