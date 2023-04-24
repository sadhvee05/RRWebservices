package com.rrWebservices.RRWebservices.Response;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rrWebservices.RRWebservices.Constant.RrConstEnum;

import io.swagger.annotations.ApiModelProperty;

public class AvailabilityResponse{
	Long locationSlotMapId;
	Long slotId;
	Long mstRoomId;
	String resourceNo;
	String bedType;
	String roomType;
	String acStatus;
	String feature;
	Short slotDurationInHrs;
	@ApiModelProperty(notes = "ceil((Base fare of slot. for Hourly booking 12HR fare) - floor(internet discount)).")
	Double amount;// rate for 12 hr
	@ApiModelProperty(notes = "for hourly booking:- a = ceiling(Base fare for FIRST 24hrs - floor(internetDiscount of Base fare for FIRST 24hrs)) <br><br>"
			+ "b = ceiling(ceiling(Base fare for NEXT 24hrs + ceiling(extend Charge on Base fare for NEXT 24hrs)) <br><br>"
			+ "c = ceiling(b - floor(internetDiscount on b)) <br><br>"
			+ "tariffHourly = b+c <br><br>"
			+ "Note: 1. for hourly booking Base fare is hourly percentage of 12Hr fare. <br><br>"
			+ "2. here extend charge is more than 24hr booking charge or (for terminal)extra charge if user extends booking. <br><br>")
	Double tariffHourly;// calcullated tariff
	Double extraBed;
	@JsonIgnore
	String checkin;
	@JsonIgnore
	String checkout;
	@JsonFormat(pattern=RrConstEnum.DATETIME_FORMATTER)
	LocalDateTime checkinTs;
	@JsonFormat(pattern=RrConstEnum.DATETIME_FORMATTER)
	LocalDateTime checkoutTs;
	@JsonIgnore
	Short dayDiff;
	@ApiModelProperty(notes = "used by hurly booking to show total booking duration in hrs.")
	int totalDuration;
	Boolean booked = false;
	Boolean maintenance = false;
	Boolean gstApplicableFlag = false;
	
	
	
	public Double getTariffHourly() {
		return tariffHourly;
	}
	public void setTariffHourly(Double tariffHourly) {
		this.tariffHourly = tariffHourly;
	}
	
	public int getTotalDuration() {
		return totalDuration;
	}
	public void setTotalDuration(int totalDuration) {
		this.totalDuration = totalDuration;
	}
	public String getAcStatus() {
		return acStatus;
	}
	public void setAcStatus(String acStatus) {
		this.acStatus = acStatus;
	}
	
	public Long getSlotId() {
		return slotId;
	}
	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Boolean getMaintenance() {
		return maintenance;
	}
	public void setMaintenance(Boolean maintenance) {
		this.maintenance = maintenance;
	}
	public Long getLocationSlotMapId() {
		return locationSlotMapId;
	}
	public void setLocationSlotMapId(Long locationSlotMapId) {
		this.locationSlotMapId = locationSlotMapId;
	}
	public Long getMstRoomId() {
		return mstRoomId;
	}
	public void setMstRoomId(Long mstRoomId) {
		this.mstRoomId = mstRoomId;
	}
	public LocalDateTime getCheckinTs() {
		return checkinTs;
	}
	public void setCheckinTs(LocalDateTime checkinTs) {
		this.checkinTs = checkinTs;
	}
	
