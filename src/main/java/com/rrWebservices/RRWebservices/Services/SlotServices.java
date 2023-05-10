package com.rrWebservices.RRWebservices.Services;

import java.util.List;

import com.rrWebservices.RRWebservices.Dto.AvailableRoomListWithTariff;
import com.rrWebservices.RRWebservices.Dto.LocationSlotMStDTO;
import com.rrWebservices.RRWebservices.Dto.RoomAVList;
import com.rrWebservices.RRWebservices.Dto.RoomAmenitiesDto;
import com.rrWebservices.RRWebservices.Dto.RoomList;
import com.rrWebservices.RRWebservices.Dto.SlotList;

public interface SlotServices {
	 List<SlotList> getAllslot();
	 List<RoomList> allroomList();
	
	 List<RoomAVList> getavailableroomList(int locationId,String checkInDateTime,String checkOutDateTime);
		
	 List<AvailableRoomListWithTariff> avlRoomList(int locationId,String checkInDateTime,String checkOutDateTime);
	// 
	 //locationId,checkInDateTime,checkOutDateTime
	 List<LocationSlotMStDTO> getLocationWiseSlotId(int locationId,String checkInDateTime,String checkOutDateTime);
	 List<RoomAmenitiesDto>  getRommFeaturesOnLocationId(int loctionId);	
     List<AvailableRoomListWithTariff> getTarrif(int locationId,int roomId,String checkInDateTime,String checkOutDateTime);
     	 
			
}
