package com.rrWebservices.RRWebservices.servicesImpl;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrWebservices.RRWebservices.Dto.AvailableRoomListWithTariff;
import com.rrWebservices.RRWebservices.Dto.LocationSlotMStDTO;
import com.rrWebservices.RRWebservices.Dto.RoomAVList;
import com.rrWebservices.RRWebservices.Dto.RoomAmenitiesDto;
import com.rrWebservices.RRWebservices.Dto.RoomList;
import com.rrWebservices.RRWebservices.Dto.SlotList;
import com.rrWebservices.RRWebservices.Repository.RetiringroomSlotTarrifsRepo;
import com.rrWebservices.RRWebservices.Response.RoomAvailabilityListResponse;
import com.rrWebservices.RRWebservices.Services.SlotServices;
@Service
public class SlotServicesImpl  implements SlotServices  {
	 DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	 DateTimeFormatter TIMEFORMATTER = DateTimeFormatter.ofPattern("HH:mm");
	 SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired 
	 private RetiringroomSlotTarrifsRepo slotTarrifsRepo;
	
	 public List<SlotList> getAllslot() {
		 List<SlotList> list=new ArrayList<SlotList>();
		 List<Object> objlist=slotTarrifsRepo.getAllSlot();
		 for (Object itr : objlist) {
			 Object[] obj = (Object[]) itr;
			 SlotList dto=new SlotList();
			 if(!objlist.isEmpty()) {
				 dto.setSlotId(Integer.valueOf(String.valueOf(obj[0])));
				 dto.setSlotDuration(Integer.valueOf(String.valueOf(obj[1])));
				}
			    else {
			    dto.setMsg("Not available Slot");
			    }
			 list.add(dto);
		 }
		return list;
	}
	 
	 public List<LocationSlotMStDTO> getLocationWiseSlotId(int locationId,String checkInDateTime,String checkOutDateTime) {
		 //int locationId=1064;
		 // String checkInDateTime="2023-04-19 08:00:00";
		//  String checkOutDateTime="2023-04-19 20:00:00";
		  String checkin=(checkInDateTime.substring(11, 13)).concat("00");
		  String checkout=(checkOutDateTime.substring(11, 13)).concat("00");
		  List<LocationSlotMStDTO> slotList=new  ArrayList<LocationSlotMStDTO>();
		  List<Object> loctionslotId= slotTarrifsRepo.getloctionSlotId(locationId,checkin,checkout);
		      for(Object itr : loctionslotId) {
		    	  Object[] obj = (Object[]) itr;
		    	  LocationSlotMStDTO dto=new LocationSlotMStDTO();
		    	  dto.setId(Integer.valueOf(String.valueOf(obj[0])));
		    	  dto.setLocationId(Integer.valueOf(String.valueOf(obj[1])));
		    	  dto.setSlotId(Integer.valueOf(String.valueOf(obj[2])));
		    	  dto.setCheckinTime(String.valueOf(obj[3]));
		    	  dto.setCheckOutTime(String.valueOf(obj[4]));
		    	  slotList.add(dto);
		    	  System.out.println(slotList +" sltList");
		     }
		return slotList; 
	 }
	 
	 public List<RoomAmenitiesDto>  getRommFeaturesOnLocationId(int loctionId)
	  { List<RoomAmenitiesDto> list=new ArrayList<RoomAmenitiesDto>();
		 List<Object> objlist=slotTarrifsRepo.getRoomAmenities(loctionId);
		 for (Object itr : objlist) {
			 Object[] obj = (Object[]) itr;
			 RoomAmenitiesDto dto=new RoomAmenitiesDto();
			 if(!objlist.isEmpty()) {
				 dto.setRoomid(Integer.valueOf(String.valueOf(obj[0])));
				 dto.setRoomNo(String.valueOf(obj[1]));
				 dto.setAmenities(String.valueOf(obj[2]));
				}
			   list.add(dto);
			 }
		return list;
	  }
	 
	 public List<RoomList> allroomList()
	 {
		 List<RoomAVList> list1=new ArrayList<RoomAVList>();
		 List<RoomAVList> list11=new ArrayList<RoomAVList>();
		 List<AvailableRoomListWithTariff> list2=new  ArrayList<AvailableRoomListWithTariff>();
		 int locationId=1064;
		 
		 List<RoomList> list=new ArrayList<RoomList>();
		 List<Object> objlist= slotTarrifsRepo.getRoomList(locationId);
		 for (Object itr : objlist) {
			 Object[] obj = (Object[]) itr;
			 RoomList dto=new RoomList();
			 if(!objlist.isEmpty()) {
				 dto.setId(Integer.valueOf(String.valueOf(obj[0])));
				 dto.setLoctionId(Integer.valueOf(String.valueOf(obj[1])));
				}
			 
			 
			  list.add(dto);
			 }
		 System.out.println(list.size()+" --list.size()");
		 return list;
	 }
	 
	 public  List<RoomAVList> getavailableroomList(int locationId,String checkInDateTime,String checkOutDateTime)
	 {
		  String checkingDate=checkInDateTime;
		  String checkoutDate=checkOutDateTime;
		 
		  LocalDateTime  checkIndate = LocalDateTime.parse(checkingDate, DATEFORMATTER);		 
		  LocalDateTime  checkOutDate = LocalDateTime.parse(checkoutDate, DATEFORMATTER);
		  
		 List<RoomAVList> list=new ArrayList<RoomAVList>();
		 List<Object> objlist1= slotTarrifsRepo.getAvaRoomList(checkIndate,checkOutDate,checkIndate,checkOutDate,locationId);
		 for (Object itr : objlist1) {
			 Object[] obj = (Object[]) itr;
			 RoomAVList dto=new RoomAVList();
			 if(!objlist1.isEmpty()) {
				 dto.setRoomNo(String.valueOf(obj[0]));
				  dto.setRoomId(Integer.valueOf(String.valueOf(obj[1])));
				  dto.setFloorType(String.valueOf(obj[2]));
				  dto.setRoomType(String.valueOf(obj[3]));
				  dto.setBedType(String.valueOf(obj[4]));
				   	//dto.setTraiff(Double.valueOf(String.valueOf(obj[5])));
                    dto.setAcStatus(String.valueOf(obj[6]));
                    dto.setQuta(String.valueOf(obj[7]));
                    dto.setRoomStatus(String.valueOf(obj[8]));
           }   list.add(dto);
	  }
		 System.out.println(list.size()+" 2nd list");
		 return list;
	 }
	 
