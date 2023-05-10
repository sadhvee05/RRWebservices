package com.rrWebservices.RRWebservices.Services;

import java.util.List;

import com.rrWebservices.RRWebservices.Dto.CheckInCheckOutTimeResponse;
import com.rrWebservices.RRWebservices.Dto.PnrResponse;
import com.rrWebservices.RRWebservices.Dto.PrincipalStationResponce;
import com.rrWebservices.RRWebservices.Dto.RoomTypeResponse;


public interface Services {
	
	List<RoomTypeResponse> getStaionModeHourlyOrSlot(int staionId);
	List<PrincipalStationResponce> getprincipalStation(String stationCD);
	List<CheckInCheckOutTimeResponse> getCheckInCheckOut(int locationId);
	
	PnrResponse getPnrenquery1(String pnrNo);
	
	

}
