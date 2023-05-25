package com.rrWebservices.RRWebservices.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrWebservices.RRWebservices.Dto.ErrorMsg;
import com.rrWebservices.RRWebservices.Dto.StationNameResponse;
import com.rrWebservices.RRWebservices.Services.LocationServices;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 

@RequestMapping("/rr/Webservices")
public class StationController {
	@Autowired
	  private LocationServices  locationServices;
	@Autowired
	 private ErrorMsg errorMsg;
	
	@GetMapping("/stationName") 
	public ResponseEntity<?> getStationName()
	{
		
		List<StationNameResponse> list= locationServices.getStationName();
		
		if(!list.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(list);
			else 
			return ResponseEntity.status(HttpStatus.OK).body(errorMsg.setMsg("Data Not Found on station"));
	}

	

	
}
