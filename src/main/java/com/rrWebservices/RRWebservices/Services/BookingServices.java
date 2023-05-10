package com.rrWebservices.RRWebservices.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rrWebservices.RRWebservices.Dto.RoomAVLCheckList;
import com.rrWebservices.RRWebservices.Response.BookingSearchResponse;

public interface BookingServices {
	
	List<BookingSearchResponse> getBookingSearch(String bookingId);
	List<RoomAVLCheckList> getRoomAvailabilityCheck(int stationCode, String checkInTime,String checkOutTime,String bookingType,String travelAuto,String travelAuthoId);
	



}
