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

import com.rrWebservices.RRWebservices.Dto.AvailableRoomListWithTariff;
import com.rrWebservices.RRWebservices.Dto.ErrorMsg;
import com.rrWebservices.RRWebservices.Dto.LocationSlotMStDTO;
import com.rrWebservices.RRWebservices.Dto.RoomAVList;
import com.rrWebservices.RRWebservices.Dto.RoomAmenitiesDto;
import com.rrWebservices.RRWebservices.Dto.RoomList;
import com.rrWebservices.RRWebservices.Dto.SlotList;
import com.rrWebservices.RRWebservices.Dto.SlotRequestDto;
import com.rrWebservices.RRWebservices.Services.SlotServices;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("/rr/Webservices")
public class SlotControler {

	 @Autowired
	 private  SlotServices slotServices;	
	 @Autowired
	 private ErrorMsg errorMsg;
	 @GetMapping("/slotList") 
		public ResponseEntity<List<SlotList> > getslotList()
		{
			return ResponseEntity.status(HttpStatus.OK).body(slotServices.getAllslot());
		}
	 
	 @GetMapping("/allRoomList") 
		public ResponseEntity<List<RoomList> > allroomList()
		{
			return ResponseEntity.status(HttpStatus.OK).body(slotServices.allroomList());
		}
	 
	 @GetMapping("/avalibleRoomList") 
		public ResponseEntity<List<RoomAVList> > getavailableroomInRRTXn(@RequestBody SlotRequestDto slotRequestDto)
		{
			return ResponseEntity.status(HttpStatus.OK).body(slotServices.
					getavailableroomList(slotRequestDto.getLocationId(), slotRequestDto.getCheckInDateTime(),slotRequestDto.getCheckOutDateTime(),
							slotRequestDto.getQuota(),slotRequestDto.getAcstatus(),slotRequestDto.getBedtype()
							));
		}

	 @GetMapping("/roomAvailabilitySearch") 
		public ResponseEntity<?> getroomAvailabilitySearch(@RequestBody SlotRequestDto slotRequestDto)
		{
		  
		 List<RoomAVList> list =slotServices.getroomAvailabilitySearch(slotRequestDto.getLocationId(), slotRequestDto.getCheckInDateTime(),slotRequestDto.getCheckOutDateTime()
							,slotRequestDto.getHourlyOrSlot());
		if( list.get(0).getMsg()=="" || list.get(0).getMsg().equals(null) )
		{
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		else
			return ResponseEntity.status(HttpStatus.OK).body(errorMsg.setMsg(list.get(0).getMsg()));	
		}
	 
	 
		/*
		 * @GetMapping("/AvlRoomList") // no need public
		 * ResponseEntity<List<AvailableRoomListWithTariff>> AvlRoomList(@RequestBody
		 * SlotRequestDto slotRequestDto) { return
		 * ResponseEntity.status(HttpStatus.OK).body(slotServices.avlRoomList(
		 * slotRequestDto.getLocationId(),
		 * slotRequestDto.getCheckInDateTime(),slotRequestDto.getCheckOutDateTime())); }
		 */

	    
   @GetMapping(value="/getLocationWiseSlotId", produces = "application/json")
  	public ResponseEntity<List<LocationSlotMStDTO>>  getLocationWiseSlotId
  	(@RequestBody SlotRequestDto slotRequestDto)
  	{
   return ResponseEntity.status(HttpStatus.OK).body(slotServices.getLocationWiseSlotId(slotRequestDto.getLocationId(),
		   slotRequestDto.getCheckInDateTime(),slotRequestDto.getCheckOutDateTime()));
  	}
  
   @GetMapping(value="/geRoomAmenities", produces = "application/json")
 	public ResponseEntity<List<RoomAmenitiesDto>>  getRoomAmenitiesDto
 	(@RequestBody SlotRequestDto slotRequestDto)
 	{
    return ResponseEntity.status(HttpStatus.OK).body(slotServices.getRommFeaturesOnLocationId(slotRequestDto.getLocationId()));
 	}
   
   @GetMapping(value="/getTrarrif", produces = "application/json")
	public ResponseEntity<List<AvailableRoomListWithTariff>>  getTrarrif
	(@RequestBody SlotRequestDto slotRequestDto)
	{
   return ResponseEntity.status(HttpStatus.OK).body(slotServices.getTarrif(slotRequestDto.getLocationId(),
		   0, slotRequestDto.getCheckInDateTime(),slotRequestDto.getCheckOutDateTime()));
	}
}
