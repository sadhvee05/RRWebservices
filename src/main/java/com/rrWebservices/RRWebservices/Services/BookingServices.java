package com.rrWebservices.RRWebservices.Services;

import java.util.List;

import com.rrWebservices.RRWebservices.Request.RoomAvailabilityCheckRequest;
import com.rrWebservices.RRWebservices.Response.BookingSearchResponse;

public interface BookingServices {
	
	List<BookingSearchResponse> getBookingSearch(String bookingId);
	String getRoomAvailabilityCheck(RoomAvailabilityCheckRequest roomAvailabilityCheckRequest);


}
