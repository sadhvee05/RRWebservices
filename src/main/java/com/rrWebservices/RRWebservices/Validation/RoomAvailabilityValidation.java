package com.rrWebservices.RRWebservices.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrWebservices.RRWebservices.Dto.PnrResponse;
import com.rrWebservices.RRWebservices.Repository.RetiringroomBookingReservationRepo;
import com.rrWebservices.RRWebservices.servicesImpl.ServicesImpl;
@Service
public class RoomAvailabilityValidation {
	DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	@Autowired
	ServicesImpl servicesImpl;
	@Autowired 
	private RetiringroomBookingReservationRepo rbrRepo;
	 SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 
	 
	 public String onlyNumericValue( String NumericValue) {
		    String msg="";
		    String str = NumericValue.replaceAll("[^0-9]", " "); 
		try {
			if(str.length()>=10 || str.length()<=18)
		{
			msg=str;
		}
		else
		{
			msg="Please Enter Only Numeric Value and not more than 18 digit: "+NumericValue;
		}
		}catch(Exception e){
			msg ="Please Enter Only Numeric Value: "+NumericValue;
		}
		return msg;
	}
	
	 public String pnrValidation(String pnr,String checkInTime,String checkOutTime )
	 {
		String msg="";
	    String strnull=null;
	    PnrResponse objetList =  servicesImpl.getPnrenquery1(pnr);
		String str = pnr.replaceAll("[^0-9]", " ");  
		try {	
		if(str.length()>=10 || str.length()<=18) //1condition:pnr only numeric and 10 ,or 18 or 10to 18 digit.
		{
			str.replaceAll("\\s", "");
			msg= "valid";
		
		 if(strnull==objetList.getTrainCancelStatus()) // 2condition: train not cancelled	
		{
			if(!objetList.getGuestsInfo().get(0).getStatus().equals("WL") || 
					!objetList.getGuestsInfo().get(0).getStatus().equals("RLWL"))// 3condition: PNR is not in wait List. 
			{
				 LocalDateTime now = LocalDateTime.now();
				 String today=now.format(DATEFORMATTER);
				 LocalDateTime  CurrentDate = LocalDateTime.parse(today, DATEFORMATTER);
				 LocalDateTime  dateofJourney =objetList.getDateOfJourney();
				 LocalDateTime  arrivaledate =objetList.getArrivalDate();
				 LocalDateTime checkInTime1 = LocalDateTime.parse(checkInTime, DATEFORMATTER);
				 LocalDateTime checkOutTime1 = LocalDateTime.parse(checkOutTime, DATEFORMATTER);
				// LocalDateTime  dateofJourneyplus2days =dateofJourney.plusDays(2);
			   //	 LocalDateTime  dateofJourneyminus2days =dateofJourney.minusDays(2);
				
				if(checkInTime1.compareTo(dateofJourney.minusDays(2))>=0 &&  checkOutTime1.compareTo(dateofJourney)<=0 )
				{
					msg="valid";
				}
				else if(checkInTime1.compareTo(arrivaledate)>=0 &&   checkOutTime1.compareTo(arrivaledate.plusDays(2))<=0 )
				{  msg="valid";
				}
				else 
				{msg="Reservation To Date should be future to Reservation From Date. Not Possible to book room.2";
				}
				//   LocalDateTime  CurrentDate = LocalDateTime.parse(today, DATEFORMATTER);
			}
			else
			{  msg="PNR is wait List. Not Possible to book room.";
			}
		}
		else
		{
		 msg=objetList.getTrainCancelStatus();	
		 
		}
		}
		else
		{   
		  msg="Please Enter Only Numeric Value and not more than 18 digit: "+pnr;
			
		}
		}
		catch(Exception e)
		{   e.printStackTrace();
			msg="Please, Enter Valid PNR Number "+e.getMessage();
		}
		return msg;
	 }
	 
	 public String loctionExistInRetiringRoom(int locationId){
		 String s="";
		 try {
			 int locationExistOrNot=rbrRepo.checkLocationId(locationId);
			 if(locationExistOrNot>=1) {
				s="RetiringRoomExist";
				}
		}catch(Exception e)
		{
			e.printStackTrace();
			s="Retiringroom is not exist On this Station";
		}
			return s;
	}
	 
	
	    // checkInTime="2023-01-23 00:00:00"; // checkOutTime="2023-01-25 00:00:00";
	   public String checkCheckingTimeAndCheckoutTime(String  checkInTime, String checkOutTime ){
			
		   String s="";
		   try { LocalDateTime now = LocalDateTime.now();
		   String today=now.format(DATEFORMATTER);
		   LocalDateTime  CurrentDate = LocalDateTime.parse(today, DATEFORMATTER);
		   LocalDateTime  checkIndate = LocalDateTime.parse(checkInTime, DATEFORMATTER);
		   
		   LocalDateTime  checkOutdate = LocalDateTime.parse(checkOutTime, DATEFORMATTER);
			if(CurrentDate.compareTo(checkIndate)== 0 || CurrentDate.compareTo(checkIndate)<0 ) {
		       
		         if(CurrentDate.compareTo(checkOutdate)<0 && checkIndate.compareTo(checkOutdate)<0)
		         {
                    s="valid";
                 }
		         else {
		        	  s="Please check checkOut DateTime,Check Out Date can't Be prior to Check In Date and Current DateTime";
		         }
		      } else {
		    	  s="Please check CheckIn DateTime, Not booking back DateTime";
		      }
		   }catch(Exception e)
		   {
			   s="Please Check, Invalid value for Day Of Month Ex: yyyy-MM-dd hh:mm:ss";
		   }
			return s;
		 
	 }
	
