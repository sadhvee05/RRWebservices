package com.rrWebservices.RRWebservices.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrWebservices.RRWebservices.Repository.RetiringroomBookingReservationRepo;
@Service
public class RoomAvailabilityValidation {
	@Autowired 
	private RetiringroomBookingReservationRepo rbrRepo;
	 SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 public String loctionExistInRetiringRoom(int locationId){
	
		   String s="";
			int locationExistOrNot =rbrRepo.checkLocationId(locationId);
			if(locationExistOrNot>=1) {
				s="RetiringRoomExist";
				}
			else
			{
				s="Retiringroom is not exist On loction";
			}
			return s;
		 
	 }
	
	 public String loctionUnderMaintenanceORNot(int locationId,String checkInDate,String checkOutDate){
		 
		 String s2="";
		 
			Date date1 = null;
			try {
				date1 = obj.parse(checkInDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 Date date2 = null;
			try {
				date2 = obj.parse(checkOutDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 String loctionUnderMaintenanceORNot=rbrRepo.checkloctionMaintenanceStatus(locationId, date1, date2,locationId,date2,date1);
			 s2=loctionUnderMaintenanceORNot;
			 System.out.println("s2 "+s2);
		
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
		}
		return s3;
		 
	 }
	
	 
	 public String advanceBooking(String pnr)
	 {
		 String s4="";
		 if(pnr.length()==10)
		 {
			s4="advance booking ony with PNR"; 
		 }
		 else if(pnr.length()>10 || pnr.length()<10 )
		 {
			 s4=" Wrong PNR , Please Check "; 
		 }
		 
		 else {
			 s4=" If Not PNR Advance Booking Not Possible";
		 }
		return s4;
		 
	 }
	
	

}
