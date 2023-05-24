package com.rrWebservices.RRWebservices.Dto;

public class SlotRequestDto {
	private int locationId;
	private String checkInDateTime;
	private String checkOutDateTime;
	private String quota;
	private String acstatus;
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
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getCheckInDateTime() {
		return checkInDateTime;
	}
	public void setCheckInDateTime(String checkInDateTime) {
		this.checkInDateTime = checkInDateTime;
	}
	public String getCheckOutDateTime() {
		return checkOutDateTime;
	}
	public void setCheckOutDateTime(String checkOutDateTime) {
		this.checkOutDateTime = checkOutDateTime;
	}
	

}
