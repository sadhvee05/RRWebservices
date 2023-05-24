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
import com.rrWebservices.RRWebservices.Validation.RoomAvailabilityValidation;
@Service
public class SlotServicesImpl  implements SlotServices  {
	 DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	 DateTimeFormatter TIMEFORMATTER = DateTimeFormatter.ofPattern("HH:mm");
	 SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired 
	 private RetiringroomSlotTarrifsRepo slotTarrifsRepo;
	@Autowired 
	private RoomAvailabilityValidation validations;
	
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
	 
	 public  List<RoomAVList> getavailableroomList(int locationId,String checkInDateTime,String checkOutDateTime,String quota,String acStatus,String bedType)
	 {
		  String checkingDate=checkInDateTime;
		  String checkoutDate=checkOutDateTime;
		 
		  LocalDateTime  checkIndate = LocalDateTime.parse(checkingDate, DATEFORMATTER);		 
		  LocalDateTime  checkOutDate = LocalDateTime.parse(checkoutDate, DATEFORMATTER);
		  
		 List<RoomAVList> list=new ArrayList<RoomAVList>();
		// List<Object> objlist1= slotTarrifsRepo.getAvaRoomList(checkIndate,checkOutDate,checkIndate,checkOutDate,locationId);
		 
		 List<Object> objlist1= slotTarrifsRepo.getAvaRoomList(checkOutDate,checkIndate,checkOutDate,checkIndate,checkOutDate,checkIndate,locationId,quota,acStatus,bedType);
		 System.out.println(" room size n*********  "+objlist1.size());
		 for (Object itr : objlist1) {
			 Object[] obj = (Object[]) itr;
			 RoomAVList dto=new RoomAVList();
			 if(!objlist1.isEmpty()) {
				 
				  dto.setRoomId(Integer.valueOf(String.valueOf(obj[0])));
				  dto.setRoomNo(String.valueOf(obj[1]));
				  dto.setAmenities(String.valueOf(obj[2]));
				  dto.setFloorType(String.valueOf(obj[3]));
				  dto.setRoomType(String.valueOf(obj[4]));
				  dto.setBedType(String.valueOf(obj[5]));
				   	//dto.setTraiff(Double.valueOf(String.valueOf(obj[5])));
                    dto.setAcStatus(String.valueOf(obj[7]));
                    dto.setQuota(String.valueOf(obj[8]));
                    dto.setRoomStatus(String.valueOf(obj[9]));
                    int roomId=dto.getRoomId();
                    
                    List<AvailableRoomListWithTariff> list1= getTarrif( locationId,roomId,checkInDateTime, checkOutDateTime);
                    for(AvailableRoomListWithTariff data:list1)
                    {
                    	dto.setBasetarrif(data.getBaseTarrif());
                    	dto.setTotaltarrif(data.getTotalTarrif());
                    	dto.setExtrabedcharge(data.getExtraBedCharge());
                    	dto.setCheckingSlot(data.getCheckinTime());
                    	dto.setCheckinTime(checkInDateTime);
                    	dto.setCheckoutSlot(data.getCheckOutTime());
                    	dto.setCheckoutTime(checkOutDateTime);
                    	dto.setDuration(validations.checkingAndCheckoutTimeduration(checkInDateTime,checkOutDateTime));
                    	//dto.setCheckinTime1(checkInDateTime);
                    	dto.setMsg(data.getMsg());
                    }
                    
                    
                       //dto.setTarrifDetails(getTarrif( locationId,roomId,checkInDateTime, checkOutDateTime));
                    
           }   list.add(dto);
	  }
		 System.out.println(list.size()+" 2nd list");
		 return list;
	 }
	 
