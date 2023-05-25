package com.rrWebservices.RRWebservices.Contoller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrWebservices.RRWebservices.Dto.ErrorMsg;
import com.rrWebservices.RRWebservices.Dto.RoomAVLCheckList;
import com.rrWebservices.RRWebservices.Request.RoomAvailabilityCheckRequest;
import com.rrWebservices.RRWebservices.Response.BookingSearchResponse;
import com.rrWebservices.RRWebservices.Services.BookingServices;

import jakarta.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("/rr/Webservices")
public class BookingController {

	@Autowired
	 private BookingServices bookingServices;
	@Autowired
	private ErrorMsg errorMsg;


		@GetMapping(value="/bookingSearch/{bookingId}", produces = "application/json")
	   	public ResponseEntity<?>  bookingSearch(@PathVariable String bookingId)
	   	{
			List<BookingSearchResponse> objlist =   bookingServices.getBookingSearch(bookingId);
			if(null!=objlist.get(0).getErrorMsg())
			{
				errorMsg.setMsg(objlist.get(0).getErrorMsg());
			   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMsg);	
			}
			else
				 return ResponseEntity.status(HttpStatus.OK).body(objlist);	
			
	   	}
		
		//Room Availability Check
		@PostMapping(value="/roomAvailabilityCheck", produces = "application/json")
	   	public   ResponseEntity<?> getbookingSearch(@Valid @RequestBody RoomAvailabilityCheckRequest roomAvlCheckReq)
	   	{
		
			RoomAVLCheckList  obj=bookingServices.getRoomAvailabilityCheck(roomAvlCheckReq.getStationCode(),
					  roomAvlCheckReq.getCheckInTime(),roomAvlCheckReq.getCheckOutTime(),roomAvlCheckReq.getBookingType(),
					  roomAvlCheckReq.getTravelAutho(),roomAvlCheckReq.getTravelAuthoId(),
					  roomAvlCheckReq.getAcstatus(),roomAvlCheckReq.getBedtype(),roomAvlCheckReq.getQuota()  );
			if( null==obj.getRoomAVList() ) {
				errorMsg.setMsg(obj.getMsg());
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMsg);
			}
			else
			return ResponseEntity.status(HttpStatus.OK).body(obj);
		 	
	   	}
		
	 
}
