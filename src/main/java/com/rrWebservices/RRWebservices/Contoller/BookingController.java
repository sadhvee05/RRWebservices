package com.rrWebservices.RRWebservices.Contoller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rrWebservices.RRWebservices.Request.RoomAvailabilityCheckRequest;
import com.rrWebservices.RRWebservices.Response.BookingSearchResponse;
import com.rrWebservices.RRWebservices.Services.BookingServices;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("/rr/")
public class BookingController {

	@Autowired
	 private BookingServices bookingServices;
	


		@GetMapping(value="/bookingSearch/{bookingId}", produces = "application/json")
	   	public ResponseEntity<List<BookingSearchResponse>>  bookingSearch(@PathVariable String bookingId)
	   	{
			   return ResponseEntity.status(HttpStatus.OK).body(bookingServices.getBookingSearch(bookingId));	
	  
	   	}
		//Room Availability Check
		@GetMapping(value="/roomAvailabilityCheck", produces = "application/json")
	   	public ResponseEntity<String>  bookingSearch(@RequestParam RoomAvailabilityCheckRequest roomAvailabilityCheckRequest)
	   	{
			  return ResponseEntity.status(HttpStatus.OK).body(bookingServices.getRoomAvailabilityCheck(roomAvailabilityCheckRequest));	
			  // return null;
	   	}

		
	 
}
