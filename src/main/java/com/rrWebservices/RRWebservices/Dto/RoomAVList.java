package com.rrWebservices.RRWebservices.Dto;

import java.util.List;

public class RoomAVList {
	
	private String roomNo;
	private int roomId;
	private String amenities;
	private String floorType;
	private String roomType;
	private String bedType;
	private double basetarrif;
	private String acStatus;
	private String quota;
	private String roomStatus;
	private String checkinTime;
	private String checkingSlot;
	
	private String CheckoutSlot;
	private String CheckoutTime;
	private double totaltarrif;
	private double extrabedcharge;
	
	private String duration;
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	private String msg="";
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getAmenities() {
		return amenities;
	}
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	public String getFloorType() {
		return floorType;
	}
	public void setFloorType(String floorType) {
		this.floorType = floorType;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getBedType() {
		return bedType;
	}
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	public double getBasetarrif() {
		return basetarrif;
	}
	public void setBasetarrif(double basetarrif) {
		this.basetarrif = basetarrif;
	}
	public String getAcStatus() {
		return acStatus;
	}
	public void setAcStatus(String acStatus) {
		this.acStatus = acStatus;
	}
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public String getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}
	public String getCheckingSlot() {
		return checkingSlot;
	}
	public void setCheckingSlot(String checkingSlot) {
		this.checkingSlot = checkingSlot;
	}
	public String getCheckoutSlot() {
		return CheckoutSlot;
	}
	public void setCheckoutSlot(String checkoutSlot) {
		CheckoutSlot = checkoutSlot;
	}
	public String getCheckoutTime() {
		return CheckoutTime;
	}
	public void setCheckoutTime(String checkoutTime) {
		CheckoutTime = checkoutTime;
	}
	public double getTotaltarrif() {
		return totaltarrif;
	}
	public void setTotaltarrif(double totaltarrif) {
		this.totaltarrif = totaltarrif;
	}
	public double getExtrabedcharge() {
		return extrabedcharge;
	}
	public void setExtrabedcharge(double extrabedcharge) {
		this.extrabedcharge = extrabedcharge;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	
	
	
	//private List<AvailableRoomListWithTariff> tarrifDetails;

	
	
}