	 public String loctionUnderMaintenanceORNot(int locationId1,String checkInDate,String checkOutDate){
		int locationId =1111111;
		 String s2="";
		 
			Date date1 = null;
			try {
			try {
				date1 = obj.parse(checkInDate);
			} catch (ParseException e) {
				
				e.printStackTrace();
				s2="Please, check In DateTime on Location maintenance";
			}
			 Date date2 = null;
			try {
				date2 = obj.parse(checkOutDate);
			} catch (ParseException e) {
				
				e.printStackTrace();
				s2="Please, check Out DateTime on Location maintenance";
			}
			 String loctionUnderMaintenanceORNot=rbrRepo.checkloctionMaintenanceStatus(locationId, date1, date2,locationId,date2,date1);
			 s2=loctionUnderMaintenanceORNot;
			
			}catch(Exception e){
				e.printStackTrace();
				s2="Not Found data, loction is UnderMaintenance OR Not ";
			}
		 return s2;
			 
		 }
	
	
	 
	 public String loctionNotBookedMoreThan48Hr(String checkInDate, String checkOutDate)
	 {
		 
		 String s3="";
		try {
			Date date1 = obj.parse(checkInDate);
			 Date date2=obj.parse(checkOutDate);
			 long time_difference = date2.getTime() - date1.getTime();
			 long hours_difference = time_difference / (60 * 60 * 1000);     
			  if(hours_difference>48)
			  {
				  s3="booking Not more than 48 Hours";
				 }
			  else if(hours_difference<3)
			  {
				s3=" Booking Not Less Than 3 Hours";  
			  }
			  else {
				  s3="booking allowed";
			  }
			  
			  
		} catch (ParseException e) {
			e.printStackTrace();
			s3="Plaese Enter Valid DateTime";
		}
		return s3;
		 
	 }
	 

	 public String  checkingAndCheckoutTimeduration(String checkInDate, String checkOutDate)
	 {

			 String s3="";
		try {
			Date date1 = obj.parse(checkInDate);
			 Date date2=obj.parse(checkOutDate);
			 long time_difference = date2.getTime() - date1.getTime();
			 long hours_difference = time_difference / (60 * 60 * 1000);     
			 s3= String.valueOf(hours_difference); 
			  
		} catch (ParseException e) {
			e.printStackTrace();
			s3="Plaese Enter Valid DateTime";
		}
		return s3;
		 
	 }
	
	 
		public String advanceBooking(String pnr) {
			String s4 = "";
			try {
				if (pnr.length() == 10) {
					s4 = "advance booking only with PNR";
				} else if (pnr.length() > 10 || pnr.length() < 10) {
					s4 = " Wrong PNR , Please Check ";
				} else {
					s4 = " If Not PNR Advance Booking Not Possible";
				}
			} catch (Exception e) {
				e.printStackTrace();
				s4 = "Advance Booking Not Possible , Excluding PNR USER!";
			}
			return s4;

		}
		
		public String bedroomAvailability()
		{
         int noOfGuests=0;
         int roomId;
         int singleBed = 0, doubleBed = 0, dormitory = 0, familyBed = 0;
         int countselection=0;
         String msg="";
         if(countselection>0)
    	 {
         if(noOfGuests==1)
         {
        	//if(roomId)
        		 singleBed=singleBed+1;
        		 dormitory=dormitory+1;
        		 doubleBed=doubleBed+1;
        		 
        	
        	  msg="Can be allotted 1 Dormitory or 1 Double Room or 1 Single Room";
          }
          else if(noOfGuests==2)
          {
        	 msg="Can be allotted one DB Room or 2 bed in dormitory";
          }
          else if(noOfGuests==3)
          {
        	  msg="Can be allotted One DB+One SB Room or 3 bed in dormitory or 1 Family Room";
          }
          else if(noOfGuests==4)
          {
        	 msg="Two DB Rooms or up to " + noOfGuests+ " beds in dormitory or 1 Family room subject to availability" ;
          }
          else if(noOfGuests==5 || noOfGuests==6)
          {
        	  msg="Two DB Rooms or up to " + noOfGuests+ " beds in dormitory subject to availability";
          }
         
    	 }
    	 else
    	 {
    		   msg="Please select the room!....";
    	 }
			return msg;
		}
		
		
	
	

}
