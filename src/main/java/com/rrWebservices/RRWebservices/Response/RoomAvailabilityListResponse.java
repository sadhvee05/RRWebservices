package com.rrWebservices.RRWebservices.Response;

public class RoomAvailabilityListResponse {

	private String roomNo;
	private int roomId;
	private String roomType;
	private String bedType;
	private String roomFeatures;
	private String quta;
	private String roomStatus;
	
	private double tarrifrates;
	private int locationId;
	private int slotid;

    private int room_id;
    private double extraBedCharge;
    private int locationSlotId;
    
    private String checkIn;
    private String checkOut;
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
	public String getRoomFeatures() {
		return roomFeatures;
	}
	public void setRoomFeatures(String roomFeatures) {
		this.roomFeatures = roomFeatures;
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
	public int getLocationSlotId() {
		return locationSlotId;
	}
	public void setLocationSlotId(int locationSlotId) {
		this.locationSlotId = locationSlotId;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public String getQuta() {
		return quta;
	}
	public void setQuta(String quta) {
		this.quta = quta;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
    
	
}
