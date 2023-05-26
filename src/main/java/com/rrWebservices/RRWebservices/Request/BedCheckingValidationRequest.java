package com.rrWebservices.RRWebservices.Request;

public class BedCheckingValidationRequest {

	private int noOfGuests;
	private int roomId[];
	public int getNoOfGuests() {
		return noOfGuests;
	}
	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}
	public int[] getRoomId() {
		return roomId;
	}
	public void setRoomId(int[] roomId) {
		this.roomId = roomId;
	}
	
}
