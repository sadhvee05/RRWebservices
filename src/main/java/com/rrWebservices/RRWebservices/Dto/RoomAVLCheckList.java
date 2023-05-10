package com.rrWebservices.RRWebservices.Dto;

import java.util.List;

public class RoomAVLCheckList {
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private String msg;
	private List<RoomAVList> roomAVList;

	public List<RoomAVList> getRoomAVList() {
		return roomAVList;
	}

	public void setRoomAVList(List<RoomAVList> roomAVList) {
		this.roomAVList = roomAVList;
	}
	
	
}
