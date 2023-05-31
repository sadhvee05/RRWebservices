package com.rrWebservices.RRWebservices.Services;

import java.util.List;

import com.rrWebservices.RRWebservices.Response.BedCheckingValidationResponse;

public interface TestServices {
	public List<BedCheckingValidationResponse> bedroomAvailability(int noOfGuests,int roomId[]);
	public List<BedCheckingValidationResponse> bedroomAvailabilityProposedInfuture(int noOfGuests,int roomId[]);

}
