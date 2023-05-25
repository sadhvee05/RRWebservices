package com.rrWebservices.RRWebservices.servicesImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.rrWebservices.RRWebservices.Constant.RrConstEnum;
import com.rrWebservices.RRWebservices.Dto.CheckInCheckOutTimeResponse;
import com.rrWebservices.RRWebservices.Dto.ErrorMsg;
import com.rrWebservices.RRWebservices.Dto.GuestInfoDto;
import com.rrWebservices.RRWebservices.Dto.PnrResponce;
import com.rrWebservices.RRWebservices.Dto.PnrResponse;
import com.rrWebservices.RRWebservices.Dto.PrincipalStationResponce;
import com.rrWebservices.RRWebservices.Dto.ResponseMsgDto;
import com.rrWebservices.RRWebservices.Dto.RoomTypeResponse;
import com.rrWebservices.RRWebservices.Entity.RetiringroomBookingReservationEntity;
import com.rrWebservices.RRWebservices.Entity.RetiringroomLocationMaster;
import com.rrWebservices.RRWebservices.Exception.ResourceNotFoundCustomException;
import com.rrWebservices.RRWebservices.Repository.RetiringroomBookingReservationRepo;
import com.rrWebservices.RRWebservices.Repository.RetiringroomLocationMasterRepo;
import com.rrWebservices.RRWebservices.Services.Services;

