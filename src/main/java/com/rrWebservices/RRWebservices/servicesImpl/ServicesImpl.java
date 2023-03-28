package com.rrWebservices.RRWebservices.servicesImpl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrWebservices.RRWebservices.Entity.RetiringroomBookingReservationEntity;
import com.rrWebservices.RRWebservices.Entity.RetiringroomLocationMaster;
import com.rrWebservices.RRWebservices.Repository.RetiringroomBookingReservationRepo;
import com.rrWebservices.RRWebservices.Repository.RetiringroomLocationMasterRepo;
import com.rrWebservices.RRWebservices.Services.Services;

@Service
public class ServicesImpl implements Services {
	



	@Autowired 
	 private RetiringroomBookingReservationRepo rrBookingReservationRepo;
	@Autowired 
	 private RetiringroomLocationMasterRepo rrLocationMasterRepo;
	 
	@Override 
	 public List<RetiringroomBookingReservationEntity> getPnrenquery(String pnr)
	 {
	    List<RetiringroomBookingReservationEntity> list=new  ArrayList<RetiringroomBookingReservationEntity>();
		list =rrBookingReservationRepo.findByPnr(pnr);
		System.out.println(list.size());
		return list;
		 
	 }
	@Override 
	 public List<RetiringroomLocationMaster> getRoomType(int id)
	 {
	    List<RetiringroomLocationMaster> list=new  ArrayList<RetiringroomLocationMaster>();
		list =rrLocationMasterRepo.findById(id);
		System.out.println(list.size());
		return list;
		 
	 }
	 
	
}
