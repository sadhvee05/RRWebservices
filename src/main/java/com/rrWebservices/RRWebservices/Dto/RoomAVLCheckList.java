package com.rrWebservices.RRWebservices.Dto;

import java.util.List;

public class RoomAVLCheckList {


	private String msg;
	private List<RoomAVList> roomAVList;

	public List<RoomAVList> getRoomAVList() {
		return roomAVList;
	}

	public void setRoomAVList(List<RoomAVList> roomAVList) {
		this.roomAVList = roomAVList;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
