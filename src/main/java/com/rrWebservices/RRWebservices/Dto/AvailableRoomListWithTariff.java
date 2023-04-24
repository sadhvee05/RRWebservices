package com.rrWebservices.RRWebservices.Dto;

public class AvailableRoomListWithTariff {

	private int id;
	private int tarridId;
	private double tarrifrates;
	private int locationId;
	private int slotid;
    private int room_id;
    private double extraBedCharge;
    private int available;
	private int locationSlotId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTarridId() {
		return tarridId;
	}
	public void setTarridId(int tarridId) {
		this.tarridId = tarridId;
	}
	public double getTarrifrates() {
		return tarrifrates;
	}
	public void setTarrifrates(double tarrifrates) {
		this.tarrifrates = tarrifrates;
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
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public double getExtraBedCharge() {
		return extraBedCharge;
	}
	public void setExtraBedCharge(double extraBedCharge) {
		this.extraBedCharge = extraBedCharge;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getLocationSlotId() {
		return locationSlotId;
	}
	public void setLocationSlotId(int locationSlotId) {
		this.locationSlotId = locationSlotId;
	}
	
}
