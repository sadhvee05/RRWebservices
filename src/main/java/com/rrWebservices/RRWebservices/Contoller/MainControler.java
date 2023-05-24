package com.rrWebservices.RRWebservices.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rrWebservices.RRWebservices.Dto.CheckInCheckOutTimeResponse;
import com.rrWebservices.RRWebservices.Dto.ErrorMsg;
import com.rrWebservices.RRWebservices.Dto.PnrResponce;
import com.rrWebservices.RRWebservices.Dto.PnrResponse;
import com.rrWebservices.RRWebservices.Dto.PrincipalStationResponce;
import com.rrWebservices.RRWebservices.Dto.RoomTypeResponse;
import com.rrWebservices.RRWebservices.Services.LocationServices;
import com.rrWebservices.RRWebservices.Services.Services;

import cris.prs.rail.dto.PnrEnquiryResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController 
@RequestMapping("/rr/Webservices")
public class MainControler {

	 @Autowired
	 private  Services service;	
	 @Autowired
	 private ErrorMsg errorMsg;
	 @Autowired
	  private LocationServices  locationServices;
	 @GetMapping("/hellow")
     public String msg(){
	  	return  "hi web service";
	  }
	
	
	@GetMapping("/staionModeHourlyOrSlot/{staionId}") 
	public ResponseEntity<List<RoomTypeResponse>> getStaionModeHourlyOrSlot(@PathVariable Integer staionId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.getStaionModeHourlyOrSlot(staionId));
	}
	
	
	
    @GetMapping(value="/getPrincipalStation/{stationCd}", produces = "application/json")
	public ResponseEntity<?>  getprincipalStation(@PathVariable String stationCd)
	{
    	List<PrincipalStationResponce> list =service.getprincipalStation(stationCd);
    	if(!list.isEmpty())
		return ResponseEntity.status(HttpStatus.OK).body(service.getprincipalStation(stationCd));
    	else 
		return ResponseEntity.status(HttpStatus.OK).body(errorMsg.setMsg("Data Not Found on "+stationCd +" station"));
    	
	}
    
    @GetMapping(value="/getCheckInCheckOut/{locationId}", produces = "application/json")
	public ResponseEntity<List<CheckInCheckOutTimeResponse>>  getCheckInCheckOut(@PathVariable int locationId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(service.getCheckInCheckOut(locationId));
	}
   
    @GetMapping(value="/getPnrEnquiry/{pnr}", produces = "application/json")
   	public ResponseEntity<PnrResponse>  getPnr(@PathVariable String pnr)
   	{
    return ResponseEntity.status(HttpStatus.OK).body(service.getPnrenquery1(pnr));
   	}
   

    @GetMapping("/ip")
    public String getIp(HttpServletRequest request) {
        // Get the IP address from the request header
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // Return the IP address as a string
        return ip;
    }
    
}
