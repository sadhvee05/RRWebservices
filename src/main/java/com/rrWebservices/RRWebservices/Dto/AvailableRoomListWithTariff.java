package com.rrWebservices.RRWebservices.Dto;

public class AvailableRoomListWithTariff {

	private int id;
	//private int tarridId;
	private double baseTarrif;
	private int locationId;
	private int slotid;
  //  private int room_id;
    private double extraBedCharge=0.0;
  //  private int available;
	private int locationSlotId;
	private String checkinTime="";
	private String CheckOutTime="";
	private double totalTarrif;
	private String msg="";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	


	public double getBaseTarrif() {
		return baseTarrif;
	}
	public void setBaseTarrif(double baseTarrif) {
		this.baseTarrif = baseTarrif;
	}
	
	public double getTotalTarrif() {
		return totalTarrif;
	}
	public void setTotalTarrif(double totalTarrif) {
		this.totalTarrif = totalTarrif;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public int getSlotid() {
		return slotid;
	}
	public void setSlotid(int slotid) {
		this.slotid = slotid;
	}
	
	public double getExtraBedCharge() {
		return extraBedCharge;
	}
	public void setExtraBedCharge(double extraBedCharge) {
		this.extraBedCharge = extraBedCharge;
	}
	
	public int getLocationSlotId() {
		return locationSlotId;
	}
	public void setLocationSlotId(int locationSlotId) {
		this.locationSlotId = locationSlotId;
	}
	public String getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}
	public String getCheckOutTime() {
		return CheckOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		CheckOutTime = checkOutTime;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
