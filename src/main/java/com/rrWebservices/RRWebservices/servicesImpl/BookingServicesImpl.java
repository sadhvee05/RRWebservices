package com.rrWebservices.RRWebservices.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rrWebservices.RRWebservices.Dto.LocationSlotMStDTO;
import com.rrWebservices.RRWebservices.Dto.ResponseMsgDto;
import com.rrWebservices.RRWebservices.Dto.RoomAVLCheckList;
import com.rrWebservices.RRWebservices.Dto.RoomAVList;
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
	@Autowired 
	private ServicesImpl servicesImpl;
	@Autowired 
	private SlotServicesImpl slotServicesImpl;
	 
	ResponseMsgDto dtoResponsemsg = new ResponseMsgDto();

	@Override
	public List<BookingSearchResponse> getBookingSearch(String bookingId) {
		List<BookingSearchResponse> list = new ArrayList<BookingSearchResponse>();
		List<Object> objetList = rbrRepo.getBookingSearch(bookingId, bookingId, bookingId, bookingId);
	

		if (!objetList.isEmpty() && objetList.size() > 0) {
			for (Object itr : objetList) {
				Object[] obj = (Object[]) itr;
				BookingSearchResponse dto = new BookingSearchResponse();
				dto.setId(Long.valueOf(String.valueOf(obj[0])));
				dto.setGuestId(Long.valueOf(String.valueOf(obj[1])));
				dto.setTotalAmount(Double.valueOf(String.valueOf(obj[2])));
				dto.setBookingRefNbr(String.valueOf(obj[3]));
				dto.setTransactionId(String.valueOf(obj[4]));
				dto.setPnrNbr(String.valueOf(obj[5]));
				dto.setTravelAuthority(String.valueOf(obj[6]));
				dto.setCreatedTs(String.valueOf(obj[7]));// 7

				dto.setTerminalLocation(String.valueOf(obj[8]));
				dto.setReservationStation(String.valueOf(obj[9]));
				dto.setModeOfBooking(String.valueOf(obj[10]));
				dto.setBookingStatus(String.valueOf(obj[11]));
				dto.setRoomBookingId(Long.valueOf(String.valueOf(obj[12])));
				// dto.setRoomBookingId1(String.valueOf(obj[12]));
				dto.setRoomId(Long.valueOf(String.valueOf(obj[13])));
				dto.setDateTimeReserveFrom(String.valueOf(obj[14]));// 14 private LocalDateTime createdTs;
				System.out.println(" String.valueOf(obj[14]) " + String.valueOf(obj[14]));
				dto.setDateTimeReserveTo(String.valueOf(obj[15]));// 15
				System.out.println(" String.valueOf(obj[15]) " + String.valueOf(obj[15]));
				dto.setCheckinDateTime(String.valueOf(obj[16]));// 16
				System.out.println(" String.valueOf(obj[16]) " + String.valueOf(obj[16]));
				dto.setTxnType(String.valueOf(obj[17]));
				System.out.println(" String.valueOf(obj[17]) " + String.valueOf(obj[17]));
				dto.setTransactionDate(String.valueOf(obj[18]));// 18
				System.out.println("llllllllll");
				System.out.println("String.valueOf(obj[19])" + String.valueOf(obj[19]));
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

			}
		} else {
			BookingSearchResponse dto = new BookingSearchResponse();
			dto.setErrorMsg("Not Found data on : "+bookingId);
			list.add(dto);
			// throw new ResourceNotFoundCustomException("Not Found data on "+bookingId);

		}

		return list;
	}
	
	// List<RoomAVList>
	public  List<RoomAVLCheckList> getRoomAvailabilityCheck( int stationCode, String checkInTime,String checkOutTime,String bookingType,String travelAuthref,String travelAuthoId) {
		 
		List<ResponseEntity<?>> responselist=new ArrayList<ResponseEntity<?>>();
		RoomAVLCheckList dto1=new RoomAVLCheckList();
		 RoomAVLCheckList dto=new RoomAVLCheckList();
		   List<RoomAVLCheckList> list=new ArrayList<RoomAVLCheckList>();
		   String msg="";
		try {

          // String chechkStationCode=validation.onlyNumericValue(String.valueOf(stationCode)) ;
			// String st2=validation.loctionUnderMaintenanceORNot(LocationId, checkInTime, checkOutTime);
		
		  List<Object> StationId =rbrRepo.checkStationId(stationCode);// statincode convert into locationId
		  int LocationId=(int) StationId.get(0);
		  String LocationEsit= servicesImpl.getSationExistOrNot(LocationId);
		 //if(chechkStationCode.equals("valid"))
		 //{
		 if(LocationEsit.equals("LocationExist"))
		 {
			 String ExistInRetiringRoom= validation.loctionExistInRetiringRoom(LocationId);
			 if(ExistInRetiringRoom.equals("RetiringRoomExist"))
			 {
			 String CheckinAndCheckOut=validation.checkCheckingTimeAndCheckoutTime(checkInTime,checkOutTime);
			 if(CheckinAndCheckOut.equals("valid"))
			 {
			 String st1=validation.loctionExistInRetiringRoom(LocationId); 
			 if(st1=="RetiringRoomExist")
           {
        	 System.out.println(travelAuthref+" ::");
        		if(travelAuthref.equals("pnr"))
        		{
        			 String travelAuthoId1=validation.onlyNumericValue(travelAuthoId);
        			 String  st4= validation.advanceBooking(travelAuthoId1);
        			if(st4.equals("advance booking only with PNR")) {
        				String pnrValidation=validation.pnrValidation(travelAuthoId,checkInTime,checkOutTime);
        				if(pnrValidation.equals("valid"))
        				{
        				 msg="Welcome with pnr";
        				 dto.setMsg(msg);
        				 List<RoomAVList> list1=	slotServicesImpl.getavailableroomList(LocationId, checkInTime, checkOutTime).stream().collect(Collectors.toList());
        				 dto.setRoomAVList(list1);
        				}
        				else {
        					msg=pnrValidation;
        					dto.setMsg(msg);
        				}
        			}else {msg=st4;
        			 dto.setMsg(msg);}
        		}
        		else 
        		{
        			 String st3=validation.loctionNotBookedMoreThan48Hr(checkInTime, checkOutTime);
        			/*if(travelAuthoId.equals("569875") || travelAuthoId=null || !travelAuthoId.equals("")){*/
        			 if(st3=="booking allowed") {
        				msg="welcome with other Travel Autho";
        				 dto.setMsg(msg);
        				
        				 List<RoomAVList> list1=slotServicesImpl.getavailableroomList(LocationId, checkInTime, checkOutTime).stream().collect(Collectors.toList());;
        			     dto.setRoomAVList(list1);
        				}else {msg=st3;
        				 dto.setMsg(msg);
        				}
        			/*}
        			else{
        				msg="Please check, TravelAuth ID";
        				 dto.setMsg(msg);
        				}*/
        		}
        	}
        	
         
          else 
          {msg=st1;
          dto.setMsg(msg);
          }
		 
		 }
			 else {
				 msg=CheckinAndCheckOut;
				 dto.setMsg(msg);
			 }
			 }else {
				 msg="ExistInRetiringRoom";
			 }
		 }
		 else {
			 msg=LocationEsit;
			 dto.setMsg(msg);
			
		 }
		/*}
		 else {
			 msg= chechkStationCode;
			 dto.setMsg(msg);
		 }*/
          list.add(dto);
		}catch(Exception e) 
		{
			e.printStackTrace();
			dto.setMsg("Location Not Found, Please enter valid Station");
			  list.add(dto);
		}
          
		
          
		return list;
		
	}

}