	public LocalDateTime getCheckoutTs() {
		return checkoutTs;
	}
	public void setCheckoutTs(LocalDateTime checkoutTs) {
		this.checkoutTs = checkoutTs;
	}
	public String getResourceNo() {
		return resourceNo;
	}
	public void setResourceNo(String resourceNo) {
		this.resourceNo = resourceNo;
	}
	public String getBedType() {
		return bedType;
	}
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public Short getSlotDurationInHrs() {
		return slotDurationInHrs;
	}
	public void setSlotDurationInHrs(Short slotDurationInHrs) {
		this.slotDurationInHrs = slotDurationInHrs;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getExtraBed() {
		return extraBed;
	}
	public void setExtraBed(Double extraBed) {
		this.extraBed = extraBed;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public Short getDayDiff() {
		return dayDiff;
	}
	public void setDayDiff(Short dayDiff) {
		this.dayDiff = dayDiff;
	}
	
	public Boolean getBooked() {
		return booked;
	}
	public void setBooked(Boolean booked) {
		this.booked = booked;
	}
	public Boolean getGstApplicableFlag() {
		return gstApplicableFlag;
	}
	public void setGstApplicableFlag(Boolean gstApplicableFlag) {
		this.gstApplicableFlag = gstApplicableFlag;
	}
	
	
	@Override
	public String toString() {
		return "AvailabilityResponse [locationSlotMapId=" + locationSlotMapId + ", slotId=" + slotId + ", mstRoomId="
				+ mstRoomId + ", resourceNo=" + resourceNo + ", bedType=" + bedType + ", roomType=" + roomType
				+ ", acStatus=" + acStatus + ", feature=" + feature + ", slotDurationInHrs=" + slotDurationInHrs
				+ ", amount=" + amount + ", extraBed=" + extraBed + ", checkin=" + checkin + ", checkout=" + checkout
				+ ", checkinTs=" + checkinTs + ", checkoutTs=" + checkoutTs + ", dayDiff=" + dayDiff + ", booked="
				+ booked + ", maintenance=" + maintenance + ", gstApplicableFlag=" + gstApplicableFlag + "]";
	}
	
	
	//for normal avl
	public AvailabilityResponse(Long locationSlotMapId, Long slotId, Long mstRoomId, String resourceNo, String bedType, String roomType, String acStatus, String feature,
			Short slotDurationInHrs, Double amount, Double extraBed, String checkin, String checkout, Short dayDiff) throws Exception{
		super();
		this.locationSlotMapId = locationSlotMapId;
		this.slotId = slotId;
		this.mstRoomId = mstRoomId;
		this.resourceNo = resourceNo;
		this.bedType = bedType;
		this.roomType = roomType;
		this.acStatus = acStatus;
		this.feature = feature;
		this.slotDurationInHrs = slotDurationInHrs;
		this.amount = amount;
		this.extraBed = extraBed;
		this.checkin = checkin;
		this.checkout = checkout;
		this.dayDiff = dayDiff;
		try {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		this.checkinTs = LocalDateTime.parse(checkin, formatter);
		this.checkoutTs = LocalDateTime.parse(checkout, formatter).plusDays(dayDiff);
		}catch(Exception e) {
			throw new Exception("Error Parshing  Date.");
		}
	}
	
	//for hourly booking
	public AvailabilityResponse(Long locationSlotMapId, Long slotId, Long mstRoomId, String resourceNo, String bedType, String roomType, String acStatus, String feature,
			Short slotDurationInHrs, Double amount, Double extraBed){
		super();
		this.locationSlotMapId = locationSlotMapId;
		this.slotId = slotId;
		this.mstRoomId = mstRoomId;
		this.resourceNo = resourceNo;
		this.bedType = bedType;
		this.roomType = roomType;
		this.acStatus = acStatus;
		this.feature = feature;
		this.slotDurationInHrs = slotDurationInHrs;
		this.amount = amount;
		this.extraBed = extraBed;
	}
	
	
	
	public AvailabilityResponse(Long locationSlotMapId, Long slotId, Long mstRoomId, String resourceNo, String bedType,
			String roomType, String acStatus, String feature, Short slotDurationInHrs, Double amount, Double extraBed,
			String checkin, String checkout, LocalDateTime checkinTs, LocalDateTime checkoutTs, Short dayDiff,
			Boolean booked, Boolean maintenance, Boolean gstApplicableFlag) {
		super();
		this.locationSlotMapId = locationSlotMapId;
		this.slotId = slotId;
		this.mstRoomId = mstRoomId;
		this.resourceNo = resourceNo;
		this.bedType = bedType;
		this.roomType = roomType;
		this.acStatus = acStatus;
		this.feature = feature;
		this.slotDurationInHrs = slotDurationInHrs;
		this.amount = amount;
		this.extraBed = extraBed;
		this.checkin = checkin;
		this.checkout = checkout;
		this.checkinTs = checkinTs;
		this.checkoutTs = checkoutTs;
		this.dayDiff = dayDiff;
		this.booked = booked;
		this.maintenance = maintenance;
		this.gstApplicableFlag = gstApplicableFlag;
	}
	public AvailabilityResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
