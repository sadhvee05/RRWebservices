package com.rrWebservices.RRWebservices.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rrWebservices.RRWebservices.Entity.RetiringroomBookingReservationEntity;
import com.rrWebservices.RRWebservices.Entity.RetiringroomLocationMaster;
import com.rrWebservices.RRWebservices.Services.Services;





@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/rr/Webservices/")
public class MainControler {

	  @Autowired
	 private  Services service;	
	 @GetMapping("/hellow")

	  public String msg(){
	  	System.out.println(" ::::::::::::::::::::::::::::test1");
	  	return  "hi web service";
	  }
	
	@GetMapping("/getPnrEnquiry/{data}")
	public List<RetiringroomBookingReservationEntity> getPnr(@PathVariable String data)
	{
		System.out.println(" pnr ::::::"+data);
		return service.getPnrenquery(data);
	}
	
	
	@GetMapping("/getPnrEnquiry/{pnr}")
	public List<RetiringroomBookingReservationEntity> getPnr1(@PathVariable String pnr)
	{
		System.out.println(" pnr ::::::"+pnr);
		return service.getPnrenquery(pnr);
	}
	
	@GetMapping("/roomType/{id}")
	public List<RetiringroomLocationMaster> get(@PathVariable Integer id)
	{
		System.out.println(" pnr ::::::"+id);
		return service.getRoomType(id);
	}
	

}
