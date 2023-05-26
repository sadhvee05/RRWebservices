package com.rrWebservices.RRWebservices.Response;

public class BedCheckingValidationResponse {
	private int roomId[];

	public int[] getRoomId() {
		return roomId;
	}

	public void setRoomId(int[] roomId) {
		this.roomId = roomId;
	}
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	private int selectioncount;

	public int getSelectioncount() {
		return selectioncount;
	}

	public void setSelectioncount(int selectioncount) {
		this.selectioncount = selectioncount;
	}
	
}
