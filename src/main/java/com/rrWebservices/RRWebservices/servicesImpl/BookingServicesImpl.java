package com.rrWebservices.RRWebservices.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrWebservices.RRWebservices.Exception.ResourceNotFoundCustomException;
import com.rrWebservices.RRWebservices.Repository.RetiringroomBookingReservationRepo;
import com.rrWebservices.RRWebservices.Request.RoomAvailabilityCheckRequest;
import com.rrWebservices.RRWebservices.Response.BookingSearchResponse;
import com.rrWebservices.RRWebservices.Services.BookingServices;
import com.rrWebservices.RRWebservices.Validation.RoomAvailabilityValidation;

@Service
public class BookingServicesImpl implements BookingServices {

	@Autowired 
	private RetiringroomBookingReservationRepo rbrRepo;
	@Autowired 
	private RoomAvailabilityValidation validation;
	@Override
	public List<BookingSearchResponse> getBookingSearch(String bookingId) {
		 List<BookingSearchResponse> list=new  ArrayList<BookingSearchResponse>();
		    List<Object> objetList=rbrRepo.getBookingSearch(bookingId,bookingId,bookingId,bookingId);
		    System.out.println("hhhhhhh"+objetList.size());
			
				 if(!objetList.isEmpty() && objetList.size()>0) {
					 for (Object itr : objetList) {
						 Object[] obj = (Object[]) itr;
						 BookingSearchResponse dto=new BookingSearchResponse();
					 dto.setId(Long.valueOf(String.valueOf(obj[0])));
				     dto.setGuestId(Long.valueOf(String.valueOf(obj[1])));
				     dto.setTotalAmount(Double.valueOf(String.valueOf(obj[2])));
				     dto.setBookingRefNbr(String.valueOf(obj[3]));
				     dto.setTransactionId(String.valueOf(obj[4]));
				     dto.setPnrNbr(String.valueOf(obj[5]));
				     dto.setTravelAuthority(String.valueOf(obj[6]));
				     dto.setCreatedTs(String.valueOf(obj[7]));//7
				     
				     dto.setTerminalLocation(String.valueOf(obj[8]));
				     dto.setReservationStation(String.valueOf(obj[9]));			   
				     dto.setModeOfBooking(String.valueOf(obj[10]));
				     dto.setBookingStatus(String.valueOf(obj[11]));
				   dto.setRoomBookingId(Long.valueOf(String.valueOf(obj[12])));
				     // dto.setRoomBookingId1(String.valueOf(obj[12]));
					 dto.setRoomId(Long.valueOf(String.valueOf(obj[13])));
					     dto.setDateTimeReserveFrom(String.valueOf(obj[14]));//14  private LocalDateTime createdTs;
					     System.out.println(" String.valueOf(obj[14]) "+String.valueOf(obj[14]));
					     dto.setDateTimeReserveTo(String.valueOf(obj[15]));//15
					     System.out.println(" String.valueOf(obj[15]) "+String.valueOf(obj[15]));
					     dto.setCheckinDateTime(String.valueOf(obj[16]));//16
					     System.out.println(" String.valueOf(obj[16]) "+String.valueOf(obj[16]));
					     dto.setTxnType(String.valueOf(obj[17]));
					     System.out.println(" String.valueOf(obj[17]) "+String.valueOf(obj[17]));
					     dto.setTransactionDate(String.valueOf(obj[18]));//18
					     System.out.println("llllllllll");
					     System.out.println("String.valueOf(obj[19])"+String.valueOf(obj[19]));
					     dto.setTarriffCharge(Double.valueOf(String.valueOf(obj[19])));
					     dto.setRefundAmount(Double.valueOf(String.valueOf(obj[20])));
					     dto.setTotalGstAmnt(Double.valueOf(String.valueOf(obj[21])));
					     dto.setTotalRefundGstAmnt(Double.valueOf(String.valueOf(obj[22])));
					    dto.setRoomMasterId(Long.valueOf(String.valueOf(obj[23])));
					    
					     dto.setRoomNumber(String.valueOf(obj[24]));
					     dto.setRoomType(String.valueOf(obj[25]));
					     dto.setBedType(String.valueOf(obj[26]));
					     dto.setGuestName(String.valueOf(obj[27]));
					   dto.setAge(Integer.valueOf(String.valueOf(obj[28])));
					  
					     dto.setSex(String.valueOf(obj[29]));
					     dto.setGuestRoomNumber(Integer.valueOf(String.valueOf(obj[30])));
					     dto.setGuestInfoId(Long.valueOf(String.valueOf(obj[31])));
					     dto.setMobileNumber(String.valueOf(obj[32]));
					     
					     dto.setIdentityProofType(String.valueOf(obj[33]));
					     dto.setIdentityProofNumber(String.valueOf(obj[34]));
					
					     list.add(dto);

					}}
				    else {
				    	 BookingSearchResponse dto=new BookingSearchResponse();
				    	 dto.setErrorMsg("\"Not Found data on \"+bookingId");
				         list.add(dto);
				    	  //throw new ResourceNotFoundCustomException("Not Found data on "+bookingId);
				    	 
				    }
				 
			 
			return list;
	}
	
	public String getRoomAvailabilityCheck(RoomAvailabilityCheckRequest roomAvaCheckReqt) {
		
		// String checkInDate="2023-01-23 00:00:00";
		// String checkOutDate="2023-01-25 00:00:00";
		 String travelAuthref="uts";
		  int  TravelAuthID=569875;
		 String pnr="1234567848";
		 String msg="";
		 
		 System.out.println(roomAvaCheckReqt.getBookingType());
		 System.out.println(roomAvaCheckReqt.getCheckInTime());
		 String st1=validation.loctionExistInRetiringRoom(roomAvaCheckReqt.getStationCode());
		 String st2=validation.loctionUnderMaintenanceORNot(roomAvaCheckReqt.getStationCode(), roomAvaCheckReqt.getCheckInTime(), roomAvaCheckReqt.getCheckOutTime());
		 String st3=validation.loctionNotBookedMoreThan48Hr(roomAvaCheckReqt.getCheckInTime(), roomAvaCheckReqt.getCheckOutTime());
		 String  st4= validation.advanceBooking(roomAvaCheckReqt.getTravelAuthoId());
          if(st1=="RetiringRoomExist")
          {
        	 
        	if(st2.equals("Available")) {
        		
        		if(travelAuthref=="pnr")
        		{
        			if(st4.equals("advance booking ony with PNR")) {msg="Welcome with pnr";}else {msg=st4;}
        		}
        		else 
        		{
        			if(TravelAuthID==569875) {if(st3=="booking allowed") {msg="welcome with other Travel Autho";}else {msg=st3;}}
        			else{ msg="Please check, TravelAuth ID";}
        		}
        	}
        	else
        	{
        		msg=st2;
        		}
          }
          else 
          {msg=st1;}
      
          
          
          
          
		return msg;
		
	}

}
