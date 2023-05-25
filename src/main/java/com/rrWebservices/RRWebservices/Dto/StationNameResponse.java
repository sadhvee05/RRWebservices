package com.rrWebservices.RRWebservices.Dto;

public class StationNameResponse {
	private int id;
	private String locationCode;
	private String description;
	private String stationname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	
	
	
	//SELECT id,location_code,description,
	//CONCAT(description,' (',location_code,')') AS 'stationname' 
	//FROM retiringroom_location_master ",

}
