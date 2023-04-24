package com.rrWebservices.RRWebservices.Services;

import java.util.List;

import com.rrWebservices.RRWebservices.Dto.CheckInCheckOutTimeResponse;
import com.rrWebservices.RRWebservices.Dto.PnrResponce;
import com.rrWebservices.RRWebservices.Dto.PnrResponse;
import com.rrWebservices.RRWebservices.Dto.PrincipalStationResponce;
import com.rrWebservices.RRWebservices.Dto.RoomTypeResponse;
import com.rrWebservices.RRWebservices.Entity.RetiringroomBookingReservationEntity;
import com.rrWebservices.RRWebservices.Entity.RetiringroomLocationMaster;

import cris.prs.rail.dto.PnrEnquiryResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public interface Services {
	
	List<RoomTypeResponse> getStaionModeHourlyOrSlot(int staionId);
	List<PrincipalStationResponce> getprincipalStation(int stationId);
	List<CheckInCheckOutTimeResponse> getCheckInCheckOut(int locationId);
	PnrResponse getPnrenquery1(String pnrNo);
	

}
