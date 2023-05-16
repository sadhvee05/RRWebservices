package com.rrWebservices.RRWebservices.Dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rrWebservices.RRWebservices.Constant.RrConstEnum;

import io.swagger.annotations.ApiModelProperty;

public class PnrResponse {
	
	 
	String sourceStation;
	int   sourceStationCode;
    String destinationStation;
    int destinationStationCode;
	String trainNumber;
	String trainName;
	String  hourlyOrSlot;
	
	//String pnrStatus;
	@ApiModelProperty(notes = "If train is cancelled, then this field will have mesage 'The Train Is Cancelled'. If there is no message in this field, that means train is Active.")
	String trainCancelStatus="";
	@JsonFormat(pattern=RrConstEnum.DATETIME_FORMATTER)
	LocalDateTime dateOfJourney;
	@JsonFormat(pattern=RrConstEnum.DATETIME_FORMATTER)
	LocalDateTime arrivalDate;
	int noOfPassengers;
	List<GuestInfoDto> guestsInfo;
	
	
	
	
	public int getSourceStationCode() {
		return sourceStationCode;
	}
	public void setSourceStationCode(int sourceStationCode) {
		this.sourceStationCode = sourceStationCode;
	}
	public int getDestinationStationCode() {
		return destinationStationCode;
	}
	public void setDestinationStationCode(int destinationStationCode) {
		this.destinationStationCode = destinationStationCode;
	}
	public String getHourlyOrSlot() {
		return hourlyOrSlot;
	}
	public void setHourlyOrSlot(String hourlyOrSlot) {
		this.hourlyOrSlot = hourlyOrSlot;
	}
	public String getTrainCancelStatus() {
		return trainCancelStatus;
	}
	public void setTrainCancelStatus(String trainCancelStatus) {
		this.trainCancelStatus = trainCancelStatus;
	}
	public String getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getSourceStation() {
		return sourceStation;
	}
	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}
	public String getDestinationStation() {
		return destinationStation;
	}
	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}
	public LocalDateTime getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(LocalDateTime dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public List<GuestInfoDto> getGuestsInfo() {
		return guestsInfo;
	}
	public void setGuestsInfo(List<GuestInfoDto> guestsInfo) {
		this.guestsInfo = guestsInfo;
	}
	public PnrResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PnrResponse(String sourceStation, int sourceStationCode, String destinationStation,
			int destinationStationCode, String trainNumber, String trainName, String hourlyOrSlot,
			String trainCancelStatus, LocalDateTime dateOfJourney, LocalDateTime arrivalDate, int noOfPassengers,
			List<GuestInfoDto> guestsInfo) {
		super();
		this.sourceStation = sourceStation;
		this.sourceStationCode = sourceStationCode;
		this.destinationStation = destinationStation;
		this.destinationStationCode = destinationStationCode;
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.hourlyOrSlot = hourlyOrSlot;
		this.trainCancelStatus = trainCancelStatus;
		this.dateOfJourney = dateOfJourney;
		this.arrivalDate = arrivalDate;
		this.noOfPassengers = noOfPassengers;
		this.guestsInfo = guestsInfo;
	}
	
	
}
