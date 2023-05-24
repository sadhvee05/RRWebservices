package com.rrWebservices.RRWebservices.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrincipalStationResponce {

	private int stationid;
	private int areaid;
	private String stationcode;
	private int locationid;
	private String locationcode;
	
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStationid() {
		return stationid;
	}
	public void setStationid(int stationid) {
		this.stationid = stationid;
	}
	public int getAreaid() {
		return areaid;
	}
	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	public String getStationcode() {
		return stationcode;
	}
	public void setStationcode(String stationcode) {
		this.stationcode = stationcode;
	}
	public int getLocationid() {
		return locationid;
	}
	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}
	public String getLocationcode() {
		return locationcode;
	}
	public void setLocationcode(String locationcode) {
		this.locationcode = locationcode;
	}
	public PrincipalStationResponce(int stationid, String stationcode) {
		super();
		this.stationid = stationid;
		this.stationcode = stationcode;
	}
	public PrincipalStationResponce() {
		// TODO Auto-generated constructor stub
	}
	
}