	 public List<AvailableRoomListWithTariff> getTarrif(int locationId,int roomId,String checkInDateTime,String checkOutDateTime) {
		 String checkingDate=checkInDateTime; //
		 //"locationId" : 1064,
		  //  "checkInDateTime" : "2023-04-19 08:00:00",
		  //  "checkOutDateTime" :"2023-04-19 20:00:00"
		   
		  String checkoutDate=checkOutDateTime;
		  long hours_difference=0;
		  String checkinTime=(checkingDate.substring(10, 13)).concat("00");
		  String checkoutTime=(checkoutDate.substring(10, 13)).concat("00");
		  List<LocationSlotMStDTO> slotList=new  ArrayList<LocationSlotMStDTO>();
		  List<AvailableRoomListWithTariff> trarriflist=new ArrayList<AvailableRoomListWithTariff>();
		 try {
				 java.util.Date date1 = obj.parse(checkingDate);
				 java.util.Date date2=obj.parse(checkoutDate);
				 long time_difference = date2.getTime() - date1.getTime();
				  hours_difference = time_difference / (60 * 60 * 1000);     
				} catch (ParseException e) {
				e.printStackTrace();
			}
		 if(hours_difference<3 )
		 {
			 AvailableRoomListWithTariff tarrifdto=new AvailableRoomListWithTariff();
	    	 tarrifdto.setMsg(" Minimum Booking 3hr.");
	    	 trarriflist.add(tarrifdto); 
		 }
		 else if(hours_difference<=12 && hours_difference>=3 ) {
			 List<Object> list= slotTarrifsRepo.getslot12hr(locationId);
			 for(Object itr:list )
			 {
			     Object[] obj = (Object[]) itr;
			     LocationSlotMStDTO dto=new LocationSlotMStDTO();
				 dto.setId(Integer.valueOf(String.valueOf(obj[0])));
				 dto.setSlotId(Integer.valueOf(String.valueOf(obj[2])));
				 dto.setCheckinTime(String.valueOf(obj[3]));
				 dto.setCheckOutTime(String.valueOf(obj[5]));
				 slotList.add(dto);
				if(checkinTime.trim().equals(dto.getCheckinTime().trim()) && checkoutTime.trim().equals(dto.getCheckOutTime().trim())) {
				 List<Object> triflistOnLocslotId= slotTarrifsRepo.gettarrifBasedOnSlot(locationId,roomId,Integer.valueOf(String.valueOf(obj[0])));
				 for(Object itr1:triflistOnLocslotId )
				 {
					 Object[] obj1 = (Object[]) itr1;
					 double baseTrarrif=Double.valueOf(String.valueOf(obj1[2]));
					  double totalTarrif=baseTrarrif ;
					 AvailableRoomListWithTariff tarrifdto=new AvailableRoomListWithTariff();
					 tarrifdto.setId(Integer.valueOf(String.valueOf(obj1[0])));
					 tarrifdto.setBaseTarrif(Double.valueOf(String.valueOf(obj1[2])));
					 tarrifdto.setTotalTarrif(totalTarrif);
					 tarrifdto.setLocationId(Integer.valueOf(String.valueOf(obj1[3])));
					 tarrifdto.setSlotid(Integer.valueOf(String.valueOf(obj1[4])));
					// tarrifdto.setRoom_id(Integer.valueOf(String.valueOf(obj1[8])));
					 tarrifdto.setLocationSlotId(Integer.valueOf(String.valueOf(obj1[20])));
					 tarrifdto.setCheckinTime(dto.getCheckinTime());
				     tarrifdto.setCheckOutTime(dto.getCheckOutTime());
				     trarriflist.add(tarrifdto); 
					
				 }
			 } 
				 
			 }
			
		   
		   }else if(hours_difference<=24 && hours_difference>12 ){
			      double totalTarrif=0.0;	
				 List<Object> list= slotTarrifsRepo.getslot12hrAnd24hr(locationId);
				 for(Object itr:list )
				 {
					 Object[] obj = (Object[]) itr;
				     LocationSlotMStDTO dto=new LocationSlotMStDTO();
					 dto.setId(Integer.valueOf(String.valueOf(obj[0])));
					 dto.setSlotId(Integer.valueOf(String.valueOf(obj[2])));
					 dto.setCheckinTime(String.valueOf(obj[3]));
					 dto.setCheckOutTime(String.valueOf(obj[5]));
					 slotList.add(dto);
					 if(checkinTime.trim().equals(dto.getCheckinTime().trim()) && checkoutTime.trim().equals(dto.getCheckOutTime().trim())  ) {
							
					 List<Object> triflistOnLocslotId= slotTarrifsRepo.gettarrifBasedOnSlot(locationId,roomId,Integer.valueOf(String.valueOf(obj[0])));
					 for(Object itr1:triflistOnLocslotId )
					 {
						 Object[] obj1 = (Object[]) itr1;


						  double baseTrarrif=Double.valueOf(String.valueOf(obj1[2]));
						   totalTarrif=baseTrarrif ;
                         AvailableRoomListWithTariff tarrifdto=new AvailableRoomListWithTariff();
                         tarrifdto.setId(Integer.valueOf(String.valueOf(obj1[0])));
						 tarrifdto.setBaseTarrif(Double.valueOf(String.valueOf(obj1[2])));
						 tarrifdto.setTotalTarrif(totalTarrif);
						 tarrifdto.setLocationId(Integer.valueOf(String.valueOf(obj1[3])));
						 tarrifdto.setSlotid(Integer.valueOf(String.valueOf(obj1[4])));
						
						 //tarrifdto.setRoom_id(Integer.valueOf(String.valueOf(obj1[8])));
						 tarrifdto.setLocationSlotId(Integer.valueOf(String.valueOf(obj1[20])));
					     tarrifdto.setCheckinTime(dto.getCheckinTime());
					     tarrifdto.setCheckOutTime(dto.getCheckOutTime());
						  trarriflist.add(tarrifdto); 
						 }
						} 
					// 24=12+12 
					/*
					 * else { List<Object> triflistOnLocslotId=
					 * slotTarrifsRepo.gettarrifBasedOnSlot(locationId,roomId,Integer.valueOf(String
					 * .valueOf(obj[0]))); for(Object itr1:triflistOnLocslotId ) { Object[] obj1 =
					 * (Object[]) itr1;
					 * 
					 * 
					 * double baseTrarrif=Double.valueOf(String.valueOf(obj1[2]));
					 * totalTarrif=baseTrarrif ; AvailableRoomListWithTariff tarrifdto=new
					 * AvailableRoomListWithTariff();
					 * tarrifdto.setId(Integer.valueOf(String.valueOf(obj1[0])));
					 * tarrifdto.setBaseTarrif(Double.valueOf(String.valueOf(obj1[2])));
					 * tarrifdto.setTotalTarrif(totalTarrif);
					 * tarrifdto.setLocationId(Integer.valueOf(String.valueOf(obj1[3])));
					 * tarrifdto.setSlotid(Integer.valueOf(String.valueOf(obj1[4])));
					 * 
					 * //tarrifdto.setRoom_id(Integer.valueOf(String.valueOf(obj1[8])));
					 * tarrifdto.setLocationSlotId(Integer.valueOf(String.valueOf(obj1[20])));
					 * tarrifdto.setCheckinTime(dto.getCheckinTime());
					 * tarrifdto.setCheckOutTime(dto.getCheckOutTime());
					 * 
					 * System.out.println(" else Condition---------------------------");
					 * System.out.println(Integer.valueOf(String.valueOf(obj1[0])));
					 * System.out.println(Double.valueOf(String.valueOf(obj1[2])));
					 * System.out.println("slot Id "+Integer.valueOf(String.valueOf(obj1[4])));
					 * System.out.println("slot Id "+Integer.valueOf(String.valueOf(obj1[20])));
					 * 
					 * trarriflist.add(tarrifdto);
					 * 
					 * } }
					 */
					 
					 
				 }
			  
		    }else if(hours_difference<=36 && hours_difference>24  )
		    {
		    	  double totalTarrif=0.0;	
				  double baseTarrif1=0.0;
				  double baseTarrif2=0.0;
				  String chechin="";
				  String checkout="";
				  AvailableRoomListWithTariff tarrifdto1=new AvailableRoomListWithTariff();
					
					List<Object> list= slotTarrifsRepo.getslot12hrAnd24hr(locationId);
					 for(Object itr:list )
					 {
						
						 Object[] obj = (Object[]) itr;
					     LocationSlotMStDTO dto=new LocationSlotMStDTO();
						 dto.setId(Integer.valueOf(String.valueOf(obj[0])));
						 dto.setSlotId(Integer.valueOf(String.valueOf(obj[2])));
						 dto.setCheckinTime(String.valueOf(obj[3]));
						 dto.setCheckOutTime(String.valueOf(obj[5]));
						 slotList.add(dto);
						 if(checkinTime.trim().equals(dto.getCheckinTime().trim()) && checkinTime.trim().equals(dto.getCheckOutTime().trim())) {
							 
						 List<Object> triflistOnLocslotId= slotTarrifsRepo.gettarrifBasedOnSlot(locationId,roomId,Integer.valueOf(String.valueOf(obj[0])));
						 for(Object itr1:triflistOnLocslotId )
						 {
							 Object[] obj1 = (Object[]) itr1;
							 baseTarrif1=Double.valueOf(String.valueOf(obj1[2]));
							 chechin=dto.getCheckinTime();
						 }
						 }
						 
						 if(checkinTime.trim().equals(dto.getCheckinTime().trim()) && checkoutTime.trim().equals(dto.getCheckOutTime().trim())) {
								
							 List<Object> triflistOnLocslotId1= slotTarrifsRepo.gettarrifBasedOnSlot(locationId,roomId,Integer.valueOf(String.valueOf(obj[0])));
							 for(Object itr1:triflistOnLocslotId1 )
							 {
								  Object[] obj1 = (Object[]) itr1;
								   baseTarrif2=Double.valueOf(String.valueOf(obj1[2]));
								   totalTarrif=baseTarrif2 ;
								   checkout=dto.getCheckOutTime();
							  }
						 }
					}
					 
					     tarrifdto1.setBaseTarrif(baseTarrif1);
						 tarrifdto1.setCheckinTime(chechin);
						 tarrifdto1.setCheckOutTime(checkout);
						// totalTarrif=baseTarrif1+(baseTarrif1*0.25)+ baseTarrif2;
						 totalTarrif=baseTarrif2+(baseTarrif2*0.25)+ baseTarrif1;
						 tarrifdto1.setTotalTarrif(totalTarrif);
						 tarrifdto1.setLocationId(locationId);
						
						 trarriflist.add(tarrifdto1); 
						 System.out.println(" totalTarrif "+totalTarrif+"----"+baseTarrif1+" extra 0.25% "+baseTarrif1*0.25+ " baseTarrif2 "+baseTarrif2);
							
		    }
		    else if(hours_difference<=48 && hours_difference>36)
		    {
		    	
					List<Object> list= slotTarrifsRepo.getslot12hrAnd24hr(locationId);
					 for(Object itr:list )
					 {
						 Object[] obj = (Object[]) itr;
					     LocationSlotMStDTO dto=new LocationSlotMStDTO();
						 dto.setId(Integer.valueOf(String.valueOf(obj[0])));
						 dto.setSlotId(Integer.valueOf(String.valueOf(obj[2])));
						 dto.setCheckinTime(String.valueOf(obj[3]));
						 dto.setCheckOutTime(String.valueOf(obj[5]));
						 slotList.add(dto);
						 if(checkinTime.trim().equals(dto.getCheckinTime().trim()) && checkinTime.trim().equals(dto.getCheckOutTime().trim())) {
							 
						 List<Object> triflistOnLocslotId= slotTarrifsRepo.gettarrifBasedOnSlot(locationId,roomId,Integer.valueOf(String.valueOf(obj[0])));
						 for(Object itr1:triflistOnLocslotId )
						 {
							 Object[] obj1 = (Object[]) itr1;
							  
							  double baseTrarrif=Double.valueOf(String.valueOf(obj1[2]));
							  double baseTrarrif2=baseTrarrif*2;
							  double totalTarrif=baseTrarrif2 +(baseTrarrif *0.25);
							  
                             AvailableRoomListWithTariff tarrifdto=new AvailableRoomListWithTariff();
                             tarrifdto.setId(Integer.valueOf(String.valueOf(obj1[0])));
							//tarrifdto.setBaseTarrif(Double.valueOf(String.valueOf(obj1[2])));
							tarrifdto.setBaseTarrif(baseTrarrif2);
							
							 tarrifdto.setTotalTarrif(totalTarrif);
							 tarrifdto.setLocationId(Integer.valueOf(String.valueOf(obj1[3])));
							 tarrifdto.setSlotid(Integer.valueOf(String.valueOf(obj1[4])));
							 tarrifdto.setLocationSlotId(Integer.valueOf(String.valueOf(obj1[20])));
							//tarrifdto.setRoom_id(Integer.valueOf(String.valueOf(obj1[8])));
							 tarrifdto.setCheckinTime(dto.getCheckinTime());
						     tarrifdto.setCheckOutTime(dto.getCheckOutTime());
						     
							 trarriflist.add(tarrifdto); 
						 }
					 }
						 
				 }
		    }
		    else if(hours_difference>48 ) {
		    	//Booking Time Can Not More Than 48 hr.
		    	 AvailableRoomListWithTariff tarrifdto=new AvailableRoomListWithTariff();
		    	 tarrifdto.setMsg(" Booking Time Can Not More Than 48 hr. ");
		    	 trarriflist.add(tarrifdto); 
		    }
		    else {
		    	 AvailableRoomListWithTariff tarrifdto=new AvailableRoomListWithTariff();
		    	 tarrifdto.setMsg(" Slot Not availbale ");
		    	 trarriflist.add(tarrifdto); 
		    }
		return trarriflist;
		 
	 }
	 
	 
	 
	 
	 
	 public String getSlotTrarrif()
	 {
		 
		 
		 
		return null;
		 
		 
	 }
 /* public List<AvailableRoomListWithTariff> avlRoomList(int locationId,String checkInDateTime,String checkOutDateTime){
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
					
			         dto.setBaseTarrif(Double .valueOf(String.valueOf(obj[2])));
					 dto.setLocationId(Integer.valueOf(String.valueOf(obj[3])));
					 dto.setSlotid(Integer.valueOf(String.valueOf(obj[4])));
					// dto.setRoom_id(Integer.valueOf(String.valueOf(obj[8])));   
				     dto.setLocationSlotId(Integer.valueOf(String.valueOf(obj[20])));
				    }
				 
				 list1.add(dto);
				 }
			
			
		 }
		 System.out.println(list.size()+"--------");
		
		return list1;
	 }

*/


	
	 


}
