package com.rrWebservices.RRWebservices.Dto;

import java.util.List;

public class BookingSummaryRequest {
	
	 
	    private int stationCode;
		private String checkInTime;
		private String checkOutTime;
		private String bookingType;
		private String travelAutho;
		private String travelAuthoId;
		private String quota;
		private String acstatus;
	
		
		private int noOfGuests;
		private int roomId[];
		
		List<GuestInfoDto> guestInfoDto;
		

}
