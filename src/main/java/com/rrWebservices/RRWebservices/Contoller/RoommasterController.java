package com.rrWebservices.RRWebservices.Contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rrWebservices.RRWebservices.Dto.ErrorMsg;
import com.rrWebservices.RRWebservices.Entity.RetiringroomMaintenanceInfo;
import com.rrWebservices.RRWebservices.Entity.RetiringroomRoommaster;
import com.rrWebservices.RRWebservices.Response.BookingSearchResponse;
import com.rrWebservices.RRWebservices.Services.BookingServices;
import com.rrWebservices.RRWebservices.Services.RommMasterServices;
import com.rrWebservices.RRWebservices.Validation.RoomAvailabilityValidation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("/rr/Webservices")
public class RoommasterController {
	@Autowired
	 private RommMasterServices rommMasterServices;
	@Autowired 
	private RoomAvailabilityValidation validation;
	@Autowired
	private ErrorMsg errorMsg;
	
	@GetMapping(value="/getRooms/{locationId}", produces = "application/json")
   	public ResponseEntity<?>  getRooms(@PathVariable int locationId)
   	{
		
		List<RetiringroomRoommaster>  roomlist =rommMasterServices.getRoomId(locationId);
		if(roomlist.size()==0)
		{ errorMsg.setMsg("Room Not available on this location ");
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMsg);	
		}
		else
	    return ResponseEntity.status(HttpStatus.OK).body(roomlist);	
   	}
	
	@GetMapping(value="/getRoommMaintenanceInfo/{locationId}", produces = "application/json")
   	public ResponseEntity<?>  getRoommMaintenanceInfo(@PathVariable int roomId)
   	{
		
		List<RetiringroomMaintenanceInfo>  roomMaintenancelist =rommMasterServices.getRoommMaintenanceInfo(roomId);
		if(roomMaintenancelist.size()==0)
		{ errorMsg.setMsg("Rooms are  Not under Maintenance on This Loction " );
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMsg);	
		}
		else
	    return ResponseEntity.status(HttpStatus.OK).body(roomMaintenancelist);	
   	}
	
	
	
}