	 public List<LocationSlotMStDTO> getTarrif(int locationId,String checkInDateTime,String checkOutDateTime) {
		 String checkingDate=checkInDateTime;
		  String checkoutDate=checkOutDateTime;
		  long hours_difference=0;
		 int slotId=0;
		 System.out.println("kkkkkkkkkkkkkkkk");
		  List<LocationSlotMStDTO> slotList=new  ArrayList<LocationSlotMStDTO>();
		 try {
				 java.util.Date date1 = obj.parse(checkingDate);
				 java.util.Date date2=obj.parse(checkoutDate);
				 long time_difference = date2.getTime() - date1.getTime();
				  hours_difference = time_difference / (60 * 60 * 1000);     
				} catch (ParseException e) {
				e.printStackTrace();
			}
		 
		
		 
		 
		   if(hours_difference<=12 && hours_difference>0 ) {
			 slotId=1021;//12
			List<Object> list= slotTarrifsRepo.getslot12hr(locationId);
			 for(Object itr:list )
			 {
				 Object[] obj = (Object[]) itr;
				 if()
				 LocationSlotMStDTO dto=new LocationSlotMStDTO();
				 dto.setId(Integer.valueOf(String.valueOf(obj[0])));
				 dto.setSlotId(Integer.valueOf(String.valueOf(obj[2])));
				 slotList.add(dto);
				 
			 }
		
					 
		   
		   }else if(hours_difference<=24 && hours_difference>12 ){
			   slotId=1022;//24
			   slotId=1021; //12
			   
			   
			  
			  
		    }else if(hours_difference<=36 && hours_difference>24  )
		    {
		    	 slotId=1022; //24
		         slotId=1021;//12
		        
		    	 
		    }
		    else if(hours_difference<=48 && hours_difference>36)
		    {
		    	slotId=1022; //24
		         slotId=1021;//12
			      
		    }
		    else {
		    	System.out.println("Not Availbale slot");
		    }
		return slotList;
		 
	 }
	 
  public List<AvailableRoomListWithTariff> avlRoomList(int locationId,String checkInDateTime,String checkOutDateTime){
	      String checkingDate=checkInDateTime;
		  String checkoutDate=checkOutDateTime;
		  long hours_difference=0;
		 int slotId=0;
		 List<AvailableRoomListWithTariff> list2=new  ArrayList<AvailableRoomListWithTariff>();
		 List<LocationSlotMStDTO> slotList=new  ArrayList<LocationSlotMStDTO>();
		 try {
				 java.util.Date date1 = obj.parse(checkingDate);
				 java.util.Date date2=obj.parse(checkoutDate);
				 long time_difference = date2.getTime() - date1.getTime();
				  hours_difference = time_difference / (60 * 60 * 1000);     
				} catch (ParseException e) {
				e.printStackTrace();
			}
		   if(hours_difference<=12 && hours_difference>0 ) {
			 slotId=1021;//12
			 
					 
		   
		   }else if(hours_difference<=24 && hours_difference>12 ){
			   slotId=1022;//24
			   slotId=1021; //12
			  
			  
		    }else if(hours_difference<=36 && hours_difference>24  )
		    {
		    	 slotId=1022; //24
		         slotId=1021;//12
		        
		    	 
		    }
		    else if(hours_difference<=48 && hours_difference>36)
		    {
		    	slotId=1022; //24
		         slotId=1021;//12
			      
		    }
		    else {
		    	System.out.println("Not Availbale slot");
		    }
		 
		 
		 List<RoomAvailabilityListResponse> list =new ArrayList<RoomAvailabilityListResponse>();
         List<RoomAVList> availblearoom= getavailableroomList( locationId, checkInDateTime, checkOutDateTime);
		 List<AvailableRoomListWithTariff> list1=new ArrayList<AvailableRoomListWithTariff>();	
		 List<AvailableRoomListWithTariff> list3=new ArrayList<AvailableRoomListWithTariff>();	
		 for(int i=0;i<availblearoom.size();i++) {
			List<Object> objlist=  slotTarrifsRepo.getAvaRoomListWithBaseTraiff(locationId,availblearoom.get(i).getRoomId());
			
			 for (Object itr : objlist) {
				 Object[] obj = (Object[]) itr;
				 AvailableRoomListWithTariff dto=new AvailableRoomListWithTariff();
				 if(!objlist.isEmpty()) {
					
			         dto.setTarrifrates(Double .valueOf(String.valueOf(obj[2])));
					 dto.setLocationId(Integer.valueOf(String.valueOf(obj[3])));
					 dto.setSlotid(Integer.valueOf(String.valueOf(obj[4])));
					 dto.setRoom_id(Integer.valueOf(String.valueOf(obj[8])));   
				     dto.setLocationSlotId(Integer.valueOf(String.valueOf(obj[20])));
				    }
				 
				 list1.add(dto);
				 }
			
			
		 }
		 System.out.println(list.size()+"--------");
		
		return list1;
	 }



	
	 


}
