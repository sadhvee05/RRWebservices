package com.rrWebservices.RRWebservices.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrWebservices.RRWebservices.Dto.ErrorMsg;
import com.rrWebservices.RRWebservices.Request.BedCheckingValidationRequest;
import com.rrWebservices.RRWebservices.Response.BedCheckingValidationResponse;
import com.rrWebservices.RRWebservices.Services.TestServices;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("/rr/Webservices")
public class Testcontroller {

	@Autowired
	 private TestServices testServices;
	@Autowired
	private ErrorMsg errorMsg;


		@GetMapping(value="/bedcheckingvalidation", produces = "application/json")
	   	public ResponseEntity<?>  bookingSearch(@RequestBody BedCheckingValidationRequest bedValidationRequest)
	   	{
			List<BedCheckingValidationResponse> msg =   testServices.bedroomAvailability(bedValidationRequest.getNoOfGuests(),bedValidationRequest.getRoomId());
			if(msg==null)
			{
				errorMsg.setMsg("error msg");
			   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMsg);	
			}
			else
				 return ResponseEntity.status(HttpStatus.OK).body(msg);	
			
	   	}
}