import cris.prs.rail.BotCheck;
import cris.prs.rail.dto.PassengerDetailDTO;
import cris.prs.rail.dto.PnrEnquiryResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ServicesImpl implements Services {
	
	
	
@Autowired 
	 private RetiringroomBookingReservationRepo rrBookingReservationRepo;
	@Autowired 
	 private RetiringroomLocationMasterRepo rrLocationMasterRepo;
	@Autowired 
	 ErrorMsg errorMsg;
	ResponseMsgDto dtoResponsemsg=new ResponseMsgDto();
	
	@Override 
	 public List<RoomTypeResponse> getStaionModeHourlyOrSlot(int staionId)
	 {
	    List<RoomTypeResponse> list=new  ArrayList<RoomTypeResponse>();
	    List<RetiringroomLocationMaster> objetList=rrLocationMasterRepo.findById(staionId);
		System.out.println(objetList.size());
		 for (RetiringroomLocationMaster itr : objetList) {
			  RoomTypeResponse dto=new RoomTypeResponse();
			 if(!objetList.isEmpty()) {
				 dto.setId(itr.getId());
				 dto.setHourlyOrSlot(itr.getBookingType());
				}
			    else {

                //dto.setMsg("Data Not Found");
			    }
			 list.add(dto);
		 }
		return list;
		}
	
	public String getSationExistOrNot(int locationId)
	 {
	   // List<CheckInCheckOutTimeResponse> list=new  ArrayList<CheckInCheckOutTimeResponse>();
	    String msg="";
	   
		int location =rrBookingReservationRepo.getLocation(locationId);
		if(location==locationId)
		{
			msg="LocationExist";
		}else {
			msg="Please Enter valid Location Id";
		}
		return msg;
		 
	 }
	
	
	
	
	

	@Override 
	 public List<PrincipalStationResponce> getprincipalStation(String stationCD)
	 {
		
	    List<PrincipalStationResponce> list=new  ArrayList<PrincipalStationResponce>();
	    List<Object> objetList= rrBookingReservationRepo.principalStation(stationCD);
		System.out.println(list.size() );
		 for (Object itr : objetList) {
			 Object[] obj = (Object[]) itr;
			 PrincipalStationResponce dto=new PrincipalStationResponce();
			 if(!objetList.isEmpty()) {
				 dto.setStationid(Integer.valueOf(String.valueOf(obj[0])));
				 dto.setAreaid(Integer.valueOf(String.valueOf(obj[1])));
				 dto.setStationcode(String.valueOf(obj[2]));
				 dto.setLocationcode(String.valueOf(obj[3]));
				 dto.setLocationid(Integer.valueOf(String.valueOf(obj[4])));
				}
			    else {
			    	dto.setMsg("Data Not Found on "+stationCD);//.setMsg("Data Not Found");
			    }
			 list.add(dto);
		 }
		
		return list;
		 
	 }
	
	@Override 
	 public List<CheckInCheckOutTimeResponse> getCheckInCheckOut(int locationId)
	 {
	    List<CheckInCheckOutTimeResponse> list=new  ArrayList<CheckInCheckOutTimeResponse>();
		List<Object> objectList =rrBookingReservationRepo.getCheckInCheckOut(locationId);
		System.out.println(list.size());
		 for (Object itr : objectList) {
			 Object[] obj = (Object[]) itr;
			 CheckInCheckOutTimeResponse dto=new CheckInCheckOutTimeResponse();
			 if(!objectList.isEmpty()) {
				 dto.setCheckInTime(String.valueOf(obj[0]));
				 dto.setCheckOutTime(String.valueOf(obj[1]));
			     }
			    else {
			    	dtoResponsemsg.setMsg("Data Not found");
			  
			    }
			 list.add(dto);
		 }
		return list;
		 
	 }
	

	@Override
	public PnrResponse getPnrenquery1(String pnrNo) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Basic Y29tczo4MzYyOTNrZGprN3NsZHMzMHNhJA==");
		headers.add("Cookie", "JSESSIONID=node0juz6syh5k291xcq3c0a622vu28632081.node0");
		headers.add("Content-Type", "multipart/form-data");
		MultiValueMap<String, String> inputMap = new LinkedMultiValueMap<>();
        inputMap.add("bcheck", "one");
        HttpEntity<MultiValueMap<String, String>> entity = 
        		new HttpEntity<MultiValueMap<String, String>>(inputMap,headers);
		
		   RestTemplate template = new RestTemplate();
		   String endPointUrl = "http://10.64.28.114/service/pnrenquiry/"+pnrNo;
		   PnrEnquiryResponseDTO response = template.postForObject(endPointUrl, entity,
		   PnrEnquiryResponseDTO.class);
		   PnrResponse pnrResponse = new PnrResponse();
		   List<GuestInfoDto> guestsInfo = new ArrayList<GuestInfoDto>();
		   if(response != null && (response.getErrorMessage() == null || response.getErrorMessage().equals(""))) {
				for(PassengerDetailDTO passengerDetailDTO:response.getPassengerList()){
					GuestInfoDto guestInfo = new GuestInfoDto();
					guestInfo.setName(passengerDetailDTO.getPassengerName());
					guestInfo.setSex(passengerDetailDTO.getPassengerGender());
					guestInfo.setAge(passengerDetailDTO.getPassengerAge());
					guestInfo.setStatus(passengerDetailDTO.getCurrentStatus());
					guestInfo.setPassengerCardType(passengerDetailDTO.getPassengerCardType());
					guestInfo.setPassengerCardNumber(passengerDetailDTO.getPassengerCardNumber());
					guestInfo.setPassengerCardNumber(passengerDetailDTO.getCurrentStatus());
					guestsInfo.add(guestInfo);
				}
				pnrResponse.setGuestsInfo(guestsInfo);
				pnrResponse.setTrainName(response.getTrainName());
				pnrResponse.setTrainNumber(response.getTrainNumber());
				pnrResponse.setTrainCancelStatus(response.getTrainCancelStatus());//If train is cancelled, then this field will have mesage 'The Train Is Cancelled'. If there is no message in this field, that means train is Active.
				pnrResponse.setNoOfPassengers(response.getPassengerList().size());
				pnrResponse.setSourceStation(response.getBoardingPoint());
			    pnrResponse.setDestinationStation(response.getReservationUpto());
			    
				List<PrincipalStationResponce> sourcelist=getprincipalStation(pnrResponse.getSourceStation());
				PrincipalStationResponce dto = new PrincipalStationResponce();
				List<PrincipalStationResponce> list1=new ArrayList<PrincipalStationResponce>();
				if(sourcelist.isEmpty())
				{	
					dto.setStationcode(pnrResponse.getSourceStation());
					dto.setStationid(rrLocationMasterRepo.getStationId(pnrResponse.getSourceStation()));
				    list1.add(dto);
				    pnrResponse.setSourceStationlist( list1);
				}else
				{
					pnrResponse.setSourceStationlist( getprincipalStation(pnrResponse.getSourceStation()));
				}
				
				List<PrincipalStationResponce> destlist=getprincipalStation(pnrResponse.getDestinationStation());
				PrincipalStationResponce dto1= new PrincipalStationResponce();
				List<PrincipalStationResponce> list2=new ArrayList<PrincipalStationResponce>();
				
				if(destlist.isEmpty())
				{
					dto1.setStationcode(pnrResponse.getDestinationStation());
					dto1.setStationid(rrLocationMasterRepo.getStationId(pnrResponse.getDestinationStation()));
					list2.add(dto1);
				    pnrResponse.setDestinationStationlList(list2);
	          }else
				{
					
					pnrResponse.setDestinationStationlList( getprincipalStation(pnrResponse.getDestinationStation()));
				
				}
				
				pnrResponse.setDateOfJourney(new java.sql.Timestamp(response.getDateOfJourney().getTime()).toLocalDateTime());
				pnrResponse.setArrivalDate(new java.sql.Timestamp(response.getArrivalDate().getTime()).toLocalDateTime());
				pnrResponse.setHourlyOrSlot("0");
				int SourceStationcode =rrLocationMasterRepo.getStationId(response.getBoardingPoint());
				int DestinationStation =rrLocationMasterRepo.getStationId(response.getReservationUpto());
				pnrResponse.setSourceStationCode(SourceStationcode);
				pnrResponse.setDestinationStationCode(DestinationStation);
				}
		   else{
			   throw new ResourceNotFoundCustomException("PNR enquiry", "PNR", pnrNo,"PNR Error: "+response.getErrorMessage() );
			}
		   return pnrResponse;
		}


}
